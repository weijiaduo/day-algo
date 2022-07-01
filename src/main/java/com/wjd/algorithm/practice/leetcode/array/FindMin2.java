package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 154. 寻找旋转排序数组中的最小值2
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * <p>
 * 请你找出并返回数组中的 最小元素 。
 * <p>
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *
 * @author weijiaduo
 * @since 2022/7/1
 */
public class FindMin2 implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {2, 2, 4, 0};
        int result = findMin(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：二分查找，当中值存在重复值时，向左右两边寻找不相等的值，再判断二分方向
     * <p>
     * 复杂度：时间最优 O(logn) 最差 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了6.34% 的Java用户
     */
    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[right]) {
                // 向左右两边寻找非相等的值
                int p = mid;
                while (p < right && nums[p] == nums[right]) {
                    p++;
                }
                if (p == right) {
                    p = mid;
                    while (p > left && nums[p] == nums[right]) {
                        p--;
                    }
                }
                mid = p;
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    /**
     * 我喜欢官解的代码的简洁
     * <p>
     * 官解：如果中值mid和右值right相等，那么right就肯定不是最小值
     * <p>
     * 复杂度：时间最优 O(logn) 最差 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了10.32% 的Java用户
     */
    private int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

}
