package com.wjd.practice.book.sword.tree;

import com.wjd.structure.tree.binary.TreeNode;

public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode tree = reConstructBinaryTree(pre, in);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }

        return buildByPreAndInner(pre, 0, in, 0, pre.length);
    }

    public static TreeNode buildByPreAndInner(int[] pre, int ps, int[] in, int is, int length) {
        if (length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[ps]);
        int rootIndex = is;
        while (rootIndex < in.length && in[rootIndex] != pre[ps]) {
            rootIndex++;
        }

        int len = rootIndex - is;
        root.left = buildByPreAndInner(pre, ps + 1, in, is, len);
        root.right = buildByPreAndInner(pre, ps + 1 + len, in, rootIndex + 1, length - len - 1);

        return root;
    }

}
