package com.wjd.practice.leetcode.array.combination;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 * <p>
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对,
 * <p>
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 *
 * @since 2021-05-31
 */
public class ArrayPairSum {

    /**
     * 思路：将数组排序，总是用相邻值进行配对
     * <p>
     * 这样就能保证 min(a, b) 能够尽量大
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:12 ms,击败了97.48% 的Java用户
     * 内存消耗:44.2 MB,击败了6.44% 的Java用户
     *
     * @param nums 数组
     * @return 最大和
     */
    private int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
