package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.structure.TreeNode;

/**
 * 验证一棵树是二叉搜索树
 */
public class ValidBST {

    public static TreeNode pre;

    public static void main(String[] args) {
        String[] s = {"10", "10"};
        TreeNode tree = TreeNode.buildTree(s);
        System.out.println(TreeNode.postTraverse(tree));

        System.out.println(isValidBST(tree));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (pre!=null && pre.val >= root.val){
            return false;
        }

        pre = root;
        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }
}
