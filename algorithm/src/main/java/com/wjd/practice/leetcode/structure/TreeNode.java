package com.wjd.practice.leetcode.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 根据广度优先遍历序列（空节点为null）生成树
     */
    public static TreeNode build(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        int i = 0;
        TreeNode tree = new TreeNode(values[i++]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 左节点
            if (i < values.length) {
                Integer leftVal = values[i++];
                TreeNode leftNode = null;
                if (leftVal != null) {
                    leftNode = new TreeNode(leftVal);
                    queue.add(leftNode);
                }
                node.left = leftNode;
            }

            // 右节点
            if (i < values.length) {
                Integer rightVal = values[i++];
                TreeNode rightNode = null;
                if (rightVal != null) {
                    rightNode = new TreeNode(rightVal);
                    queue.add(rightNode);
                }
                node.right = rightNode;
            }
        }

        return tree;
    }

    /**
     * 层次遍历
     */
    public static List<Integer> bfs(TreeNode tree){
        if (tree == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int notNull = queue.size();
        while (!queue.isEmpty() && notNull >= 1) {
            TreeNode node = queue.poll();
            notNull--;
            if (node == null) {
                list.add(null);
                continue;
            }

            list.add(node.val);

            queue.add(node.left);
            if (node.left != null) {
                notNull = queue.size();
            }

            queue.add(node.right);
            if (node.right != null) {
                notNull = queue.size();
            }
        }

        return list;
    }

    /**
     * 前序遍历
     */
    public static String preorder(TreeNode tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // 根结点
        sb.append(tree.val);

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
    public static String inorder(TreeNode tree){
        if (tree == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // 左节点
        if (tree.left != null){
            sb.append(inorder(tree.left));
        }

        // 根结点
        sb.append(tree.val);

        // 右节点
        if (tree.right != null){
            sb.append(inorder(tree.right));
        }

        return sb.toString();
    }

    /**
     * 后序遍历
     */
    public static String postorder(TreeNode tree){
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
        sb.append(tree.val);

        return sb.toString();
    }
}
