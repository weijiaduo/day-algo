package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

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
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * @since 2022/6/3
 */
public class MinDistance {

    /**
     * 思路：动态规划，二维动态数组
     * <p>
     * 定义 dp[i][j] 表示 w1[0...i] 和 w2[0...j] 的编辑距离
     * <p>
     * 则 dp[i][j] 可由以下几种情况得到：
     * <p>
     * 1、可由 dp[i-1][j] 或 dp[i][j-1] 删除/增加1个字符得到
     * <p>
     * 2、若 w1[i] == w2[j]，则直接有 dp[i][j] = dp[i-1][j-1]
     * <p>
     * 3、若 w1[i] != w2[j]，则可通过替换，将 w1[i] 替换成 w2[j]
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:5 ms,击败了45.74% 的Java用户
     * 内存消耗:41.1 MB,击败了91.10% 的Java用户
     */
    @TestCase(input = {"horse", "ros", "intention", "execution"},
            output = {"3", "5"})
    public int dynamic2(String word1, String word2) {
        // 状态定义
        // dp[i][j] 表示 w1[0...i) 和 w2[0...j) 的编辑距离
        // 通过 +1 可减少索引判断
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 状态初始化
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }

        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 默认可通过删除/增加字符来配对
                dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 无需额外操作，直接配对
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    // 可通过替换操作来实现配对
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 思路：动态规划，滚动数组，使用一维数组和一个临时变量替代二维数组
     * <p>
     * 这，，，神经病的~
     * <p>
     * 复杂度：时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了89.24% 的Java用户
     * 内存消耗:41.1 MB,击败了85.55% 的Java用户
     */
    @TestCase(input = {"horse", "ros", "intention", "execution"},
            output = {"3", "5"})
    public int dynamic1(String word1, String word2) {
        // 状态定义
        // dp[j] 表示 w1[0...*) 和 w2[0...j) 的编辑距离
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        // 专门保存左上角 dp[i - 1][j - 1]
        int lt;

        // 状态初始化
        for (int j = 0; j < n + 1; j++) {
            dp[j] = j;
        }

        // 状态转移
        for (int i = 1; i < m + 1; i++) {
            lt = dp[0];
            dp[0] = i;
            for (int j = 1; j < n + 1; j++) {
                int temp = dp[j];
                // 默认可通过删除/增加字符来配对
                dp[j] = 1 + Math.min(dp[j], dp[j - 1]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 无需额外操作，直接配对
                    dp[j] = Math.min(dp[j], lt);
                } else {
                    // 可通过替换操作来实现配对
                    dp[j] = Math.min(dp[j], 1 + lt);
                }
                lt = temp;
            }
        }
        return dp[n];
    }

}
