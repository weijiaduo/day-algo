package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * 57.1 和为 S 的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * <p>
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class TwoNumbersWithSum {

    /**
     * 思路：排除法，利用递增排序的特性
     * <p>
     * 左右双指针分别指向数组的首尾，
     * <p>
     * 如果两个指针指向的数字之和大于 sum，说明右边的数字太大了，右指针左移
     * <p>
     * 如果两个指针指向的数字之和小于 sum，说明左边的数字太小了，左指针右移
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,2,4,7,11,15]", "15"}, output = {"[4,11]"})
    public List<Integer> doublePoint(int[] nums, int sum) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        // 左右双指针寻找和为 sum 的两个数
        int lp = 0, rp = nums.length - 1;
        while (lp < rp) {
            int temp = nums[lp] + nums[rp];
            if (temp == sum) {
                return Arrays.asList(nums[lp], nums[rp]);
            }
            if (temp > sum) {
                rp--;
            } else {
                lp++;
            }
        }
        return null;
    }

}
