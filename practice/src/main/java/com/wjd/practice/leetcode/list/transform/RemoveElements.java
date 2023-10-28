package com.wjd.practice.leetcode.list.transform;

import com.wjd.structure.list.ListNode;

/**
 * 203. 移除链表元素
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * @author weijiaduo
 * @since 2022/7/13
 */
public class RemoveElements {

    /**
     * 思路：把链表的节点一个一个拼到一条新链表，并返回新链表的表头
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了48.86% 的Java用户
     * 内存消耗:42.5 MB,击败了13.59% 的Java用户
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode p = head, q, tail = dummy;
        while (p != null) {
            q = p;
            p = p.next;
            if (q.val != val) {
                tail.next = q;
                tail = tail.next;
                tail.next = null;
            }
        }
        return dummy.next;
    }

    /**
     * 思路：前后指针法，一个指针指向当前节点，一个指向上一个节点，如果当前节点值等于val，就移除当前节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.1 MB,击败了67.30% 的Java用户
     */
    private ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode q = dummy, p = q.next;
        while (p != null) {
            if (p.val == val) {
                p = p.next;
                q.next = p;
                continue;
            }
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }

}
