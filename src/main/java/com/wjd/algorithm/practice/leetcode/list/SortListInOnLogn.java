package com.wjd.algorithm.practice.leetcode.list;

import com.wjd.algorithm.practice.leetcode.structure.ListNode;

public class SortListInOnLogn {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        head = sortList(head);
        printList(head);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, q = head;
        while (p.next != null && p.next.next!=null) {
            q = q.next;
            p = p.next.next;
        }

        ListNode right = sortList(q.next);
        q.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1), p = head;
        while (left != null && right != null) {
            if (left.val > right.val) {
                p.next = right;
                right = right.next;
            } else {
                p.next = left;
                left = left.next;
            }
            p = p.next;
        }

        if (left != null) {
            p.next = left;
        }
        if (right != null) {
            p.next = right;
        }

        return head.next;
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
