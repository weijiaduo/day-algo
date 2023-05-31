package com.wjd.practice.leetcode.list;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * <p>
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 输入：head = [1,2,3,4]
 * <p>
 * 输出：[2,1,4,3]
 *
 * @since 2022/5/16
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode first, second, p = head;
        while (p != null) {
            // 只剩一个节点了
            if (p.next == null) {
                tail.next = p;
                break;
            }

            // 下2个节点
            first = p;
            second = first.next;
            p = second.next;

            // 交换位置
            tail.next = second;
            second.next = first;
            first.next = p;
            tail = first;
        }
        return dummy.next;
    }
}
