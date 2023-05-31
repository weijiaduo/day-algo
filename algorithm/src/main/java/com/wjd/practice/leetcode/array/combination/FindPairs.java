package com.wjd.practice.leetcode.array.combination;

import java.util.Arrays;

/**
 * 532. 数组中的 k-diff 数对
 * <p>
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * <p>
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * <p>
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * <p>
 * 注意，|val| 表示 val 的绝对值。
 * <p>
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * <p>
 *
 * @since 2022/6/16
 */
public class FindPairs {

    /**
     * 思路有点乱，先打卡
     * <p>
     * 执行用时：4 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了 56.31% 的用户
     */
    public int findPair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, y = 0, res = 0;
        for (int x = 0; x < n; x++) {
            if (x == 0 || nums[x] != nums[x - 1]) {
                while (y < n && (nums[y] < nums[x] + k || y <= x)) {
                    y++;
                }
                if (y < n && nums[y] == nums[x] + k) {
                    res++;
                }
            }
        }
        return res;
    }

}
