package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

/**
 * @since 2022/5/13
 * <p>
 * 6. Z字形变换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class ZConvert implements Solution<String> {

    @Override
    public String solve(Object ...args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.println(result);
        return result;
    }

    public String convert(String s, int numRows) {
        // 一个V字的长度（去掉Z字的最后一列形成V）
        final int circle = Math.max(numRows * 2 - 2, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            final int distance = (numRows - i - 1) * 2;
            // 每次按一个V字遍历
            for (int j = i; j < s.length();) {
                int next = Math.min(s.length(), j + circle);
                // 一个V字最多有2个字母在同一行
                sb.append(s.charAt(j));
                if (0 < distance && j + distance < next) {
                    sb.append(s.charAt(j + distance));
                }
                j = next;
            }
        }
        return sb.toString();
    }
}
