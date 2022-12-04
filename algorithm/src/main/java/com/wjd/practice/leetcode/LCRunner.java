package com.wjd.practice.leetcode;

import com.wjd.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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
        // 获取执行的方法
        Method solveMethod = null;
        for (Method method : cls.getDeclaredMethods()) {
            if ("solve".equals(method.getName())) {
                solveMethod = method;
                break;
            }
        }
        if (solveMethod == null) {
            return;
        }

        // 构造输入输出
        InputStream ins = new FileInputStream(new File(DIR, IN_FILE));
        Input input = new Input(ins, solveMethod.getParameterTypes());
        InputStream outs = new FileInputStream(new File(DIR, OUT_FILE));
        Output output = new Output(outs, solveMethod.getReturnType());

        // 执行所有用例
        while (true) {
            Object[] args = input.nextCase();
            Object expect = output.nextCase();
            if (args == null) {
                break;
            }

            // 打印输入
            System.out.println("input:");
            for (Object in : args) {
                System.out.println(StringUtils.toStr(in));
            }

            Constructor<?> constructor = cls.getConstructor();
            Object instance = constructor.newInstance();
            Object actual = solveMethod.invoke(instance, args);

            // 打印输出
            System.out.println("expect:");
            System.out.println(StringUtils.toStr(expect));
            System.out.println("actual:");
            System.out.println(StringUtils.toStr(actual));
            System.out.println();
        }
    }

}
