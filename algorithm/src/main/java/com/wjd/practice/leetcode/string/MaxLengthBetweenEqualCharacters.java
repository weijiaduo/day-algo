package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

/**
 * 1624. 两个相同字符串之间的最长子字符串
 * <p>
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。
 * <p>
 * 如果不存在这样的子字符串，返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 *
 * @author weijiaduo
 * @since 2022/9/17
 */
public class MaxLengthBetweenEqualCharacters implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s = "cabbac";
        int result = maxLengthBetweenEqualCharacters(s);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：统计每个字符第一次出现和最后一次出现的位置，求最大差值即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了72.23% 的Java用户
     *
     * @param s 字符串
     * @return 最长字符串长度
     */
    private int maxLengthBetweenEqualCharacters(String s) {
        // index[0]第一次出现的位置，index[1]为最后一次出现的位置
        int[][] indexes = new int[26][2];
        for (int[] index : indexes) {
            index[0] = index[1] = -1;
        }

        // 统计和更新每个字符的索引
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (indexes[idx][0] == -1) {
                indexes[idx][1] = indexes[idx][0] = i;
            } else {
                indexes[idx][1] = i;
            }
        }

        // 找到索引差值最大的
        int ans = -1;
        for (int[] index : indexes) {
            ans = Math.max(ans, index[1] - index[0] - 1);
        }
        return ans;
    }

}
