package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;

/**
 * 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10⁹
 *
 * @author weijiaduo
 * @since 2022/6/1
 */
public class UniquePaths {

    /**
     * 思路：动态规划，二维数组动态规划
     * <p>
     * dp[i][j] 表示抵达 (i,j) 坐标的方法数
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了16.70% 的Java用户
     */
    @TestCase(input = {"3", "7", "3", "2", "7", "3"},
            output = {"28", "3", "28"})
    public int dynamic2(int m, int n) {
        // 状态定义
        // dp[i][j] 表示抵达 (i,j) 坐标的方法数量
        int[][] dp = new int[m][n];
        // 状态初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 思路：动态规划，滚动数组
     * <p>
     * 二维数组动态规划中，只用到了上边和左边2个位置的信息
     * <p>
     * 所以可以采用滚动数组的方式，优化空间
     * <p>
     * 复杂度：时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了81.99% 的Java用户
     */
    @TestCase(input = {"3", "7", "3", "2", "7", "3"},
            output = {"28", "3", "28"})
    public int dynamic1(int m, int n) {
        // 状态定义
        // dp[j] 表示抵达 (*,j) 坐标的方法数量
        int[] dp = new int[n];
        // 状态初始化
        Arrays.fill(dp, 1);
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 思路：数学，肯定要走的步数是下m-1和右n-1，因此只需要把下和右的步数组合一下，就是总数了
     * <p>
     * 注意：溢出的问题，leetcode 的机器貌似溢出的截断好像有点不同
     * <p>
     * 复杂度：时间 O(max(m,n)) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了74.95% 的Java用户
     */
    @TestCase(input = {"3", "7", "3", "2", "7", "3"},
            output = {"28", "3", "28"})
    public int math(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        // 从(0, 0)开始走的
        int min = Math.min(m - 1, n - 1);
        int max = Math.max(m - 1, n - 1);
        int num = max + min;
        // 组合数量 n!/k!(n-k)!
        long ans = 1;
        for (int i = 1; i <= num - max; i++) {
            // 边乘边除，避免溢出
            ans = ans * (max + i) / i;
        }
        return (int) ans;
    }

}
