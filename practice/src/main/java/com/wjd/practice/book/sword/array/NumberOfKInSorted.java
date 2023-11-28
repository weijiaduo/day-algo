package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 53. 在排序数组中查找数字
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 例如输入排序数组 {1, 2, 3, 3, 3, 3, 4, 5} 和数字 3，
 * <p>
 * 由于 3 在这个数组中出现了 4 次，因此输出 4。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class NumberOfKInSorted {

    /**
     * 思路：二分查找
     * <p>
     * 分别找出大于等于 k 的最小下标，和小于等于 k 的最大下标
     * <p>
     * 两个下标之间的元素个数就是 k 出现的次数
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3,3,3,4]", "3",
            "[1,2,3,3,3,4]", "1",
            "[1,2,3,3,3,4]", "4",
            "[1,2,3,3,3,4]", "5"},
            output = {"3", "1", "1", "0"})
    public int getNumberOfK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        // 寻找 k 的最小下标
        int left = firstGreatEquals(nums, 0, n - 1, k);
        // 验证是否存在 k
        if (left >= n || nums[left] != k) {
            return 0;
        }
        // 寻找 k + 1 的最小下标
        int right = firstGreatEquals(nums, 0, n - 1, k + 1);
        return right - left;
    }

    /**
     * 找出大于等于 k 的最小下标
     *
     * @param nums 数组
     * @param low  [low, high
     * @param high [low, high]
     * @param k    目标值
     * @return 大于等于 k 的索引，或 high + 1
     */
    private int firstGreatEquals(int[] nums, int low, int high, int k) {
        int left = low, right = high;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= k) {
                if (mid == 0 || nums[mid - 1] < k) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return high + 1;
    }

}
