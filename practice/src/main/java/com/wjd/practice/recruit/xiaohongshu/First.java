package com.wjd.practice.recruit.xiaohongshu;

import java.util.Scanner;

class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * 每次按k个节点反转链表，不足k个不反转
 */
public class First {

    public static void main(String[] args) {
        String s;
        int[] a;
        int k;

        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        k = scanner.nextInt();
        scanner.close();

        String[] as = s.split(" ");
        if (as != null && as.length > 0) {
            a = new int[as.length];
            for (int i = 0; i < as.length; i++) {
                a[i] = Integer.parseInt(as[i]);
            }

            ListNode listNode = create(a);
            listNode = reverseK(listNode, k);
            printList(listNode);
        }
    }

    /**
     * 创建链表
     *
     * @param a
     * @return
     */
    public static ListNode create(int[] a) {
        if (a == null) {
            return null;
        }

        ListNode listNode = new ListNode(-1);
        ListNode tail = listNode;
        for (int i = 0; i < a.length; i++) {
            tail.next = new ListNode(a[i]);
            tail = tail.next;
        }

        return listNode.next;
    }

    /**
     * 递归反转k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseK(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode result = null, p = head, q;
        int tk = 0;
        while (p != null && tk < k) {
            p = p.next;
            tk++;
        }

        if (tk == k) {//存在k个节点
            q = head;
            while (q != p) {
                ListNode temp = q;
                q = q.next;
                temp.next = result;
                result = temp;
            }

            head.next = reverseK(q, k);// 递归反转
        } else {// 不足k个节点
            result = head;
        }

        return result;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            if (p != head) {
                System.out.print(" ");
            }
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();
    }
}
