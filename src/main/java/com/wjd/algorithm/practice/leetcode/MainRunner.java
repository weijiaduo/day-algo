package com.wjd.algorithm.practice.leetcode;

import com.wjd.algorithm.practice.leetcode.tree.MaxLevelSum;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainRunner {

    public static void main(String[] args) {
        // 1161. 最大层内元素和
        run(MaxLevelSum.class);
    }

    /**
     * 反射运行指定的类
     *
     * @param cls  类的Class对象
     * @param args 参数
     */
    private static void run(Class<? extends Solution<?>> cls, Object... args) {
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
