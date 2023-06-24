package com.wjd.practice.leetcode.array.statistics;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * <p>
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * <p>
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 *
 * @author weijiaduo
 * @since 2023/6/25
 */
public class FindRepeatNumber {

    /**
     * 思路：将 nums[i] = k 交换到它排序后的位置 nums[k]
     * <p>
     * 遍历整个数组，把每个数都放到它对应的索引位置
     * <p>
     * 如果放的时候发现已经重复了，那就是重复的数字
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:52.7 MB,击败了26.83% 的Java用户
     */
    public int findRepeatNumber(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            int k = nums[i];
            if (nums[i] == nums[k]) {
                return k;
            }
            nums[i] = nums[k];
            nums[k] = k;
        }
        return -1;
    }

}
