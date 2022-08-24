package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 324. 摆动排序2
 * <p>
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 *
 * @author weijiaduo
 * @since 2022/6/28
 */
public class WiggleSort implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        int[] nums = {};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        return null;
    }

    /**
     * 官解：排序，然后把前半部分放偶数位置，后半部分放奇数位置
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了56.63% 的Java用户
     * 内存消耗:45.4 MB,击败了15.05% 的Java用户
     */
    private void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int m = (n + 1) / 2;
        for (int k = 0, i = m - 1, j = n - 1; k < n; k += 2, i--, j--) {
            nums[k] = arr[i];
            if (k + 1 < n) {
                nums[k + 1] = arr[j];
            }
        }
    }

}
