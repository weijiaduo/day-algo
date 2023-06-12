package com.wjd.practice.leetcode.array.statistics;

import java.util.Arrays;

/**
 * 第 349 场周赛
 * <p>
 * 6470. 既不是最小值也不是最大值
 * <p>
 * 给你一个整数数组 nums ，数组由 不同正整数 组成，
 * <p>
 * 请你找出并返回数组中 任一 既不是 最小值 也不是 最大值 的数字，如果不存在这样的数字，返回 -1 。
 * <p>
 * 返回所选整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,4]
 * 输出：2
 * 解释：在这个示例中，最小值是 1 ，最大值是 4 。因此，2 或 3 都是有效答案。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2]
 * 输出：-1
 * 解释：由于不存在既不是最大值也不是最小值的数字，我们无法选出满足题目给定条件的数字。因此，不存在答案，返回 -1 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,3]
 * 输出：2
 * 解释：2 既不是最小值，也不是最大值，这个示例只有这一个有效答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * nums 中的所有数字互不相同
 *
 * @author weijiaduo
 * @since 2023/6/11
 */
public class FindNonMinOrMax {

    /**
     * 灵茶山艾府题解
     * <p>
     * 思路是真的清晰啊~比我想得简单多了
     * <p>
     * 思路：随便找 3 个数，排序，中间的那个数肯定不是最大最小值
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     */
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums, 0, 3);
        return nums[1];
    }

}
