package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * 467. 环绕字符串中唯一的子字符串
 * <p>
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...."
 * <p>
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。
 * <p>
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
 * <p>
 * @since 2022/5/25
 */
public class FindSubstringInWraproundString implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        String p = "cac";
        int result = findSubstringInWraproundString(p);
        System.out.println(result);
        return result;
    }

    /**
     * 真不会写啊
     *
     * 执行耗时:9 ms,击败了22.68% 的Java用户
     * 内存消耗:41 MB,击败了79.82% 的Java用户
     */
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) { // 字符之差为 1 或 -25
                ++k;
            } else {
                k = 1;
            }
            int c = p.charAt(i) - 'a';
            dp[c] = Math.max(dp[c], k);
        }
        return Arrays.stream(dp).sum();
    }
}
