package com.wjd.practice.book.sword.math;

import com.wjd.practice.TestCase;

/**
 * 44. 数据序列中某一位的数字
 * <p>
 * 数字以 0123456789101112131415... 的格式序列化到一个字符序列中。
 * <p>
 * 在这个序列中，第 5 位（从 0 开始计数）是 5，第 13 位是 1，第 19 位是 4，等等。
 * <p>
 * 请写一个函数求任意位对应的数字。
 *
 * @author weijiaduo
 * @since 2023/11/27
 */
public class DigitInSequence {

    /**
     * 思路：找规律
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     */
    @TestCase(input = {"0", "5", "13", "19"},
            output = {"0", "5", "1", "4"})
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            }
            index -= digits * numbers;
            digits++;
        }
    }

    /**
     * 返回指定位数的数字数量
     * <p>
     * 比如 1 位数有 10 个，2 位数有 90 个，3 位数有 900 个
     *
     * @param n 数字位数
     * @return 数字数量
     */
    private int countOfIntegers(int n) {
        if (n == 1) {
            return 10;
        }
        return (int) Math.pow(10, n - 1) * 9;
    }

    /**
     * 返回指定位数中第 index 位的数字
     *
     * @param index 从 0 开始计数
     * @param n     指定位数
     * @return 目标数字
     */
    private int digitAtIndex(int index, int n) {
        // 比如 index = 13，n = 2
        // 找到对应的数字是 10 + 13 / 2 = 16
        int number = beginNumber(n) + index / n;
        // 找到对应数字的第 13 % 2 = 1 位，即 6
        int indexFromRight = n - index % n;
        // 找到对应的数字的第 1 位，即 6
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    /**
     * 指定位数的第一个数字
     * <p>
     * 比如 3 位数的第一个数字是 100
     * <p>
     * 比如 4 位数的第一个数字是 1000
     *
     * @param n 指定位数
     * @return 第一个数字
     */
    private int beginNumber(int n) {
        if (n == 1) {
            return 0;
        }
        return (int) Math.pow(10, n - 1);
    }

}
