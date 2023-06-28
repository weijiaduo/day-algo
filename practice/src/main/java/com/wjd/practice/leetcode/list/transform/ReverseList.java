package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 206. 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * @author weijiaduo
 * @since 2022/7/14
 */
public class ReverseList {

    /**
     * 思路：拆分原链表到新链表，每次插入节点到头部，最后返回新链表的头节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了14.90% 的Java用户
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = head, q;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = dummy.next;
            dummy.next = q;
        }
        return dummy.next;
    }

    /**
     * 思路：递归法，递归反转节点，最后返回是反转链表的表头，也就是原链表的链尾
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了98.19% 的Java用户
     */
    private ListNode dfsReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = dfsReverseList(next);
        // 反转后面的链表后，next就是新的链尾
        next.next = head;
        head.next = null;
        return newHead;
    }

}
