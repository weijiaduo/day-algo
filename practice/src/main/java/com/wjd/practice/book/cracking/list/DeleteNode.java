package com.wjd.practice.book.cracking.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 面试题 02.03. 删除中间节点
 * <p>
 * 若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
 * <p>
 * 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
 * <p>
 * 例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f
 * <p>
 * 示例：
 * <p>
 * 输入：节点5（位于单向链表4->5->1->9中）
 * 输出：不返回任何数据，从链表中删除传入的节点 5，使链表变为4->1->9
 *
 * @author weijiaduo
 * @since 2023/12/15
 */
public class DeleteNode {

    /**
     * 思路：直接将下个节点的值替换掉当前值
     * <p>
     * 复杂度：O(1) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.3 MB,击败了5.52% 的Java用户
     */
    @TestCase(input = {"[4,5,1,9]", "5"},
            output = {"[4,1,9]"})
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        while (p != null && p.val != val) {
            p = p.next;
        }
        deleteNode(p);
        return head;
    }

    /**
     * 删除当前节点
     * <p>
     * 直接将下个节点的值替换掉当前值
     *
     * @param node 当前节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
