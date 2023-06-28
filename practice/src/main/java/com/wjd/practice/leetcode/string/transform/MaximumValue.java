package com.wjd.practice.leetcode.string.transform;

/**
 * 2496. 数组中字符串的最大值
 * <p>
 * 一个由字母和数字组成的字符串的 值 定义如下：
 * <p>
 * 如果字符串 只 包含数字，那么值为该字符串在 10 进制下的所表示的数字。
 * <p>
 * 否则，值为字符串的 长度 。
 * <p>
 * 给你一个字符串数组 strs ，每个字符串都只由字母和数字组成，请你返回 strs 中字符串的 最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["alic3","bob","3","4","00000"]
 * 输出：5
 * 解释：
 * - "alic3" 包含字母和数字，所以值为长度 5 。
 * - "bob" 只包含字母，所以值为长度 3 。
 * - "3" 只包含数字，所以值为 3 。
 * - "4" 只包含数字，所以值为 4 。
 * - "00000" 只包含数字，所以值为 0 。
 * 所以最大的值为 5 ，是字符串 "alic3" 的值。
 * <p>
 * 示例 2：
 * <p>
 * 输入：strs = ["1","01","001","0001"]
 * 输出：1
 * 解释：
 * 数组中所有字符串的值都是 1 ，所以我们返回 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 9
 * strs[i] 只包含小写英文字母和数字。
 *
 * @author weijiaduo
 * @since 2023/6/23
 */
public class MaximumValue {

    /**
     * 思路：直接遍历数组，转换所有字符串值即可
     * <p>
     * 复杂度：时间 O(nk) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.6 MB,击败了97.17% 的Java用户
     */
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String s : strs) {
            ans = Math.max(convert(s), ans);
        }
        return ans;
    }

    /**
     * 转换字符串
     * <p>
     * 1. 非数字返回字符串长度
     * <p>
     * 2. 数字时返回对应的数值
     */
    private int convert(String s) {
        int num = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                return n;
            }
            num = num * 10 + (ch - '0');
        }
        return num;
    }

}
