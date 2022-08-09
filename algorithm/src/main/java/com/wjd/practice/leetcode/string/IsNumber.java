package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

/**
 * 65. 有效数字
 * <p>
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数（可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * <p>
 * 部分有效数字列举如下：
 * <p>
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * <p>
 * 部分无效数字列举如下：
 * <p>
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * <p>
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * <p>
 * @since 2022/6/1
 */
public class IsNumber implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        String[] strs = {"-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        boolean result = false;
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            result = isNumber(s);
            System.out.println(result);
        }
        return result;
    }

    /**
     * 暴力法
     *
     * 思路：把字符串拆分成3份整数，小数点左边的带符号整数、小数点右边的无符号整数、E右边的带符号整数，分析3份整数即可
     *
     * 这种方式会遍历几次字符串，相比于只遍历一遍的方法会慢一点
     *
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了94.93% 的Java用户
     */
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        String numberStr, expStr = null;
        int expIndex = s.indexOf('e');
        if (expIndex < 0) {
            expIndex = s.indexOf('E');
        }
        if (expIndex >= 0) {
            numberStr = s.substring(0, expIndex);
            expStr = s.substring(expIndex + 1);
        } else {
            numberStr = s;
        }
        if (numberStr.isEmpty()) {
            return false;
        }

        // 数字
        boolean isNumber;
        int from = 0, length = numberStr.length();
        if (numberStr.charAt(0) == '+' || numberStr.charAt(0) == '-') {
            from = 1;
        }
        int pointIndex = numberStr.indexOf(".");
        if (pointIndex >= 0) {
            // 小数，小数点左右两边，至少有一边是有数字的
            isNumber = length > from + 1
                    && (from == pointIndex || isInteger(numberStr, from, pointIndex))
                    && (pointIndex + 1 == length || isInteger(numberStr, pointIndex + 1, length));
        } else {
            // 整数
            isNumber = isInteger(numberStr, from, length);
        }

        // 科学计数法
        if (isNumber && expStr != null) {
            if (expStr.isEmpty()) {
                return false;
            }
            from = 0;
            length = expStr.length();
            if (expStr.charAt(0) == '+' || expStr.charAt(0) == '-') {
                from = 1;
            }
            isNumber = isInteger(expStr, from, length);
        }

        return isNumber;
    }

    private boolean isInteger(String s, int from, int to) {
        if (from >= to) {
            return false;
        }
        for (int i = from; i < to; i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
}
