package com.wjd.practice.leetcode.string.transform;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z字形变换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @since 2022/5/13
 */
public class ZConvert {

    /**
     * 思路：以一个 V 字（去掉 Z 字的最后一列形成 V）为一个循环
     * <p>
     * 然后按照每一行遍历所有 V 字
     * <p>
     * 复杂度：时间 O(mn) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了98.70% 的Java用户
     * 内存消耗:42.5 MB,击败了91.24% 的Java用户
     */
    @TestCase(input = {"PAYPALISHIRING", "3", "PAYPALISHIRING", "4", "AB", "1"},
            output = {"PAHNAPLSIIGYIR", "PINALSIGYAHRPI", "AB"})
    public String rowScan(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        // 一个 V 字的长度（去掉 Z 字的最后一列形成 V）
        // 除了前后两行，V 的中间每一行都有 2 个字符
        final int circle = Math.max(numRows * 2 - 2, 1);
        int n = s.length();
        for (int i = 0; i < numRows; i++) {
            final int distance = (numRows - i - 1) * 2;
            // 遍历所有 V 字的同一行
            for (int j = i; j < n; ) {
                int next = Math.min(n, j + circle);
                // 一个 V 字最多有 2 个字符在同一行
                sb.append(s.charAt(j));
                if (0 < distance && j + distance < next) {
                    sb.append(s.charAt(j + distance));
                }
                j = next;
            }
        }
        return sb.toString();
    }

    /**
     * 思路：直接模拟，按照要求将遍历到的字符放入指定的行
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:5 ms,击败了78.92% 的Java用户
     * 内存消耗:42.4 MB,击败了93.50% 的Java用户
     */
    @TestCase(input = {"PAYPALISHIRING", "3", "PAYPALISHIRING", "4", "AB", "1"},
            output = {"PAHNAPLSIIGYIR", "PINALSIGYAHRPI", "AB"})
    public String orderScan(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        // 遍历所有字符，分配到指定行
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int n = s.length(), idx = 0, delta = -1;
        for (int i = 0; i < n; i++) {
            rows.get(idx).append(s.charAt(i));
            if (idx == 0 || idx == numRows - 1) {
                delta = -delta;
            }
            idx += delta;
        }

        // 拼接所有行
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }
}
