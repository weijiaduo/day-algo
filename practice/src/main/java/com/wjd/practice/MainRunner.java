package com.wjd.practice;

import com.wjd.practice.leetcode.LCRunner;
import com.wjd.practice.leetcode.array.sequence.MaximumSum;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainRunner {

    public static void main(String[] args) throws Exception {
        LCRunner.run(MaximumSum.class);
    }

    /**
     * 反射运行指定的类
     *
     * @param cls  类的Class对象
     * @param args 参数
     */
    private static void run(Class<?> cls, Object... args) {
        try {
            Constructor<?> constructor = cls.getConstructor();
            Object instance = constructor.newInstance();
            Method solveMethod = instance.getClass().getDeclaredMethod("solve", Object[].class);
            solveMethod.invoke(instance, new Object[]{args});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
