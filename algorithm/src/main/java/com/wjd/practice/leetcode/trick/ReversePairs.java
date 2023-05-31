package com.wjd.practice.leetcode.trick;

import com.wjd.structure.tree.binaryindex.BinaryIndexTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 493. 翻转对
 * <p>
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 *
 * @author weijiaduo
 * @since 2022/10/2
 */
public class ReversePairs {

    public int solve(int[] nums) {
        return bit(nums);
    }

    /**
     * 思路：树状数组，从右往左遍历，累计 nums[i] > 2*nums[j] 的数量 i
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:156 ms,击败了9.43% 的Java用户
     * 内存消耗:61.7 MB,击败了5.07% 的Java用户
     */
    private int bit(int[] nums) {
        int ans = 0;

        // 离散化数据
        Set<Long> numbers = new TreeSet<>();
        for (int num : nums) {
            numbers.add((long) num);
            numbers.add(2L * num + 1);
        }
        Map<Long, Integer> indexMap = new HashMap<>();
        int idx = 1;
        for (long num : numbers) {
            indexMap.put(num, idx++);
        }

        BinaryIndexTree b = new BinaryIndexTree(idx);
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            // 满足 nums[i] > 2*nums[j] 的数量 i
            int l = indexMap.get(2L * nums[j] + 1);
            ans += b.query(l, idx - 1);
            // 更新当前元素
            int index = indexMap.get((long) nums[j]);
            b.update(index, 1);
        }
        return ans;
    }

}
