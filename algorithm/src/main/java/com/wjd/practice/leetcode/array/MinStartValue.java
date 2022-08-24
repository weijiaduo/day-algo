package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * 1413. 逐步求和得到正数的最小值
 * <p>
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 * <p>
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 * <p>
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 * <p>
 * 输入：nums = [-3,2,-3,4,2]
 * 输出：5
 * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
 *
 * @author weijiaduo
 * @since 2022/8/9
 */
public class MinStartValue implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {1, -2, -3};
        int result = minStartValue(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：从左往右求数组和，找到最小的数组和即可，最小值的绝对值加1就是起始值
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了70.41% 的Java用户
     *
     * @param nums 数组
     * @return 起始值
     */
    private int minStartValue(int[] nums) {
        int startValue = 1;
        int n = nums.length;
        if (n <= 0) {
            return startValue;
        }

        int min = nums[0], sum = min;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            min = Math.min(sum, min);
        }
        if (min < 0) {
            startValue = -min + 1;
        }
        return startValue;
    }

}
