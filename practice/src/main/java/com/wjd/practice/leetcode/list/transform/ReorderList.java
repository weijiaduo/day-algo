package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 143. 重排链表
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 * @author weijiaduo
 * @since 2022-06-27
 */
public class ReorderList {

    /**
     * 思路：将链表对半分，翻转后半部分链表，最后重新拼装2条链表
     * <p>
     * 复杂度：时间O(n)，空间O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.95% 的Java用户
     * 内存消耗:44.7 MB,击败了5.02% 的Java
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 找到中点
        ListNode p = head, q = head;
        while (p.next != null && p.next.next != null) {
            q = q.next;
            p = p.next.next;
        }

        // 翻转后链
        ListNode sHead = null;
        p = q.next;
        q.next = null;
        while (p != null) {
            ListNode temp = p;
            p = p.next;
            temp.next = sHead;
            sHead = temp;
        }

        // 重组双链
        p = head;
        q = sHead;
        while (p != null && q != null) {
            ListNode temp1 = p.next;
            ListNode temp2 = q.next;
            p.next = q;
            p = temp1;
            q.next = p;
            q = temp2;
        }
    }
}
