package com.wjd.algorithm.practice.leetcode.list;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.ListNode;

/**
 * @since 2022/5/15
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * <p>
 * 输出：[1,2,3,5]
 */
public class RemoveNthFromEnd implements Solution<ListNode> {

    @Override
    public ListNode solve(Object ...args) {
        int[] arr = {1};
        int n = 1;
        ListNode head = ListNode.build(arr);
        ListNode result = removeNthFromEnd(head, n);
        System.out.println(ListNode.listString(result));
        return result;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        int k = n;
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy, q = dummy;
        while (p.next != null) {
            // p 最终指向倒数第1个节点
            p = p.next;
            if (k == 0) {
                // q 最终指向倒数第n+1个节点
                q = q.next;
            } else {
                // 走过n个节点
                k--;
            }
        }
        q.next = q.next.next;
        return dummy.next;
    }
}
