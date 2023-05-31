package com.wjd.practice.leetcode.array.binary;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * <p>
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素，数组是从小到大排序。
 *
 * @since 2021-05-29
 */
public class SearchInsert {
    /**
     * 二分查找
     *
     * @param nums   数组
     * @param target 目标值
     * @return 插入索引
     */
    public int binarySearchInsert(int[] nums, int target) {
        int lp = 0, rp = nums.length;
        while (lp < rp) {
            int mp = lp + ((rp - lp) >> 1);
            if (nums[mp] == target) {
                return mp;
            }
            if (nums[mp] < target) {
                lp = mp + 1;
            } else {
                rp = mp;
            }
        }
        return rp;
    }
}
