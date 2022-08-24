package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 719. 找出第K小的数对距离
 *
 * @since 2022/6/15
 */
public class SmallestDistancePair implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        return null;
    }

    /**
     * 不会啊，先打卡
     *
     *  执行耗时:5 ms,击败了98.04% 的Java用户
     *  内存消耗:41.9 MB,击败了10.02% 的Java用户
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0, j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
