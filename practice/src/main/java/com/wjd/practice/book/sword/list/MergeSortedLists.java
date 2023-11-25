package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 25. 合并两个排序的链表
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * <p>
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 * @author weijiaduo
 * @since 2023/11/25
 */
public class MergeSortedLists {

    /**
     * 思路：哨兵链表，两个指针，比较两个指针的值，小的放到哨兵链表末尾
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,3,5]", "[2,2,3]"},
            output = {"[1,2,2,3,3,5]"})
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p = list1, q = list2, tail = dummy;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                tail.next = p;
                p = p.next;
            } else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }
        tail.next = p != null ? p : q;
        return dummy.next;
    }

}
