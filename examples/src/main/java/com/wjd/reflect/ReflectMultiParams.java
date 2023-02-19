package com.wjd.reflect;

import java.lang.reflect.Method;

/**
 * Java反射调用可变参数
 *
 * @author weijiaduo
 * @since 2022/8/20
 */
public class ReflectMultiParams {

    static class Parameters {

        public int multi(Object... args) {
            System.out.println(args.length);
            return args.length;
        }
    }

    public static void main(String[] args) throws Exception {
        testMultiParams();

        testMultiParamArr();

        testMultiParamObjectArr();

        testMultiParamArrs();

        testInvokeMultiParams();

        testInvokeMultiParamsError();
    }

    static void testMultiParams() {
        new Parameters().multi("1");
        new Parameters().multi("1", "2");
    }

    static void testMultiParamArr() {
        String[] args = new String[]{"1", "2", "3"};
        new Parameters().multi(args);
    }

    static void testMultiParamObjectArr() {
        Object[] args = new Object[]{"1", "2", "3", "4"};
        new Parameters().multi(args);
    }

    static void testMultiParamArrs() {
        Object[] arg1 = new Object[]{"1", "2", "3", "4", "5"};
        new Parameters().multi(arg1, "6");
    }

    static void testInvokeMultiParamsError() throws Exception {
        Method method = Parameters.class.getDeclaredMethod("multi", Object[].class);
        method.invoke(new Parameters(), "1", "2", "3");
    }

    static void testInvokeMultiParams() throws Exception {
        Method method = Parameters.class.getDeclaredMethod("multi", Object[].class);
        String[] methodArgs = new String[]{"1", "2", "3", "4", "5", "6"};
        Object[] invokeArgs = new Object[]{methodArgs};
        method.invoke(new Parameters(), invokeArgs);
    }

}
