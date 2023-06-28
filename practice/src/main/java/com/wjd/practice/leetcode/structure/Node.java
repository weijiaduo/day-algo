package com.wjd.practice.leetcode.structure;

import java.util.*;

/**
 * 通用节点（链表、树、图）
 *
 * @author weijiaduo
 * @since 2022-06-26
 */
public class Node {

    public int val;
    /**
     * 链表节点
     */
    public Node next;
    /**
     * 随机指针
     */
    public Node random;
    /**
     * 树节点
     */
    public Node left;
    public Node right;
    /**
     * 图节点
     */
    public List<Node> neighbors;

    /**
     * 四叉树子节点
     */
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
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
     * 构建图
     */
    public static Node buildGraph(int[][] adjList) {
        Node node = null;
        Map<Integer, Node> nodes = new HashMap<>(adjList.length);
        for (int[] edge : adjList) {
            node = nodes.get(edge[0]);
            if (node == null) {
                node = new Node(edge[0]);
                nodes.put(edge[0], node);
            }
            Node node2 = nodes.get(edge[1]);
            if (node2 == null) {
                node2 = new Node(edge[1]);
                nodes.put(edge[1], node2);
            }
            node.neighbors.add(node2);
        }
        return node;
    }

    /**
     * 按链表遍历
     */
    public String listString() {
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

    /**
     * 层次遍历
     */
    public static List<Integer> bfsString(Node tree) {
        if (tree == null) {
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        return Objects.hash(this) == Objects.hash(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, random, left, right, neighbors);
    }

    @Override
    public String toString() {
        return listString();
    }
}