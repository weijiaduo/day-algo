package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 11. 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * <p>
 * 例如，数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class MinNumberInRotateArray {

    /**
     * 思路：二分查找，在循环数组内不断缩小范围
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     */
    @TestCase(input = {"3,4,5,1,2", "2,2,2,2,2", "1,2,3,3,4", "2,1"},
            output = {"1", "2", "1", "1"})
    public int find(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 已经是递增数组
            if (nums[left] < nums[right]) {
                break;
            }
            // 循环不变量：nums[left] >= nums[right]
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 左边递增，右边循环
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 左边循环，右边递增
                right = mid;
            } else {
                // 不确定左边循环还是右边循环
                // 但是可以肯定循环在 [left ,right] 内
                left++;
            }
        }
        return nums[left];
    }

}
