package com.wjd.algorithm.practice.leetcode.structure;

import java.util.LinkedList;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode buildTree(String[] s){
        if (s == null || s.length == 0){
            return null;
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i] == "#"){
                s[i] = null;
            }
        }

        return build(s);
    }

    /**
     * 根据广度优先遍历序列（空节点为null）生成树
     *
     * @param s
     * @return
     */
    public static TreeNode build(String[] s) {
        if (s == null || s.length == 0) {
            return null;
        }

        int i = 0;
        TreeNode tree = new TreeNode(Integer.parseInt(s[i++]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            // 左节点
            if (i < s.length) {
                String leftVal = s[i++];
                TreeNode leftNode = null;
                if (leftVal != null) {
                    leftNode = new TreeNode(Integer.parseInt(leftVal));
                    queue.add(leftNode);
                }
                curNode.left = leftNode;
            }

            // 右节点
            if (i < s.length) {
                String rightVal = s[i++];
                TreeNode rightNode = null;
                if (rightVal != null) {
                    rightNode = new TreeNode(Integer.parseInt(rightVal));
                    queue.add(rightNode);
                }
                curNode.right = rightNode;
            }
        }

        return tree;
    }

    /**
     * 层次遍历
     *
     * @param tree
     * @return
     */
    public static String breadthTraverse(TreeNode tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            sb.append(curNode.val);

            if (curNode.left != null){
                queue.add(curNode.left);
            }

            if (curNode.right != null){
                queue.add(curNode.right);
            }
        }

        return sb.toString();
    }

    /**
     * 前序遍历
     *
     * @param tree
     * @return
     */
    public static String preTraverse(TreeNode tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // 根结点
        sb.append(tree.val);

        // 左节点
        if (tree.left != null){
            sb.append(preTraverse(tree.left));
        }

        // 右节点
        if (tree.right != null){
            sb.append(preTraverse(tree.right));
        }

        return sb.toString();
    }

    /**
     * 中序遍历
     *
     * @param tree
     * @return
     */
    public static String innerTraverse(TreeNode tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // 左节点
        if (tree.left != null){
            sb.append(innerTraverse(tree.left));
        }

        // 根结点
        sb.append(tree.val);

        // 右节点
        if (tree.right != null){
            sb.append(innerTraverse(tree.right));
        }

        return sb.toString();
    }

    /**
     * 后序遍历
     *
     * @param tree
     * @return
     */
    public static String postTraverse(TreeNode tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // 左节点
        if (tree.left != null){
            sb.append(postTraverse(tree.left));
        }

        // 右节点
        if (tree.right != null){
            sb.append(postTraverse(tree.right));
        }

        // 根结点
        sb.append(tree.val);

        return sb.toString();
    }
}
