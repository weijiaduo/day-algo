package com.wjd.algorithm.practice.leetcode.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {

    public int val;
    public Node next;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public static Node buildList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        Node head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
        return head;
    }
    
    public static Node buildTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        int i = 0;
        Node tree = new Node(values[i++]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 左节点
            if (i < values.length) {
                Integer leftVal = values[i++];
                Node leftNode = null;
                if (leftVal != null) {
                    leftNode = new Node(leftVal);
                    queue.add(leftNode);
                }
                node.left = leftNode;
            }

            // 右节点
            if (i < values.length) {
                Integer rightVal = values[i++];
                Node rightNode = null;
                if (rightVal != null) {
                    rightNode = new Node(rightVal);
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
    public static List<Integer> bfs(Node tree){
        if (tree == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(tree);
        int notNull = queue.size();
        while (!queue.isEmpty() && notNull >= 1) {
            Node node = queue.poll();
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

    @Override
    public String toString() {
        Node p = this;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (p != null) {
            sb.append(p.val).append(',');
            p = p.next;
            if (p == this) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }
}