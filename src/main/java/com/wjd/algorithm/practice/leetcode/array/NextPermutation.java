package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

import java.util.Arrays;

/**
 * @since 2021-07-07
 *
 * 31. 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class NextPermutation implements Solution<Void> {

    @Override
    public Void solve(Object args) {
        int[] nums = {5,1,1};
        nextPermutation(nums);
        ArrayUtil.print(nums);
        return null;
    }

    /**
     * 31. 下一个排列
     * @param nums 数组
     */
    private void nextPermutation(int[] nums) {
        // 寻找第一个逆序值
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        // 交换比逆序值大的最小值
        for (int i = nums.length - 1; index >= 0 && i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        // 后面这部分是降序的，倒过来转成升序
        int lp = index + 1, rp = nums.length - 1;
        while (lp < rp) {
            int temp = nums[lp];
            nums[lp++] = nums[rp];
            nums[rp--] = temp;
        }
    }

    /**
     * 31. 下一个排列
     * @param nums 数组
     */
    private void nextPermutation2(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            int index = findMinMax(nums, nums[i], i + 1, nums.length);
            if (index > -1) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    /**
     * 查找比k大的最小值的索引
     * @param nums 数组
     * @param k 指定值
     * @param start 起始索引
     * @param end 结束索引
     * @return 索引，或-1
     */
    private int findMinMax(int[] nums, int k, int start, int end) {
        int maxIndex = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] <= k) {
                continue;
            }
            if (maxIndex == -1 || nums[maxIndex] > nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
