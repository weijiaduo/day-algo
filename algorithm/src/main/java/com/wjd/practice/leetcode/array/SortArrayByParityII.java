package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * @since 2021-6-21
 *
 * 922. 按奇偶排序数组 II
 *
 * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 */
public class SortArrayByParityII implements Solution<int[]> {

    @Override
    public int[] solve(Object ...args) {
        int[] nums = {4,2,5,7};
        int[] result = sortArrayByParityII(nums);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 奇偶数排序
     * @param nums 数组
     * @return 排序后的数组
     */
    public int[] sortArrayByParityII(int[] nums) {
        int[] n = new int[nums.length];
        int ep = 0, op = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                n[ep] = num;
                ep += 2;
            } else {
                n[op] = num;
                op += 2;
            }
        }
        return n;
    }

}
