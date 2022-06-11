package com.wjd.algorithm.practice.leetcode.tree;


import com.wjd.algorithm.practice.leetcode.structure.TreeNode;

/**
 * 求树的最小高度
 */
public class MinimumTreeDepth {

    public static void main(String[] args) {
        Integer[] s = {2,3};
        TreeNode tree = TreeNode.build(s);
        System.out.println(TreeNode.postorder(tree));

        System.out.println(getMinimumDepth(tree));
    }

    public static int getMinimumDepth(TreeNode root){
        if (root == null) {
            return 0;
        }

        int ld = getMinimumDepth(root.left);
        int rd = getMinimumDepth(root.right);

        if (ld == 0) {
            return rd + 1;
        }

        if (rd == 0) {
            return ld + 1;
        }

        return ld < rd ? ld + 1 : rd + 1;
    }
}
