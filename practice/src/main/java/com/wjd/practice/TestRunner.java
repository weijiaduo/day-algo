package com.wjd.practice;

import com.wjd.practice.util.Utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 测试运行器
 *
 * @author weijiaduo
 * @since 2022/10/1
 */
public class TestRunner {

    /**
     * 输入用例文件
     */
    final static String IN_FILE = "in.txt";
    /**
     * 输出结果文件
     */
    final static String OUT_FILE = "out.txt";
    /**
     * 用例文件目录
     */
    final static String DIR = Objects.requireNonNull(TestRunner.class.getResource("")).getPath();

    /**
     * 反射运行指定的类
     *
     * @param cls 类的Class对象
     */
    public static void run(Class<?> cls) {
        List<Method> annoTests = new ArrayList<>();
        List<Method> fileTests = new ArrayList<>();
        for (Method m : cls.getDeclaredMethods()) {
            TestCase[] testCases = m.getAnnotationsByType(TestCase.class);
            if (testCases.length > 0) {
                // 优先找注解用例方法
                annoTests.add(m);
            } else if ("solve".equals(m.getName())) {
                // 然后找特定的 solve 方法
                fileTests.add(m);
            } else if (Modifier.isPublic(m.getModifiers())) {
                // 最后找 public 方法
                fileTests.add(m);
            }
        }

        // 运行注解方法
        for (Method m : annoTests) {
            try {
                runAnnotationTestCase(cls, m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 运行其他特殊方法 solve 或 public
        for (Method m : fileTests) {
            try {
                runFileTestCase(cls, m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 基于文件输入的测试用例运行
     *
     * @param cls    测试类
     * @param method 测试方法
     */
    private static void runFileTestCase(Class<?> cls, Method method) throws Exception {
        // 构造输入输出
        InputStream ins = new FileInputStream(new File(DIR, IN_FILE));
        Input input = new Input(ins, method.getGenericParameterTypes());
        InputStream outs = new FileInputStream(new File(DIR, OUT_FILE));
        Output output = new Output(outs, method.getGenericReturnType());

        // 执行所有用例
        runTestCase(cls, method, input, output);
    }

    /**
     * 基于注解输入的测试用例运行
     *
     * @param cls    测试类
     * @param method 测试方法
     */
    private static void runAnnotationTestCase(Class<?> cls, Method method) throws Exception {
        TestCase[] testCases = method.getAnnotationsByType(TestCase.class);
        for (TestCase testCase : testCases) {
            String[] inputs = testCase.input();
            String[] outputs = testCase.output();
            if (inputs.length == 0 || (
                    outputs.length != 0 && inputs.length % outputs.length != 0)) {
                continue;
            }

            // 构造输入输出
            byte[] inBytes = String.join("\n", inputs).getBytes();
            InputStream ins = new ByteArrayInputStream(inBytes);
            Input input = new Input(ins, method.getGenericParameterTypes());
            byte[] outBytes = String.join("\n", outputs).getBytes();
            InputStream outs = new ByteArrayInputStream(outBytes);
            Output output = new Output(outs, method.getGenericReturnType());

            // 执行所有用例
            runTestCase(cls, method, input, output);
        }
    }

    /**
     * 运行指定的测试方法
     *
     * @param cls    测试类
     * @param method 测试方法
     * @param input  输入
     * @param output 输出
     */
    private static void runTestCase(Class<?> cls, Method method, Input input, Output output) throws Exception {
        System.out.println("===========================================");
        System.out.println("[Start] Running Method: " + method.getName());
        System.out.println("===========================================");
        System.out.println();

        while (true) {
            Object[] args = input.nextCase();
            Object expect = output.nextCase();
            if (args == null) {
                break;
            }

            // 打印输入
            System.out.println("input:");
            for (Object in : args) {
                System.out.println(Utils.toStr(in));
            }

            // 运行测试
            Constructor<?> constructor = cls.getConstructor();
            Object instance = constructor.newInstance();
            boolean acc = method.canAccess(instance);
            method.setAccessible(true);
            Object actual = method.invoke(instance, args);
            if (method.getReturnType().equals(Void.TYPE)) {
                // 如果没有返回值，默认输出第一个入参
                actual = args[0];
            }
            method.setAccessible(acc);

            // 打印输出
            System.out.println("expect:");
            System.out.println(Utils.toStr(expect));
            System.out.println("actual:");
            System.out.println(Utils.toStr(actual));
            System.out.println();
        }

        System.out.println("===========================================");
        System.out.println("[End  ] Running Method: " + method.getName());
        System.out.println("===========================================");
        System.out.println();
    }


}
