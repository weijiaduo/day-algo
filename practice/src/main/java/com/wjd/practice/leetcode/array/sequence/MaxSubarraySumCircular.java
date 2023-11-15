package com.wjd.practice.leetcode.array.sequence;

import com.wjd.practice.TestCase;

/**
 * 918. 环形子数组的最大和
 * <p>
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * <p>
 * 环形数组 意味着数组的末端将会与开头相连呈环状。
 * <p>
 * 形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * <p>
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
 * <p>
 * 形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 3 * 10⁴
 * -3 * 10⁴ <= nums[i] <= 3 * 10⁴
 *
 * @author weijiaduo
 * @since 2023/11/15
 */
public class MaxSubarraySumCircular {

    /**
     * 思路：最大子数组和，可分为 2 种情况，
     * <p>
     * 1. 连续型 [i, j]，其中 0 <= i <= j < n
     * <p>
     * 2. 循环型 [i, n - 1] + [0, j]，其中 0 <= j <= i < n
     * <p>
     * 循环型可以转变成连续型，maxSum = totalSum - minSum，其中 minSum 是 [j, i]
     * <p>
     * 另外，当数组全是负数时，minSum = totalSum，不满足题意，因为最大子数组要求至少有一个元素
     * <p>
     * 所以当 minSum = totalSum 时需要特殊判断
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了70.34% 的Java用户
     * 内存消耗:45.2 MB,击败了60.34% 的Java用户
     */
    @TestCase(input = {"[1,-2,3,-2]", "[5,-3,5]", "[3,-2,2,-3]"},
            output = {"3", "10", "3"})
    public int maxSum(int[] nums) {
        int totalSum = 0;
        int curMax = 0, maxSum = nums[0];
        int curMin = 0, minSum = nums[0];
        for (int num : nums) {
            // 总数组和
            totalSum += num;
            // 最大子数组和
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(curMax, maxSum);
            // 最小子数组和
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(curMin, minSum);
        }
        return minSum == totalSum ? maxSum : Math.max(maxSum, totalSum - minSum);
    }

}
