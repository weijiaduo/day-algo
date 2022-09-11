package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

/**
 * 第 310 场周赛
 * <p>
 * 6177. 子字符串的最优划分
 * <p>
 * 给你一个字符串 s ，请你将该字符串划分成一个或多个 子字符串 ，并满足每个子字符串中的字符都是 唯一 的。
 * <p>
 * 也就是说，在单个子字符串中，字母的出现次数都不超过 一次 。
 * <p>
 * 满足题目要求的情况下，返回 最少 需要划分多少个子字符串。
 * <p>
 * 注意，划分后，原字符串中的每个字符都应该恰好属于一个子字符串。
 * <p>
 * 输入：s = "abacaba"
 * 输出：4
 * 解释：
 * 两种可行的划分方法分别是 ("a","ba","cab","a") 和 ("ab","a","ca","ba") 。
 * 可以证明最少需要划分 4 个子字符串。
 *
 * @author weijiaduo
 * @since 2022/9/11
 */
public class PartitionString2 implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s = "ssssss";
        int result = partitionString(s);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：贪心，尽量选更长的子串，用长度 26 的数组去重
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     *
     * @param s 字符串
     * @return 最大分割数
     */
    private int partitionString(String s) {
        int count = 0, n = s.length();
        for (int i = 0; i < n; ) {
            boolean[] arr = new boolean[26];
            for (; i < n; i++) {
                int idx = s.charAt(i) - 'a';
                if (arr[idx]) {
                    break;
                }
                arr[idx] = true;
            }
            count++;
        }
        return count;
    }

}
