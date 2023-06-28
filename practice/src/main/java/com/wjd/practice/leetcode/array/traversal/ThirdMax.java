package com.wjd.practice.leetcode.array.traversal;

import java.util.Arrays;

/**
 * 414. 第三大的数
 * <p>
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * @since 2021-05-29
 */
public class ThirdMax {

    /**
     * 思路：直接用3个变量记住遍历过程中最大的3个值
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了87.96% 的Java用户
     * 内存消耗:42.5 MB,击败了5.54% 的Java用户
     *
     * @param nums 数组
     * @return 第3大的数
     */
    private int getThirdMax(int[] nums) {
        int[] maxes = new int[3];
        Arrays.fill(maxes, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0, t = i; j < maxes.length; j++) {
                if (maxes[j] < 0) {
                    maxes[j] = t;
                    break;
                }
                if (nums[t] == nums[maxes[j]]) {
                    break;
                }
                if (nums[t] > nums[maxes[j]]) {
                    int temp = t;
                    t = maxes[j];
                    maxes[j] = temp;
                }
            }
        }
        return maxes[maxes.length - 1] >= 0 ? nums[maxes[maxes.length - 1]] : nums[maxes[0]];
    }
}
