package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 18.2 删除链表中重复的节点
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * <p>
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author weijiaduo
 * @since 2023/11/24
 */
public class DeleteDuplicatedNode {

    /**
     * 思路：哨兵+新链表
     * <p>
     * 遍历原链表，将不重复的节点连接到新链表
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,3,3,3,4,4,5]"},
            output = {"[1,5]"})
    public ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0), tail = dummy;
        ListNode p = head;
        while (p != null) {
            if (p.next != null && p.val == p.next.val) {
                // 发现重复节点，跳过
                ListNode q = p;
                while (p != null && p.val == q.val) {
                    p = p.next;
                }
            } else {
                // 不是重复节点，连接到新链表
                tail.next = p;
                tail = p;
                p = p.next;
                tail.next = null;
            }
        }
        return dummy.next;
    }

}
