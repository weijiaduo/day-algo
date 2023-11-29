package com.wjd.practice.book.sword.bit;

import com.wjd.practice.TestCase;

/**
 * 65. 不用加减乘除做加法
 * <p>
 * 求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author weijiaduo
 * @since 2023/11/30
 */
public class AddNumberNoASMD {

    /**
     * 思路：位运算
     * <p>
     * 1. 两个数异或，得到 a：相当于每一位相加，而不考虑进位；
     * <p>
     * 2. 两个数相与，并左移一位，得到 b：相当于求得进位；
     * <p>
     * 3. 重复上述两步计算 a 和 b，直到 b 为 0，此时 a 即为所求。
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     */
    @TestCase(input = {"-3", "-9"}, output = {"-12"})
    public int add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2; // 相加，不考虑进位
            int carry = (num1 & num2) << 1; // 进位
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

}
