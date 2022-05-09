package com.wjd.algorithm.practice.leetcode.list;

import com.wjd.algorithm.practice.leetcode.structure.ListNode;

/**
 * 链表代表数字
 * 求两个链表相加的结果
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(8);
        ListNode l = addTwoNumbers(l1, l2);
        ListNode p= l;
        while (p!=null){
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l = new ListNode(-1);
        ListNode t = l, p = l1, q = l2;
        int c = 0;
        while (p != null || q != null || c != 0) {
            int sum = c;
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }

            t.next = new ListNode(sum % 10);
            c = sum / 10;
            t = t.next;
        }

        return l.next;
    }
}
