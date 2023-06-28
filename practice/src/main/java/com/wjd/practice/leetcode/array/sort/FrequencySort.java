package com.wjd.practice.leetcode.array.sort;

import java.util.Arrays;

/**
 * 1636. 按照频率将数组升序排序
 * <p>
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
 * <p>
 * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 *
 * @author weijiaduo
 * @since 2022/9/19
 */
public class FrequencySort {

    /**
     * 思路：直接模拟，计数 + 排序就行
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了73.41% 的Java用户
     * 内存消耗:41.6 MB,击败了72.25% 的Java用户
     *
     * @param nums 数组
     * @return 按照频率升序的数组
     */
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] counts = new int[201];
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            counts[nums[i] + 100]++;
        }
        Arrays.sort(arr, (a, b) -> {
            if (counts[a + 100] != counts[b + 100]) {
                return counts[a + 100] - counts[b + 100];
            } else {
                return b - a;
            }
        });
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

}
