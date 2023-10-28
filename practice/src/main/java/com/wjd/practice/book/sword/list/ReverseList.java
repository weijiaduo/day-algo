package com.wjd.practice.book.sword.list;

import com.wjd.structure.list.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(head);
        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode p = head, q;
        while (p != null) {
            q = p.next;
            p.next = newHead;
            newHead = p;
            p = q;
        }

        return newHead;
    }
}
