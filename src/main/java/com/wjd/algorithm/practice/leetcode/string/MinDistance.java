package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 72. 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * @since 2022/6/3
 */
public class MinDistance implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String word1 = "intention";
        String word2 = "execution";
        int result = minDistance(word1, word2);
        System.out.println(result);
        return result;
    }

    /**
     * 动态规划
     *
     * 啧啧啧，没做出来，有点没想通
     *
     * 执行耗时:5 ms,击败了45.74% 的Java用户
     * 内存消耗:41.1 MB,击败了91.10% 的Java用户
     */
    public int minDistance(String word1, String word2) {
        return OneMinDistance(word1, word2);
    }

    /**
     * 动态规划
     *
     * 啧啧啧，没做出来，有点没想通
     *
     * 执行耗时:5 ms,击败了45.74% 的Java用户
     * 内存消耗:41.1 MB,击败了91.10% 的Java用户
     */
    public int TwoMinDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 动态规划
     *
     * 思路：压缩二维数组，使用一维数组和一个临时变量替代
     *
     * 这，，，神经病的~
     *
     * 执行耗时:4 ms,击败了89.24% 的Java用户
     * 内存消耗:41.1 MB,击败了85.55% 的Java用户
     */
    public int OneMinDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        int lp; // 保存左上角 dp[i - 1][j - 1]

        for (int j = 0; j < n + 1; j++) {
            dp[j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            lp = dp[0];
            dp[0] = i;
            for (int j = 1; j < n + 1; j++) {
                int temp = dp[j];
                dp[j] = 1 + Math.min(dp[j], dp[j - 1]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = Math.min(dp[j], lp);
                } else {
                    dp[j] = Math.min(dp[j], 1 + lp);
                }
                lp = temp;
            }
        }

        return dp[n];
    }

}
