package com.wjd.practice.leetcode.trick;

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
 * @since 2022/10/1
 */
public class NumArray2 {

    int[] nums;
    BinaryIndexTree bit;

    /**
     * 执行用时：76 ms, 在所有 Java 提交中击败了 76.98% 的用户
     * 内存消耗：72.2 MB, 在所有 Java 提交中击败了 19.10% 的用户
     */
    public NumArray2(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        bit = new BinaryIndexTree(n + 1);
        init(this.nums);
    }

    private void init(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            bit.update(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        bit.update(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return bit.query(left + 1, right + 1);
    }

    /**
     * 树状数组
     */
    static class BinaryIndexTree {

        /**
         * 树状数组
         */
        int[] tree;
        /**
         * 数组大小
         */
        int n;

        public BinaryIndexTree(int n) {
            this.n = n;
            tree = new int[this.n];
        }

        /**
         * 单点修改
         *
         * @param index 指定下标
         * @param val   增量修改值
         */
        public void update(int index, int val) {
            while (index < n) {
                tree[index] += val;
                index = nextP(index);
            }
        }

        /**
         * 区间查询
         *
         * @param l [l, r]
         * @param r [l, r]
         * @return [l, r] 的区间和
         */
        public int query(int l, int r) {
            return query(r) - query(l - 1);
        }

        /**
         * 区间查询
         *
         * @param index (0, index]
         * @return (0, 1] 的区间和
         */
        private int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index = prevP(index);
            }
            return sum;
        }

        /**
         * 计算后一个高层节点的下标
         *
         * @param index 当前下标
         * @return 后一个高层节点的下标
         */
        int nextP(int index) {
            // 层级间隔 2^k
            int g = lowBit(index);
            // 父节点下标
            return index + g;
        }

        /**
         * 计算前一个高层节点的下标
         *
         * @param index 当前下标
         * @return 前一个高层节点的下标
         */
        int prevP(int index) {
            // 层级间隔 2^k
            int g = lowBit(index);
            // 前一个高层节点下标
            return index - g;
        }

        /**
         * index 只剩余最低位 1 的值
         *
         * @param index 值
         * @return 只剩余最低位 1 的值
         */
        private int lowBit(int index) {
            return index & (-index);
        }

    }

}
