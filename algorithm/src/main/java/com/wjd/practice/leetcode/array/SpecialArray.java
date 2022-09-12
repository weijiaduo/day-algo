package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * <p>
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，
 * <p>
 * 那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * <p>
 * 注意： x 不必 是 nums 的中的元素。
 * <p>
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。
 * <p>
 * 否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的。
 * <p>
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 *
 * @author weijiaduo
 * @since 2022/9/12
 */
public class SpecialArray implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {3, 6, 7, 7, 0};
        int result = specialArray(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接模拟，求大于等于的个数，先正排序，再倒序遍历
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了81.80% 的Java用户
     * 内存消耗:39.2 MB,击败了63.01% 的Java用户
     *
     * @param nums 数组
     * @return 特征值/-1
     */
    private int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1, x = 1; i >= 0; i--, x++) {
            if (nums[i] >= x) {
                if (i == 0 || nums[i - 1] < x) {
                    return x;
                }
            }
        }
        return -1;
    }

}
