package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * 164. 最大间距
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class MaximumGap implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {100,3,2,1};
        int result = maximumGap(nums);
        System.out.println(result);
        return result;
    }

    private int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int max = Arrays.stream(nums).max().getAsInt();
        int intSize = Integer.SIZE;
        int n = max / intSize;

        // 避免数组过大，用int表示32个数字
        int[] bins = new int[n + 1];
        // 记录有数据的位置，避免遍历太多无用数据
        LinkedHashSet<Integer> binSet = new LinkedHashSet<>();

        // 桶排序，将数据放入指定的桶中
        for (int num : nums) {
            int i = num / intSize;
            int j = num % intSize;
            bins[i] = bins[i] | (1 << j);
            binSet.add(i);
        }

        int maxGap = 0;
        int first = -1, second = -1;
        for (int k = 0; k <= max; k++) {
            int i = k / intSize;
            int j = k % intSize;
            if (!binSet.contains(i)) {
                // 加快遍历，跳到下一个bin
                k += intSize - 1;
                continue;
            }
            if ((bins[i] & (1 << j)) == 0) {
                continue;
            }
            second = i * intSize + j;
            if (first == - 1) {
                first = second;
                continue;
            }
            maxGap = Math.max(maxGap, second - first);
            first = second;
        }
        return maxGap;
    }

    private int maximumGap2(int[] nums) {
        return 0;
    }

}
