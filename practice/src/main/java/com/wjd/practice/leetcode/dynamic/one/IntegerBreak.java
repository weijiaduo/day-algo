package com.wjd.practice.leetcode.dynamic.one;

import com.wjd.practice.TestCase;

/**
 * 343. 整数拆分
 * <p>
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
 * <p>
 * 提示:
 * <p>
 * 2 <= n <= 58
 *
 * @author weijiaduo
 * @since 2023/12/6
 */
public class IntegerBreak {

    /**
     * 思路：动态规划
     * <p>
     * 定义 dp[i] 为正整数 i 拆分成 k 个正整数后的乘积最大值
     * <p>
     * 那么 dp[i] = max(dp[i-j]*j, (i-j)*j)
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了74.94% 的Java用户
     * 内存消耗:38.5 MB,击败了8.67% 的Java用户
     */
    @TestCase(input = {"2", "10"},
            output = {"1", "36"})
    public int dynamic(int n) {
        // 状态定义
        int[] dp = new int[n + 1];
        // 状态初始化
        dp[1] = 0;
        // 状态转移
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i - j] * j, (i - j) * j), dp[i]);
            }
        }
        return dp[n];
    }

    /**
     * 思路：数学
     * <p>
     * 1. 尽可能拆分成因子 3，余数可能是 0，1，2
     * <p>
     * 2. 若余数 r == 1，则将最后一个 3 和 1 组合，形成 2，2，因为 2*2 > 3*1
     * <p>
     * 3. 若余数 r == 0，则返回 pow(3, k)
     * <p>
     * 4. 若余数 r == 2，则返回 pow(3, k) * 2
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了8.67% 的Java用户
     */
    @TestCase(input = {"2", "10"},
            output = {"1", "36"})
    public int math(int n) {
        if (n <= 3) {
            // (n - 1) * 1
            return n - 1;
        }

        int e = n / 3;
        int r = n % 3;
        if (r == 0) {
            return (int) Math.pow(3, e);
        } else if (r == 1) {
            return (int) Math.pow(3, e - 1) * 4;
        } else {
            return (int) Math.pow(3, e) * 2;
        }
    }

}
