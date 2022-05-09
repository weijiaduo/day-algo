package com.wjd.algorithm.practice.leetcode.list;

import com.wjd.algorithm.practice.leetcode.structure.ListNode;

public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);
        printList(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 找到中点
        ListNode p = head, q = head;
        while (p.next != null && p.next.next != null) {
            q = q.next;
            p = p.next.next;
        }

        // 翻转后链
        ListNode sHead = null;
        p = q.next;
        q.next = null;
        while (p != null) {
            ListNode temp = p;
            p = p.next;
            temp.next = sHead;
            sHead = temp;
        }

        // 重组双链
        p = head;
        q = sHead;
        while (p != null && q != null) {
            ListNode temp1 = p.next;
            ListNode temp2 = q.next;
            p.next = q;
            p = temp1;
            q.next = p;
            q = temp2;
        }
    }

    public static void printList(ListNode head){
        ListNode p = head;
        while (p!=null){
            System.out.print(p.val+" ");
            p= p.next;
        }
        System.out.println();
    }
}
