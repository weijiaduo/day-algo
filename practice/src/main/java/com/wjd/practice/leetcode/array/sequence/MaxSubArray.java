package com.wjd.practice.leetcode.array.sequence;

import com.wjd.practice.leetcode.TestCase;

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
     * 思路：使用累加和来判断子数组要不要连接起来
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
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }

}
