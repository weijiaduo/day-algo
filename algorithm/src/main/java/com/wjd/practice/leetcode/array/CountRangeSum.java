package com.wjd.practice.leetcode.array;

import com.wjd.structure.binaryindextree.BinaryIndexTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 327. 区间和的个数
 * <p>
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。
 * <p>
 * 求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
 * <p>
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * 输入：nums = [-2,5,-1], lower = -2, upper = 2
 * 输出：3
 * 解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
 *
 * @author weijiaduo
 * @since 2022/10/21
 */
public class CountRangeSum {

    public int solve(int[] nums, int lower, int upper) {
        return bit(nums, lower, upper);
    }

    /**
     * 思路：
     * <p>
     * 区间 [i,j] 的和等于前缀和 preSum[j] - preSum[i-1]
     * <p>
     * 求满足 preSum[j] - preSum[i-1] 在区间 [lower, upper] 范围内的情况，实际上是
     * <p>
     * 求以 preSum[j] 为右边界时，左边界满足 [preSum[j]-upper, preSum[j]-lower] 区间的情况
     * <p>
     * 所以是一种区间求和的问题，可用树状数组、线段树解决。
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:650 ms,击败了16.70% 的Java用户
     * 内存消耗:139.9 MB,击败了8.67% 的Java用户
     */
    public int bit(int[] nums, int lower, int upper) {
        // 计算前缀和，注意多了一个为0的前缀和
        int n = nums.length;
        long[] preSum = new long[n + 1];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        // 统计所有可能出现的数字
        Set<Long> allNumbers = new TreeSet<>();
        for (int i = 0; i < n + 1; i++) {
            allNumbers.add(preSum[i]);
            allNumbers.add(preSum[i] - lower);
            allNumbers.add(preSum[i] - upper);
        }

        // 离散化数据
        Map<Long, Integer> indexMap = new HashMap<>();
        int idx = 1;
        for (long num : allNumbers) {
            indexMap.put(num, idx++);
        }

        // 树状数组求区间和个数
        int ans = 0;
        BinaryIndexTree b = new BinaryIndexTree(indexMap.size() + 1);
        for (int i = 0; i < n + 1; i++) {
            // 区间 [preSum[i] - upper, preSum[i] - lower] 的计数
            int left = indexMap.get(preSum[i] - upper);
            int right = indexMap.get(preSum[i] - lower);
            ans += b.query(left, right);

            // 计数加 1
            int index = indexMap.get(preSum[i]);
            b.update(index, 1);
        }
        return ans;
    }

}
