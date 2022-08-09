package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

/**
 * 132. 分割回文串2
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 *
 * @author weijiaduo
 * @since 2022/6/22
 */
public class MinCut implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s = "abqa";
        int result = minCut(s);
        System.out.println(result);
        return result;
    }

    int min;

    private int minCut(String s) {
        // min = s.length();
        // int[][] cache = new int[s.length()][s.length()];
        // dfsCache(s, 0, 0, cache);
        // return min - 1;
        return dynamic(s);
    }

    /**
     * 思路：记忆存储 + 回溯
     * <p>
     * 猜到了，应该是会超时
     * <p>
     * Time Limit Exceeded
     */
    private void dfsCache(String s, int i, int num, int[][] cache) {
        if (num > min) {
            return;
        }
        if (i >= s.length()) {
            min = num;
            return;
        }
        for (int j = s.length() - 1; j >= i; j--) {
            // -1 表示非回文
            if (cache[i][j] == -1) {
                continue;
            }
            // 0表示未校验
            if (cache[i][j] == 0) {
                if (!isPalindrome(s.substring(i, j + 1))) {
                    cache[i][j] = -1;
                    continue;
                }
            }
            // 1表示回文
            cache[i][j] = 1;
            dfsCache(s, j + 1, num + 1, cache);
        }
    }

    /**
     * 是否是回文串
     */
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 官解：双重动态规划
     * <p>
     * 官解还是牛皮，想到了第一重，没想到第二重
     * <p>
     * 执行耗时:19 ms,击败了73.38% 的Java用户
     * 内存消耗:43.3 MB,击败了13.59% 的Java用户
     */
    private int dynamic(String s) {
        int n = s.length();

        // dp[i][j]表示s[i,j]是回文串
        boolean[][] dp = new boolean[n][n];
        // 初始化状态
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i > 0) {
                dp[i][i - 1] = true;
            }
        }
        // 动态计算
        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        // flag[i]表示s[0,i]的最大分割次数
        int[] flag = new int[n];
        // 初始化状态
        flag[0] = 0;
        // 动态计算
        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                // s[0,i]是回文串
                flag[i] = 0;
            } else {
                // 看s[i]是否可以和前面的拼接成回文串
                flag[i] = flag[i - 1] + 1;
                for (int j = 0; j < i - 1; j++) {
                    if (dp[j + 1][i]) {
                        flag[i] = Math.min(flag[i], flag[j] + 1);
                    }
                }
            }
        }

        return flag[n - 1];
    }

}
