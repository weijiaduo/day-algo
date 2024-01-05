package com.wjd.practice.leetcode.array.sort;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 324. 摆动排序2
 * <p>
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 10⁴
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * <p>
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 *
 * @author weijiaduo
 * @since 2022/6/28
 */
public class WiggleSort {

    /**
     * 官解：排序，然后把前半部分放偶数位置，后半部分放奇数位置
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了67.81% 的Java用户
     * 内存消耗:46.5 MB,击败了14.74% 的Java用户
     */
    @TestCase(input = {"[1,5,1,1,6,4]", "[1,1,2,1,2,2,1]"},
            output = {"[1,6,1,5,1,4]", "[1,2,1,2,1,2,1]"})
    public void sort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int i = (n - 1) / 2, j = n - 1;
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                nums[k] = arr[i--];
            } else {
                nums[k] = arr[j--];
            }
        }
    }

}
