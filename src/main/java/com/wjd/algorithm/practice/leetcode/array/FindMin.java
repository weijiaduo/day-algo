package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * <p>
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * <p>
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * <p>
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 *
 * @author weijiaduo
 * @since 2022/7/1
 */
public class FindMin implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {4, 5, 1};
        int result = findMin(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：二分查找，判断中值处于左边大值部分，还是右边的小值部分
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了5.08% 的Java用户
     */
    private int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 中值处于旋转到前面的大值部分
                left = mid + 1;
            } else {
                // 中值处于后面的小值部分，中值有可能就是最小值，所以不能+1
                right = mid;
            }
        }
        return nums[left];
    }

}
