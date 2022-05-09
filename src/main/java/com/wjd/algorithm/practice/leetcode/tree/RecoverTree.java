package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.structure.TreeNode2;

/**
 * 二叉搜索树的两个节点被交换了，
 * 请恢复其原状，不能改变树结构
 *
 */
public class RecoverTree {

    public static void main(String[] args) {
        String[] s = {"2","3","1"};
        TreeNode2 tree = TreeNode2.buildTree(s);
        System.out.println(TreeNode2.postTraverse(tree));

        recoverTree(tree);
        System.out.println(TreeNode2.innerTraverse(tree));
    }

    public static void recoverTree(TreeNode2 root) {
        if (root == null) {
            return;
        }

        TreeNode2[] swap = new TreeNode2[3];
        swap[0] = null;
        swap[1] = null;
        swap[2] = null;

        dfsTree(root, swap);

        if (swap[0] != null && swap[1] != null) {
            Object temp = swap[0].val;
//            int temp = swap[0].val;
            swap[0].val = swap[1].val;
            swap[1].val = temp;
        }
    }

    public static void dfsTree(TreeNode2 root, TreeNode2[] swap) {
        if (root == null) {
            return;
        }

        dfsTree(root.left, swap);
        if (swap[2] != null) {
            int val = Integer.parseInt(root.val.toString());
            //int val = root.val;
            int pVal = Integer.parseInt(swap[2].val.toString());
            //int pVal = swap[2].val;
            if (pVal > val) {
                if (swap[0] == null) {
                    swap[0] = swap[2];
                }
                swap[1] = root;
            }
        }
        swap[2] = root;
        dfsTree(root.right, swap);
    }

}
