package com.wjd.practice.leetcode.array.prefix;

import com.wjd.practice.leetcode.TestCase;

/**
 * 724. 寻找数组的中心下标
 * <p>
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。
 * <p>
 * 这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁴
 * -1000 <= nums[i] <= 1000
 *
 * @since 2021-06-06
 */
public class PivotIndex {

    /**
     * 思路：前后缀和，分别记录前后缀和，当两者相等时，就是答案
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了66.19% 的Java用户
     * 内存消耗:43.1 MB,击败了51.45% 的Java用户
     */
    @TestCase(input = {"[1, 7, 3, 6, 5, 6]", "[1, 2, 3]", "[2, 1, -1]"},
            output = {"3", "-1", "0"})
    public int pivotIndex(int[] nums) {
        int result = -1;
        int leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int p = 0;
        while (p < nums.length) {
            if (p > 0) {
                leftSum += nums[p - 1];
            }
            rightSum -= nums[p];
            if (leftSum == rightSum) {
                result = p;
                break;
            }
            p++;
        }
        return result;
    }

}
