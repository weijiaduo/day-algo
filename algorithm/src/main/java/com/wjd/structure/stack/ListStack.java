package com.wjd.structure.stack;

/**
 * 链式栈
 *
 * @author weijiaduo
 * @since 2022/8/24
 */
public class ListStack implements Stack {

    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    private final Node list;
    private int size;

    public ListStack() {
        list = new Node(-1);
        size = 0;
    }

    @Override
    public void push(int val) {
        Node node = new Node(val);
        node.next = list.next;
        list.next = node;
        size++;
    }

    @Override
    public int pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Node node = list.next;
        list.next = list.next.next;
        size--;
        return node.val;
    }

    @Override
    public int top() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return list.next.val;
    }

    @Override
    public int size() {
        return size;
    }

}
