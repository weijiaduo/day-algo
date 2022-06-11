package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.structure.TreeNode2;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        String[] s = {"1","2","3","#","#","4","#","#","5"};
        TreeNode2 tree = TreeNode2.buildTree(s);
        System.out.println(TreeNode2.preorder(tree));
        System.out.println(TreeNode2.inorder(tree));
        System.out.println(TreeNode2.postorder(tree));

        System.out.println(maxDepth(tree));
    }

    public static int maxDepth(TreeNode2 root){
        if (root == null){
            return 0;
        }

        int depth;
        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);
        depth=1+ (ld>rd?ld:rd);

        return depth;
    }
}
