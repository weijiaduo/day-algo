package com.wjd.practice.leetcode.array.sequence;

import com.wjd.practice.leetcode.TestCase;

/**
 * 334. 递增的三元子序列
 * <p>
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，
 * <p>
 * 返回true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 10⁵
 * -2³¹ <= nums[i] <= 2³¹ - 1
 *
 * @author weijiaduo
 * @since 2023/10/4
 */
public class IncreasingTriplet {

    /**
     * 思路：双向遍历，记录元素左边最小值、右边最大值，判断它们三者是否可构成三元组
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:8 ms,击败了25.48% 的Java用户
     * 内存消耗:119.19MB,击败了击败 91.68% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "[5,4,3,2,1]", "[2,1,5,0,4,6]"},
            output = {"true", "false", "true"})
    public boolean twoWayTravel(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(nums[i], leftMin[i - 1]);
        }
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
        }

        // 判断左边最小值 < 当前元素 < 右边最大值
        for (int i = 1; i < n - 1; i++) {
            if (leftMin[i - 1] < nums[i] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 思路：贪心，记录三元组的前两个值 first、second
     * <p>
     * 在遍历数组时，判断当前元素 num 与前两个元素的大小，以此来更新
     * <p>
     * 1. 若 num > second，则存在三元组
     * <p>
     * 2. 若 num > first，则更新 second = num
     * <p>
     * 3. 若 num < first，则更新 first = num，second 保持不变
     * <p>
     * 这种方式最终能得到正确结果，但是无法正确记录三元组的元素
     * <p>
     * 比如{2,4,1,5}，最终三元素的索引是 (1,4,5)，而不是 (2,4,5)
     * <p>
     * 但这并不影响最终的结果判断
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了93.71% 的Java用户
     * 内存消耗:125.30MB,击败了击败 40.30% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "[5,4,3,2,1]", "[2,1,5,0,4,6]"},
            output = {"true", "false", "true"})
    public boolean greedy(int[] nums) {
        int n = nums.length;
        int first = 0, second = -1;
        for (int i = 1; i < n; i++) {
            if (second != -1 && nums[second] < nums[i]) {
                return true;
            } else if (nums[first] < nums[i]) {
                second = i;
            } else {
                first = i;
            }
        }
        return false;
    }

}
