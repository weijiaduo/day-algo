package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 24. 反转链表
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author weijiaduo
 * @since 2023/11/25
 */
public class ReverseList {

    /**
     * 思路：头插法，每次将当前节点插入到头节点之前
     * <p>
     * 然后更新头节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3,4,5,6,7]"},
            output = {"[7,6,5,4,3,2,1]"})
    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode p = head, q;
        while (p != null) {
            q = p.next;
            p.next = newHead;
            newHead = p;
            p = q;
        }
        return newHead;
    }

}
