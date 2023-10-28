package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * <p>
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationListNode {

    @TestCase(input = {"[1,3,3,3,4,4,5]"},
            output = {"[1,5]"})
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead != null) {
            ListNode newHead = new ListNode(0), tail = newHead;
            ListNode p = pHead, q;
            while (p != null) {
                if (p.next != null && p.val == p.next.val) {
                    q = p;
                    while (p != null && p.val == q.val) {
                        p = p.next;
                    }
                } else {
                    tail.next = p;
                    tail = p;
                    p = p.next;
                    tail.next = null;
                }
            }
            pHead = newHead.next;
        }
        return pHead;
    }

}
