package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。
 * <p>
 * 返回 已排序的链表 。
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 *
 * @since 2022/5/22
 */
public class DeleteDuplicates {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了27.34% 的Java用户
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(head.val - 1);
        ListNode tail = dummy;
        ListNode p = head, q;
        while (p != null) {
            q = p;
            p = p.next;
            if (tail.val != q.val) {
                tail.next = q;
                tail = q;
                tail.next = null;
            }
        }
        return dummy.next;
    }

}
