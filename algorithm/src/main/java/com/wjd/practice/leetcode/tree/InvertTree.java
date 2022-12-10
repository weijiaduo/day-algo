package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 226. 翻转二叉树
 * <p>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author weijiaduo
 * @since 2022/12/4
 */
public class InvertTree {

    public TreeNode solve(TreeNode root) {
        return invert(root);
    }

    /**
     * 思路：递归，反转左右子树
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.9 MB,击败了73.63% 的Java用户
     */
    private TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invert(root.right);
        root.right = invert(left);
        return root;
    }

}
