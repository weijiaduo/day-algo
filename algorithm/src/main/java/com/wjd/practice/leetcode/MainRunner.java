package com.wjd.practice.leetcode;

import com.wjd.practice.leetcode.array.MinStartValue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainRunner {

    public static void main(String[] args) {
        // 1161. 最大层内元素和
        // run(MaxLevelSum.class);
        // 1403. 非递增顺序的最小子序列
        // run(MinSubsequence.class);
        // 623. 在二叉树中增加一行
        // run(AddOneRow.class);
        // 1408. 数组中的字符串匹配
        // run(StringMatching.class);
        // 1413. 逐步求和得到正数的最小值
        run(MinStartValue.class);
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
