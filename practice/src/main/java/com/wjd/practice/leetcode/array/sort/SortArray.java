package com.wjd.practice.leetcode.array.sort;

import com.wjd.practice.TestCase;

/**
 * 912. 排序数组
 * <p>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 10⁴
 * -5 * 10⁴ <= nums[i] <= 5 * 10⁴
 *
 * @author weijiaduo
 * @since 2024/1/27
 */
public class SortArray {

    /**
     * 思路：快速排序
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:399 ms,击败了32.73% 的Java用户
     * 内存消耗:57 MB,击败了27.48% 的Java用户
     */
    @TestCase(input = {"[1,2,3,5]", "[5,1,1,2,0,0]"},
            output = {"[1,2,3,5]", "[0,0,1,1,2,5]"})
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            // 1. 分成左右 2 部分
            int mid = partition(nums, low, high);
            // 2. 对左右两边分别排序
            quicksort(nums, low, mid - 1);
            quicksort(nums, mid + 1, high);
        }
    }

    /**
     * 快排分区
     *
     * @param nums 数组
     * @param low  [low, high]
     * @param high [[low, high]
     * @return 分区点
     */
    private int partition(int[] nums, int low, int high) {
        int p = pivot(nums, low, high);
        swap(nums, low, p);
        int cmp = nums[low];
        int l = low, r = high + 1;
        while (l < r) {
            // 先走右指针，使用 > 可避免重复值很多的情况
            do {
                r--;
            } while (l < r && nums[r] > cmp);
            // 再走左指针，使用 < 可避免重复值很多的情况
            do {
                l++;
            } while (l < r && nums[l] < cmp);
            // 注意这里有可能 l > r
            if (l < r) {
                swap(nums, l, r);
            }
        }
        // 可以保证 r 肯定是属于左边的
        swap(nums, low, r);
        return r;
    }

    /**
     * 三分选取基准值
     *
     * @param nums 数组
     * @param low  [low, high]
     * @param high [low, high]
     * @return 基准值索引
     */
    private int pivot(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (nums[low] < nums[high]) {
            return nums[mid] < nums[high] ? mid : high;
        } else {
            return nums[mid] > nums[low] ? mid : low;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
