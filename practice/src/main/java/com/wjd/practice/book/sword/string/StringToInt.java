package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

/**
 * 67. 把字符串转换成整数
 * <p>
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * <p>
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * <p>
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * @author weijiaduo
 * @since 2023/11/30
 */
public class StringToInt {

    /**
     * 思路：模拟
     * <p>
     * 1. 先判断正负号，然后从第一个非符号位开始遍历；
     * <p>
     * 2. 遍历过程中，如果遇到非数字或者超出范围，则返回0；
     * <p>
     * 3. 遍历过程中，暂时用负数存储，因为负数范围比正数大，避免溢出
     * <p>
     * 4. 遍历结束后，如果是正数，则需要将负数转为正数，但如果超出正数范围，则返回0
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"2147483648", "2147483647", "-2147483648", "100", "-100", "+100"},
            output = {"0", "2147483647", "-2147483648", "100", "-100", "100"})
    public int strToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // 判断正负号，以及起始位置
        boolean isNegative = false;
        int startIndex = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            isNegative = str.charAt(0) == '-';
            startIndex = 1;
        }

        // 先用负数存储，因为负数范围比正数大
        int num = 0, c = Integer.MIN_VALUE / 10, r = Integer.MIN_VALUE % 10;
        for (int i = startIndex; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            // 非数字以及超出负数范围
            if (digit < 0 || digit > 9 || num < c || (num == c && -digit < r)) {
                return 0;
            }
            num = num * 10 - digit;
        }

        // 转为正数
        if (!isNegative) {
            // 超出正数范围
            if (num == Integer.MIN_VALUE) {
                num = 0;
            } else {
                num = -num;
            }
        }

        return num;
    }

}
