package com.wjd.practice.leetcode.array.sequence;

import com.wjd.practice.TestCase;

/**
 * 53. 最大子数组和
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 *
 * @since 2021-05-29
 */
public class MaxSubArray {

    /**
     * 思路：动态规划，定义以 i 为结尾的最大子数组和
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了44.69% 的Java用户
     * 内存消耗:56.1 MB,击败了66.08% 的Java用户
     */
    @TestCase(input = {"[-2,1,-3,4,-1,2,1,-5,4]", "[1]", "[5,4,-1,7,8]"},
            output = {"6", "1", "23"})
    public int dynamic1(int[] nums) {
        // 状态定义
        // dp[i] 表示以 nums[i] 结尾的子数组的最大和
        int n = nums.length;
        int[] dp = new int[n];

        // 状态初始化
        dp[0] = nums[0];

        // 状态转移
        // dp[i] = max(dp[i-1] + nums[i], nums[i])
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * 思路：动态规划+滚动数组，优化空间复杂度
     * <p>
     * 使用累加和来判断子数组要不要连接起来
     * <p>
     * 累加和 sum[i - 1] > 0 时，sum[i] = sum[i-1] + nums[i]
     * <p>
     * 累加和 sum[i - 1] <= 0时，sum[i] = nums[i]
     * <p>
     * 由于只用到前一个累加和，所以可以只用一个变量保存上一个累加和即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:56.3 MB,击败了16.69% 的Java用户
     */
    @TestCase(input = {"[-2,1,-3,4,-1,2,1,-5,4]", "[1]", "[5,4,-1,7,8]"},
            output = {"6", "1", "23"})
    public int dynamic0(int[] nums) {
        int maxSum = nums[0], pre = 0;
        for (int num : nums) {
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
     * 执行耗时:8 ms,击败了5.21% 的Java用户
     * 内存消耗:53.8 MB,击败了98.46% 的Java用户
     */
    @TestCase(input = {"[-2,1,-3,4,-1,2,1,-5,4]", "[1]", "[5,4,-1,7,8]"},
            output = {"6", "1", "23"})
    public int divide(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        // 如果全是负值，只取一个负数
        if (max <= 0) {
            return max;
        }

        // 分治法求取最大子数组和
        return dfs(nums, 0, nums.length - 1)[0];
    }

    /**
     * 分治法
     *
     * @param nums 数组
     * @param low  [low, high]
     * @param high [low, high]
     * @return {最大子数组和，最大前缀和，最大后缀和，区间和}
     */
    private int[] dfs(int[] nums, int low, int high) {
        if (low == high) {
            int val = Math.max(nums[low], 0);
            return new int[]{val, val, val, nums[low]};
        }

        // 分治法，计算左右区间
        int mid = low + (high - low) / 2;
        int[] ls = dfs(nums, low, mid);
        int[] rs = dfs(nums, mid + 1, high);

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
