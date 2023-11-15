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

}
