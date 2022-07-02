package com.wjd.algorithm.practice.leetcode.math;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 168. Excel表列名称
 * <p>
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * <p>
 * 输入：columnNumber = 701
 * 输出："ZY"
 *
 * @author weijiaduo
 * @since 2022/7/3
 */
public class ConvertToTitle implements Solution<String> {

    @Override
    public String solve(Object... args) {
        int columnNumber = 2147483647;
        String result = convertToTitle(columnNumber);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：和转成2进制的除法一样，取余反转，这个就是转成26进制而已
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了17.63% 的Java用户
     */
    private String convertToTitle(int columnNumber) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber -= 1;
            int r = columnNumber % n;
            sb.append(s.charAt(r));
            columnNumber = columnNumber / n;
        }
        return sb.reverse().toString();
    }

}
