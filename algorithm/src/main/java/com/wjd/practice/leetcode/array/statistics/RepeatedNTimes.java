package com.wjd.practice.leetcode.array.statistics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * <p>
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * <p>
 * 出并返回重复了 n 次的那个元素。
 * <p>
 *
 * @since 2022/5/21
 */
public class RepeatedNTimes {

    /**
     * 暴力法
     */
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        if (nums[mid] == nums[mid - 1]) {
            // 聚集在中间
            return nums[mid];
        } else if (nums[mid] == nums[nums.length - 1]) {
            // 聚集在右边
            return nums[mid];
        } else {
            // 聚集在左边
            return nums[0];
        }
    }

    /**
     * hash法
     */
    public int hashRepeatedNTimes(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            if (!numbers.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 数学法
     */
    public int mathRepeatedNTimes(int[] nums) {
        int n = nums.length;
        for (int gap = 1; gap <= 3; ++gap) {
            for (int i = 0; i + gap < n; ++i) {
                if (nums[i] == nums[i + gap]) {
                    return nums[i];
                }
            }
        }
        // 不可能的情况
        return -1;
    }

}
