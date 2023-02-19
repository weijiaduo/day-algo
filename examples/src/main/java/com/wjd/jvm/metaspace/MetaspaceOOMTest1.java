package com.wjd.jvm.metaspace;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MetaspaceOOMTest1 {

    public static void main(String[] args) {
        int count = 0;
        while (true) {
            UserService userService = createEnhancer();
            userService.create();
            System.out.println(++count);
        }
    }

    private static UserService createProxy() {
        UserServiceImpl userService = new UserServiceImpl();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class[] interfaces = userService.getClass().getInterfaces();
        InvocationHandler handler = new LogHandler(userService);
        return (UserService) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }

    private static UserService createEnhancer() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("Before invoke");
                methodProxy.invokeSuper(o, objects);
                System.out.println("After invoke");
                return null;
            }
        });
        return (UserServiceImpl) enhancer.create();
    }

}

interface UserService {
    void create();
}

class UserServiceImpl implements UserService {

    @Override
    public void create() {
        System.out.println("Create a user~~~~");
    }
}

class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler (Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke");
        method.invoke(target, args);
        System.out.println("After invoke");
        return null;
    }
}
