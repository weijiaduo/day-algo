package com.wjd.algorithm.practice.leetcode.structure;

import java.util.LinkedList;

public class TreeNode2 {

    public Object val;
    public TreeNode2 left;
    public TreeNode2 right;

    public TreeNode2(Object x) {
        val = x;
    }

    public static TreeNode2 buildTree(String[] s){
        if (s == null || s.length == 0){
            return null;
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("#")){
                s[i] = null;
            }
        }

        return build(s);
    }

    /**
     * 根据广度优先遍历序列（空节点为null）生成树
     */
    public static TreeNode2 build(Object[] s) {
        if (s == null || s.length == 0) {
            return null;
        }

        int i = 0;
        TreeNode2 tree = new TreeNode2(s[i++]);
        LinkedList<TreeNode2> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty() && i < s.length) {
            TreeNode2 curNode = queue.poll();

            // 左节点
            if (i < s.length) {
                Object leftVal = s[i++];

                TreeNode2 leftNode = null;
                if (leftVal != null) {
                    leftNode = new TreeNode2(leftVal);
                    queue.add(leftNode);
                }
                curNode.left = leftNode;
            }

            // 右节点
            if (i < s.length){
                Object rightVal = s[i++];
                TreeNode2 rightNode = null;
                if (rightVal != null) {
                    rightNode = new TreeNode2(rightVal);
                    queue.add(rightNode);
                }
                curNode.right = rightNode;
            }
        }

        return tree;
    }

    /**
     * 层次遍历
     */
    public static String bfs(TreeNode2 tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode2> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            TreeNode2 curNode = queue.poll();
            sb.append(curNode.val.toString());

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
     */
    public static String preorder(TreeNode2 tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // 根结点
        sb.append(tree.val.toString());

        // 左节点
        if (tree.left != null){
            sb.append(preorder(tree.left));
        }

        // 右节点
        if (tree.right != null){
            sb.append(preorder(tree.right));
        }

        return sb.toString();
    }

    /**
     * 中序遍历
     */
    public static String inorder(TreeNode2 tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // 左节点
        if (tree.left != null){
            sb.append(inorder(tree.left));
        }

        // 根结点
        sb.append(tree.val.toString());

        // 右节点
        if (tree.right != null){
            sb.append(inorder(tree.right));
        }

        return sb.toString();
    }

    /**
     * 后序遍历
     */
    public static String postorder(TreeNode2 tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // 左节点
        if (tree.left != null){
            sb.append(postorder(tree.left));
        }

        // 右节点
        if (tree.right != null){
            sb.append(postorder(tree.right));
        }

        // 根结点
        sb.append(tree.val.toString());

        return sb.toString();
    }
}
