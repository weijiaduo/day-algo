package com.wjd.practice.leetcode.list;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * @since 2022/6/1
 */
public class RotateRight implements Solution<ListNode> {

    @Override
    public ListNode solve(Object... args) {
        int[] values = {1,2,3,4,5};
        int k = 3;
        ListNode head = ListNode.build(values);
        System.out.println(ListNode.listString(head));
        ListNode result = rotateRight(head, k);
        System.out.println(ListNode.listString(result));
        return null;
    }

    /**
     * 思路：旋转的长度k需要取余，否则徒做无用功，所以需要计算链表长度
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了80.20% 的Java用户
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }

        // 计算链表长度和记录链尾
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        // 计算实际需要旋转的长度
        k = k % length;
        if (k == 0) {
            return head;
        }

        // 将旋转部分转移到旧链表头部
        tail.next = head;
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;

        return head;
    }

}
