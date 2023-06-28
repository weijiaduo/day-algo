package com.wjd.practice.leetcode.array.sort;

/**
 * 905. 按奇偶排序数组
 * <p>
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * @since 2021-06-21
 */
public class SortArrayByParity {

    /**
     * 奇偶数排序
     *
     * @param nums 数组
     * @return 排序后的数组
     */
    public int[] sortArrayByParity(int[] nums) {
        int[] n = new int[nums.length];
        int lp = 0, rp = n.length - 1;
        int k = 0;
        while (k < n.length) {
            if (nums[k] % 2 == 0) {
                n[lp++] = nums[k++];
            } else {
                n[rp--] = nums[k++];
            }
        }
        return n;
    }
}
