package com.wjd.practice.leetcode.array.sequence;

import com.wjd.practice.TestCase;

/**
 * LCR 161. 连续天数的最高销售额
 * <p>
 * 某公司每日销售额记于整数数组 sales，请返回所有 连续 一或多天销售额总和的最大值。
 * <p>
 * 要求实现时间复杂度为 O(n) 的算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入：sales = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：[4,-1,2,1] 此连续四天的销售总额最高，为 6。
 * <p>
 * 示例 2:
 * <p>
 * 输入：sales = [5,4,-1,7,8]
 * 输出：23
 * 解释：[5,4,-1,7,8] 此连续五天的销售总额最高，为 23。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author weijiaduo
 * @since 2023/12/6
 */
public class MaxSales {

    /**
     * 思路：动态规划，定义以 i 为结尾的最大子数组和
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了49.84% 的Java用户
     * 内存消耗:49.2 MB,击败了18.99% 的Java用户
     */
    @TestCase(input = {"[-2,1,-3,4,-1,2,1,-5,4]", "[1]", "[5,4,-1,7,8]"},
            output = {"6", "1", "23"})
    public int dynamic1(int[] sales) {
        // 状态定义
        // dp[i] 表示以 sales[i] 结尾的子数组的最大和
        int n = sales.length;
        int[] dp = new int[n];

        // 状态初始化
        dp[0] = sales[0];

        // 状态转移
        // dp[i] = max(dp[i-1] + sales[i], sales[i])
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + sales[i], sales[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * 思路：动态规划+滚动数组，优化空间复杂度
     * <p>
     * 使用累加和来判断子数组要不要连接起来
     * <p>
     * 累加和 sum[i - 1] > 0 时，sum[i] = sum[i-1] + sales[i]
     * <p>
     * 累加和 sum[i - 1] <= 0时，sum[i] = sales[i]
     * <p>
     * 由于只用到前一个累加和，所以可以只用一个变量保存上一个累加和即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:49.5 MB,击败了5.79% 的Java用户
     */
    @TestCase(input = {"[-2,1,-3,4,-1,2,1,-5,4]", "[1]", "[5,4,-1,7,8]"},
            output = {"6", "1", "23"})
    public int dynamic0(int[] sales) {
        int maxSum = sales[0], pre = 0;
        for (int num : sales) {
            pre = Math.max(pre + num, num);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }

    /**
     * 思路：分治法
     * <p>
     * 将数组分割成两部分，分别找出它们的最大子数组和
     * <p>
     * 最后将它们的情况进行合并，合并时有几种情况：
     * <p>
     * 1. 最大子数组和在 left 中
     * <p>
     * 2. 最大子数组和在 right 中
     * <p>
     * 3. 最大子数组和跨越了 left 和 right，跨越结果 = left 的最大后缀和 + right 的最大前缀和
     * <p>
     * 3.1 最大子数组和 = left 的最大后缀和 + right 的最大前缀和
     * <p>
     * 3.2 最大前缀和 = max(left 的最大前缀和，left 区间和 + right 的最大前缀和）
     * <p>
     * 3.3 最大后缀和 = max(right 的最大前缀和，left 的最大后缀和 + right 区间和）
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(logn)
     * <p>
     * 执行耗时:2 ms,击败了4.75% 的Java用户
     * 内存消耗:50.3 MB,击败了5.03% 的Java用户
     */
    @TestCase(input = {"[-2,1,-3,4,-1,2,1,-5,4]", "[1]", "[5,4,-1,7,8]"},
            output = {"6", "1", "23"})
    public int divide(int[] sales) {
        int max = sales[0];
        for (int num : sales) {
            max = Math.max(num, max);
        }
        // 如果全是负值，只取一个负数
        if (max <= 0) {
            return max;
        }

        // 分治法求取最大子数组和
        return dfs(sales, 0, sales.length - 1)[0];
    }

    /**
     * 分治法
     *
     * @param sales 数组
     * @param low   [low, high]
     * @param high  [low, high]
     * @return {最大子数组和，最大前缀和，最大后缀和，区间和}
     */
    private int[] dfs(int[] sales, int low, int high) {
        if (low == high) {
            int val = Math.max(sales[low], 0);
            return new int[]{val, val, val, sales[low]};
        }

        // 分治法，计算左右区间
        int mid = low + (high - low) / 2;
        int[] ls = dfs(sales, low, mid);
        int[] rs = dfs(sales, mid + 1, high);

        // 合并分治结果
        int[] values = new int[4];
        // 最大子数组和 = max(左区间内最大和, 右区间内最大和, 跨区间最大和)
        values[0] = Math.max(Math.max(ls[0], rs[0]), ls[2] + rs[1]);
        // 最大前缀和 = max(左区间最大前缀和, 左区间和 + 右区间最大前缀和)
        values[1] = Math.max(ls[1], ls[3] + rs[1]);
        // 最大后缀和 = max(右区间最大后缀和, 左区间最大后缀和 + 右区间和)
        values[2] = Math.max(rs[2], ls[2] + rs[3]);
        // 区间和 = 左区间和 + 右区间和
        values[3] = ls[3] + rs[3];

        return values;
    }

}
