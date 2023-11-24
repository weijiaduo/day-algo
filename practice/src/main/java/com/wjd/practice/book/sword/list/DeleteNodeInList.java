package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 18.1 删除链表的节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 *
 * @author weijiaduo
 * @since 2023/11/24
 */
public class DeleteNodeInList {

    /**
     * 思路：将要删除的节点的值替换为下一个节点的值，然后删除下一个节点
     * <p>
     * 同时需要对头节点和尾节点做特殊处理
     * <p>
     * 复杂度：最坏时间 O(n) 最好时间 O(1) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3,4,5]", "3", "[1,2,3,4,5]", "1", "[1,2,3,4,5]", "5"},
            output = {"[1,2,4,5]", "[2,3,4,5]", "[1,2,3,4]"})
    public ListNode delete(ListNode head, int val) {
        ListNode node = null, p = head;
        while (p != null) {
            if (p.val == val) {
                node = p;
            }
            p = p.next;
        }
        return delete(head, node);
    }

    /**
     * 删除节点
     *
     * @param head 头节点
     * @param node 要删除的节点
     * @return 删除后的头节点
     */
    private ListNode delete(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return head;
        }

        // 删除的是头节点
        if (head == node) {
            return head.next;
        }

        // 删除的是尾节点
        if (node.next == null) {
            ListNode p = head;
            while (p.next != node) {
                p = p.next;
            }
            p.next = null;
            return head;
        }

        // 删除的是中间节点
        node.val = node.next.val;
        node.next = node.next.next;
        return head;
    }

}
