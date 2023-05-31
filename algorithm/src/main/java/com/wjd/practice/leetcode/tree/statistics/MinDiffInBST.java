package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * @author weijiaduo
 * @since 2022/12/17
 */
public class MinDiffInBST {

    /**
     * 最小距离
     */
    int minDistance;
    /**
     * 上一个节点
     */
    TreeNode prev;

    /**
     * 思路：中序遍历，相邻2个值的最小差值，就是最小距离
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了57.41% 的Java用户
     *
     * @param root 根节点
     * @return 最小距离
     */
    public int minDiffInBST(TreeNode root) {
        minDistance = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        prev = null;
        return minDistance;
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            minDistance = Math.min(root.val - prev.val, minDistance);
        }
        prev = root;
        inorder(root.right);
    }

}
