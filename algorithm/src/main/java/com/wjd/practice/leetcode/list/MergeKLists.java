package com.wjd.practice.leetcode.list;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 23. 合并K个升序链表
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * <p>
 * 输出：[1,1,2,3,4,4,5,6]
 *
 * @since 2022/5/15
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (end <= start) {
            return lists[start];
        }

        // 分治
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode p = left, q = right;
        while (p != null && q != null) {
            if (p.val < q.val) {
                tail.next = p;
                p = p.next;
            } else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }
        if (p != null) {
            tail.next = p;
        }
        if (q != null) {
            tail.next = q;
        }
        return dummy.next;
    }
}
