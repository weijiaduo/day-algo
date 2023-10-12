package com.wjd.practice.leetcode;

import com.wjd.practice.leetcode.structure.ListNode;
import com.wjd.structure.tree.binary.TreeNode;
import com.wjd.structure.tree.generic.Node;
import com.wjd.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;

/**
 * 力扣运行器
 *
 * @author weijiaduo
 * @since 2022/10/1
 */
public class LCRunner {

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
    final static String DIR = Objects.requireNonNull(LCRunner.class.getResource("")).getPath();

    /**
     * 反射运行指定的类
     *
     * @param cls 类的Class对象
     */
    public static void run(Class<?> cls) throws Exception {
        // 优先找注解用例方法
        boolean found = false;
        for (Method m : cls.getDeclaredMethods()) {
            TestCase[] testCases = m.getAnnotationsByType(TestCase.class);
            if (testCases.length > 0) {
                found = true;
                runAnnotationTestCase(cls, m);
            }
        }
        if (found) {
            return;
        }

        // 然后找特定的 solve 方法
        for (Method m : cls.getDeclaredMethods()) {
            if ("solve".equals(m.getName())) {
                runFileTestCase(cls, m);
                return;
            }
        }

        // 最后找 public 方法
        for (Method m : cls.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())) {
                runFileTestCase(cls, m);
                return;
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
        Input input = new Input(ins, method.getParameterTypes());
        InputStream outs = new FileInputStream(new File(DIR, OUT_FILE));
        Output output = new Output(outs, method.getReturnType());

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
                System.out.println(toStr(in));
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
            System.out.println(toStr(expect));
            System.out.println("actual:");
            System.out.println(toStr(actual));
            System.out.println();
        }

        System.out.println("===========================================");
        System.out.println("[End  ] Running Method: " + method.getName());
        System.out.println("===========================================");
        System.out.println();
    }

    private static String toStr(Object object) {
        // 链表节点
        if (object instanceof ListNode) {
            return ListNode.listString((ListNode) object);
        }
        // 树
        if (object instanceof Node) {
            return Node.traverse((Node) object).toString();
        }
        // 二叉树
        if (object instanceof TreeNode) {
            return TreeNode.traverse((TreeNode) object).toString();
        }
        return StringUtils.toStr(object);
    }

}
