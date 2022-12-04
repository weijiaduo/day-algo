package com.wjd.structure.tree.thread;

import com.wjd.structure.tree.TreeNode;

/**
 * 线索二叉树节点
 *
 * @author weijiaduo
 * @since 2022/12/2
 */
public class ThreadTreeNode {

    /**
     * 节点值
     */
    public int val;
    /**
     * 左子节点
     */
    public ThreadTreeNode left;
    /**
     * 右子节点
     */
    public ThreadTreeNode right;
    /**
     * 父节点（后序线索二叉树用）
     */
    public ThreadTreeNode parent;
    /**
     * 线索节点true/子节点false
     */
    public boolean lTag;
    /**
     * 线索节点true/子节点false
     */
    public boolean rTag;

    public ThreadTreeNode(TreeNode node) {
        this.val = node.val;
        this.left = node.left != null ? new ThreadTreeNode(node.left) : null;
        this.right = node.right != null ? new ThreadTreeNode(node.right) : null;
    }

    @Override
    public String toString() {
        return "" + val;
    }

}
