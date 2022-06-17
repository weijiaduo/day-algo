package com.wjd.algorithm.practice.leetcode.structure;

public class Node {

    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

    public static Node build(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        Node head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
        return head;
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