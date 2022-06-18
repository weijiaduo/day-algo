package com.wjd.algorithm.practice.leetcode.list;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.ListNode;

/**
 * 25. K个一组翻转链表
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * <p>
 * 输出：[2,1,4,3,5]
 *
 * @since 2022/5/17
 */
public class ReverseKGroup implements Solution<ListNode> {

    @Override
    public ListNode solve(Object ...args) {
        int k = 2;
        int[] values = {1,2,3,4,5};
        ListNode head = ListNode.build(values);
        ListNode result = reverseKGroup(head, k);
        System.out.println(ListNode.listString(result));
        return result;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy, h = dummy;
        ListNode p = head, q, t;
        while (p != null) {
            q = p;

            // 移动k个节点
            int i = 0;
            while (i++ < k && p != null) {
                p = p.next;
            }

            // 不够k个节点
            if (i <= k) {
                tail.next = q;
                break;
            }

            // 翻转节点
            tail = q;
            while (q != p) {
                t = q;
                q = q.next;
                t.next = h.next;
                h.next = t;
            }
            h = tail;
        }
        return dummy.next;
    }
}
