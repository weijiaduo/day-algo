package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 * @author weijiaduo
 * @since 2022/12/16
 */
public class RangeSumBST {

    /**
     * 思路：递归，判断复合范围的值就继续，反之返回 0
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:48.7 MB,击败了65.93% 的Java用户
     *
     * @param root 根节点
     * @param low  下边界[low, high]
     * @param high 上边界[low, high]
     * @return 区间和
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }
        if (low <= root.val) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val <= high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }

}
