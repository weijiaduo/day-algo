package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 22. 链表中倒数第k个结点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author weijiaduo
 * @since 2023/11/25
 */
public class FindKthToTail {

    /**
     * 思路：前后指针，
     * <p>
     * 一个指针先移动 k 步，
     * <p>
     * 然后两个指针一起移动，前指针到达末尾时，后指针指向倒数第 k 个节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3]", "1", "[1,2,3]", "4",},
            output = {"[3]", "[]"})
    public ListNode find(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        int i = 0;
        ListNode p = head, q = head;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }

        return i < k ? null : q;
    }

}
