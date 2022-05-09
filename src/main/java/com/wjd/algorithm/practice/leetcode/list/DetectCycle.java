package com.wjd.algorithm.practice.leetcode.list;

import com.wjd.algorithm.practice.leetcode.structure.ListNode;


/**
 * 判断链表是否有环，若有则返回环的入口，若没有返回null
 *
 */
public class DetectCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode t = detectCycle(head);
        if (t != null){
            System.out.println(t.val);
        }else {
            System.out.println(t);
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode beginCircle = null;
        ListNode p = head, q = head;
        boolean flag = false;

        // 验证是否有环
        while (p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
            if (p != null && (p == q || p.next == q)) {
                flag = true;
                break;
            }
        }

        if (flag) {
            // 环节点数量
            int circleSize = 1;
            p = q.next;
            while (p != q) {
                circleSize++;
                p = p.next;
            }

            p = head;
            q = head;
            while (circleSize > 0) {
                p = p.next;
                circleSize--;
            }
            while (p != q) {
                p = p.next;
                q = q.next;
            }

            beginCircle = p;
        }

        return beginCircle;
    }
}
