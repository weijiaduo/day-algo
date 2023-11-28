package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 53.2 0~n-1 中缺失的数字
 * <p>
 * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，
 * <p>
 * 并且每个数字都在范围 0~n-1 之内。
 * <p>
 * 在范围 0~n-1 内的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class MissingNumber {

    /**
     * 思路：二分法，找到第一个 nums[i] != i 的元素
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     */
    @TestCase(input = {"[0,1,2,3,4,5,6,7]",
            "[1,1,2,3,4,5,6,7]",
            "[0,1,2,3,3,5,6,7]"},
            output = {"8", "0", "4"})
    public int find(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 如果 0~n-1 都没有缺失，说明缺失的是 n
        return n;
    }


}
