package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

/**
 * 20. 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * <p>
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author weijiaduo
 * @since 2023/11/24
 */
public class NumericStrings {

    /**
     * 思路：分段扫描
     * <p>
     * 一个数字可以分成三个部分：整数部分、小数部分、指数部分
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"+100", "5e2", "-123", "3.1416", "-1E-16", "12e", "1a3.14", "1.2.3", "+-5", "12e+4.3"},
            output = {"true", "true", "true", "true", "true", "false", "false", "false", "false", "false"})
    public boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return isNumeric(str.toCharArray());
    }

    private boolean isNumeric(char[] str) {
        int n = str.length;
        // 整数部分
        int i = scanInteger(str, 0);
        // 小数部分
        if (i != -1 && i < n && str[i] == '.') {
            i = scanUnsignedInteger(str, i + 1);
        }
        // 指数部分
        if (i != -1 && i < n && (str[i] == 'e' || str[i] == 'E')) {
            i = scanInteger(str, i + 1);
        }

        return i == n;
    }

    /**
     * 扫描整数
     *
     * @param str 字符串
     * @param i   开始下标
     * @return 结束下标
     */
    private int scanInteger(char[] str, int i) {
        if (i < str.length && (str[i] == '+' || str[i] == '-')) {
            i++;
        }
        return scanUnsignedInteger(str, i);
    }

    /**
     * 扫描无符号整数
     *
     * @param str 字符串
     * @param i   开始下标
     * @return 结束下标
     */
    private int scanUnsignedInteger(char[] str, int i) {
        int n = str.length, start = i;
        while (i < n && str[i] >= '0' && str[i] <= '9') {
            i++;
        }
        return i > start ? i : -1;
    }

}
