package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 53.3 数组中数值和下标相等的元素
 * <p>
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * <p>
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * <p>
 * 例如，在数组 {-3, -1, 1, 3, 5} 中，数字 3 和它的下标相等。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class NumberSameAsIndex {

    /**
     * 思路：二分法
     * <p>
     * 找到中间值，如果中间值等于下标，说明找到了
     * <p>
     * 如果中间值大于下标，说明右边的元素都大于下标，所以只需要在左边找
     * <p>
     * 如果中间值小于下标，说明左边的元素都小于下标，所以只需要在右边找
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     */
    @TestCase(input = {"[-3,-1,1,3,5]"}, output = {"3"})
    public int find(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                return mid;
            }
            if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // 不存在
    }

}
