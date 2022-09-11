package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.structure.segmenttree.MaxSegmentTree;

/**
 * 6206. 最长递增子序列 II
 * <p>
 * 给你一个整数数组nums和一个整数k。
 * <p>
 * 找到nums中满足以下要求的最长子序列：
 * <p>
 * 子序列 严格递增
 * 子序列中相邻元素的差值 不超过k。
 * 请你返回满足上述要求的 最长子序列的长度。
 * <p>
 * 子序列是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。
 *
 * @author weijiaduo
 * @since 2022/9/11
 */
public class LengthOfLIS2 implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {7, 4, 5, 1, 8, 12, 4, 7};
        int k = 5;
        int result = lengthOfLIS(nums, k);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：线段树，在线段树中保存以该节点为结尾的最长递增子序列的长度
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行用时：108 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：51.1 MB, 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums 数组
     * @param k    间距
     * @return 最长子序列长度
     */
    private int lengthOfLIS(int[] nums, int k) {
        int ans = 0;
        int low = 1, high = (int) 1e5;
        MaxSegmentTree tree = new MaxSegmentTree(low, high);
        for (int num : nums) {
            int max = tree.query(Math.max(1, num - k), Math.max(1, num - 1)) + 1;
            tree.update(num, num, max);
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
