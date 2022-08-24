package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * 剑指 Offer II 115. 重建序列
 *
 * @author weijiaduo
 * @since 2022/7/23
 */
public class SequenceReconstruction implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        return null;
    }

    private boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[nums[i]] = i;
        }

        boolean[] flags = new boolean[n];
        for (int[] sequence : sequences) {
            int lastIndex = -1;
            for (int num : sequence) {
                if (indexes[num] < lastIndex) {
                    return false;
                }
                lastIndex = indexes[num];
                flags[num] = true;
            }
        }

        for (boolean flag : flags) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

}
