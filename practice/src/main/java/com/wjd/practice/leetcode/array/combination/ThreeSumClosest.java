package com.wjd.practice.leetcode.array.combination;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * <p>
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10⁴ <= target <= 10⁴
 *
 * @since 2021-07-01
 */
public class ThreeSumClosest {

    /**
     * 思路：排序+二分，先固定一个值，
     * <p>
     * 然后用二分法枚举剩余的 2 个值，尽量接近目标值即可
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:10 ms,击败了95.17% 的Java用户
     * 内存消耗:41.5 MB,击败了65.85% 的Java用户
     */
    @TestCase(input = {"[-1,2,1,-4]", "1", "[0,0,0]", "1"},
            output = {"2", "0"})
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0, n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int sum = twoSumClosest(nums, target - nums[i], i + 1, n - 1);
            sum += nums[i];
            if (sum == target) {
                return sum;
            }
            if (i == 0 || Math.abs(sum - target) < Math.abs(closestSum - target)) {
                closestSum = sum;
            }
        }
        return closestSum;
    }

    /**
     * 最近的2数之和
     *
     * @param nums   排序数组
     * @param target 目标值
     * @param start  起始索引
     * @param end    终止索引
     * @return 2数之和
     */
    private int twoSumClosest(int[] nums, int target, int start, int end) {
        int lp = start, rp = end;
        int sum = nums[lp] + nums[rp];
        while (lp < rp) {
            int temp = nums[lp] + nums[rp];
            if (temp == target) {
                return target;
            }
            if (Math.abs(temp - target) < Math.abs(sum - target)) {
                sum = temp;
            }
            if (temp < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return sum;
    }

}
