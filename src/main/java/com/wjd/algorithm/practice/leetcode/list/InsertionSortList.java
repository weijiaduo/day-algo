package com.wjd.algorithm.practice.leetcode.list;

import com.wjd.algorithm.practice.leetcode.structure.ListNode;

/**
 * 利用插入排序法排序链表
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head = insertionSortList(head);
        printList(head);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = null, q = head, t;
        while (q != null) {
            t = q;
            q = q.next;
            t.next = p;
            p = t;
            while (t.next != null && t.val > t.next.val) {
                int temp = t.val;
                t.val = t.next.val;
                t.next.val = temp;
                t = t.next;
            }
        }

        return p;
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
