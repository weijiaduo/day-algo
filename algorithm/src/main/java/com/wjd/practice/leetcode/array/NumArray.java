package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.segment.LinkSegmentTree;

/**
 * 307. 区域和检索 - 数组可修改
 * <p>
 * 给你一个数组 nums ，请你完成两类查询。
 * <p>
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
 * 素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 *
 * @author weijiaduo
 * @since 2022/9/12
 */
public class NumArray implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1,2,5]
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8
        return null;
    }

    SumSegmentTree segmentTree;
    int low = 0;
    int high = (int) 3e4;

    public NumArray() {
    }

    public NumArray(int[] nums) {
        segmentTree = new SumSegmentTree(low, high);
        for (int i = 0; i < nums.length; i++) {
            this.update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        segmentTree.update(index, index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(left, right);
    }

    /**
     * 思路：线段树，节点保存区间和
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:147 ms,击败了21.92% 的Java用户
     * 内存消耗:67.1 MB,击败了91.53% 的Java用户
     */
    static class SumSegmentTree extends LinkSegmentTree {

        public SumSegmentTree(int low, int high) {
            super(low, high);
        }

        /**
         * @implNote 查询指定区间和
         */
        @Override
        protected int mergeQuery(Node node, int start, int end, Integer lVal, Integer rVal) {
            int sum = 0;
            if (lVal != null) {
                sum += lVal;
            }
            if (rVal != null) {
                sum += rVal;
            }
            return sum;
        }

        /**
         * @implNote 向上更新区间和
         */
        @Override
        protected void writeUp(Node node, int start, int end) {
            node.val = node.left.val + node.right.val;
        }

        /**
         * @implNote 向下覆盖更新区间值，同时更新懒惰标记
         */
        @Override
        protected void writeDown(Node node, int start, int end, int val) {
            node.val = val;
            node.add = val;
        }

    }

}
