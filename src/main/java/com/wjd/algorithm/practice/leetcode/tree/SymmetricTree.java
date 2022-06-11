package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.structure.TreeNode2;

/**
 * 镜像树
 *
 */
public class SymmetricTree {

    public static void main(String[] args) {
        String[] s = {"1","2","2","3","4","4","3"};
        TreeNode2 tree = TreeNode2.buildTree(s);
        System.out.println(TreeNode2.postorder(tree));

        System.out.println(isSymmetric(tree));
    }

    public static boolean isSymmetric(TreeNode2 root) {
        return isSymmetric(root, root);
    }

    /**
     * 镜像树
     *
     * @param tree1
     * @param tree2
     * @return
     */
    public static boolean isSymmetric(TreeNode2 tree1, TreeNode2 tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 != null && tree2 != null) {
            if (tree1.val.equals(tree2.val)) {
                return (isSymmetric(tree1.left, tree2.right) && isSymmetric(tree1.right, tree2.left));
            }
        }

        return false;
    }

    /**
     * 相同的树
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode2 p, TreeNode2 q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {
            if (p.val.equals(q.val)) {
                return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
            }
        }

        return false;
    }
}
