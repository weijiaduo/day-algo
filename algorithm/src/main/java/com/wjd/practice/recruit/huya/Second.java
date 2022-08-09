package com.wjd.practice.recruit.huya;

import java.util.Scanner;

/**
 * 输入一个数组，代表一棵树（层序遍历，叶子节点为空时是"#"）
 * 求这棵树的前序遍历输出
 * 不能将数组转为一颗实际的树，要求保持数组结构
 * 要求使用栈实现，而且栈必须用数组来模拟，不得使用集合类
 *
 *
 * 例子：
 *
 * 输入：
 * A B C D # F G H
 *
 * 输出：
 * ABDHCFG
 *
 */
public class Second {

    public static void main(String[] args) {
        String[] a = parseInput();
        order(a);
    }

    /**
     * 输入数据
     *
     * @return
     */
    public static String[] parseInput(){
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            return in.nextLine().split(" ");
        }
        return null;
    }

    /**
     * 前序输出
     *
     * @param a
     */
    public static void order(String[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int[] visit = new int[a.length];
        MyStack stack = new MyStack(a.length);
        stack.push(new Node(0, a[0]));
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (!cur.value.equals("#")) {
                System.out.print(cur.value);
            }
            visit[cur.index] = 1;

            // 右节点
            int r = cur.index * 2 + 2;
            if (r < a.length && visit[r] == 0) {
                stack.push(new Node(r, a[r]));
            }

            // 左节点
            int l = cur.index * 2 + 1;
            if (l < a.length && visit[l] == 0) {
                stack.push(new Node(l, a[l]));
            }
        }
    }

    static class Node {
        public int index;
        public String value;

        public Node(int index, String value) {
            this.index = index;
            this.value = value;
        }
    }

    static class MyStack{
        Node[] stack;
        int size = 0;

        public MyStack(int maxSize) {
            if (maxSize > 0) {
                stack = new Node[maxSize];
            }
        }

        public Node pop() {
            if (size > 0) {
                Node node = stack[size - 1];
                stack[size - 1] = null;
                size--;
                return node;
            }
            return null;
        }

        public void push(Node v) {
            if (size < stack.length) {
                stack[size++] = v;
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
