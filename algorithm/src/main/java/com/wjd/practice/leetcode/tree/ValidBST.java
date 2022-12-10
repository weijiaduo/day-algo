package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 验证一棵树是二叉搜索树
 */
public class ValidBST {

    public static TreeNode pre;

    public static void main(String[] args) {
        Integer[] s = {10, 10};
        TreeNode tree = TreeNode.build(s);

        System.out.println(isValidBST(tree));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;
        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }
}
