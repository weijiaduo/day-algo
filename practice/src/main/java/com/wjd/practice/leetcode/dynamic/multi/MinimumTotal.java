package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10⁴ <= triangle[i][j] <= 10⁴
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * @since 2022/6/19
 */
public class MinimumTotal {

    /**
     * 思路：动态规划，使用二维数据计算路径上的和
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n^2)
     * <p>
     * 执行耗时:4 ms,击败了37.61% 的Java用户
     * 内存消耗:42.9 MB,击败了21.60% 的Java用户
     */
    @TestCase(input = {"[[2],[3,4],[6,5,7],[4,1,8,3]]", "[[-10]]"},
            output = {"11", "-10"})
    public int dynamic2(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        // 状态定义
        // dp[i][j] 表示第 i 行第 j 列的最小路径和
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[n][n];

        // 状态初始化
        dp[0][0] = triangle.get(0).get(0);

        // 状态转移
        // dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + val
        for (int i = 1; i < n; i++) {
            List<Integer> level = triangle.get(i);
            int j = 0;
            for (Integer val : level) {
                if (j == 0) {
                    // 首位元素
                    dp[i][j] = dp[i - 1][j] + val;
                } else if (j == i) {
                    // 末尾元素
                    dp[i][j] = dp[i - 1][j - 1] + val;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + val;
                }
                j++;
            }
        }
        return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
    }

    /**
     * 思路：动态规划+滚动数组，把二维数组压缩成一维数组，减低空间复杂度
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了78.28% 的Java用户
     * 内存消耗:43 MB,击败了10.07% 的Java用户
     */
    @TestCase(input = {"[[2],[3,4],[6,5,7],[4,1,8,3]]", "[[-10]]"},
            output = {"11", "-10"})
    public int dynamic11(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        // 状态定义
        // dp[j] 表示第 j 列的最小路径和
        int n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n];

        // 状态初始化
        dp[0] = triangle.get(0).get(0);

        // 状态转移
        // dp[j] = Math.min(dp[j], dp[j - 1]) + val
        for (int i = 1; i < n; i++) {
            List<Integer> level = triangle.get(i);
            for (int j = level.size() - 1; j >= 0; j--) {
                int val = level.get(j);
                if (j > 0) {
                    if (j < i) {
                        dp[j] = Math.min(dp[j], dp[j - 1]);
                    } else if (j == i) {
                        dp[j] = dp[j - 1];
                    }
                }
                dp[j] += val;
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    /**
     * 思路：动态规划，自底向上计算最小值，避免后面还要遍历一次
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了96.08% 的Java用户
     * 内存消耗:43 MB,击败了13.26% 的Java用户
     */
    @TestCase(input = {"[[2],[3,4],[6,5,7],[4,1,8,3]]", "[[-10]]"},
            output = {"11", "-10"})
    public int dynamic12(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        // 状态定义
        // dp[j] 表示第 j 列的最小路径和
        int size = triangle.size();
        int n = triangle.get(size - 1).size();
        int[] dp = new int[n];

        // 状态初始化
        List<Integer> level = triangle.get(size - 1);
        for (int i = 0; i < level.size(); i++) {
            dp[i] = level.get(i);
        }

        // 状态转移
        // dp[j] = Math.min(dp[j], dp[j + 1]) + val
        for (int i = size - 2; i >= 0; i--) {
            level = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + level.get(j);
            }
        }
        return dp[0];
    }

}
