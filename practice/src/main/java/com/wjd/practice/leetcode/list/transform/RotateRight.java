package com.wjd.practice.leetcode.list.transform;

import com.wjd.structure.list.ListNode;

/**
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10⁹
 *
 * @since 2022/6/1
 */
public class RotateRight {

    /**
     * 思路：旋转的长度k需要取余，否则徒做无用功，所以需要计算链表长度
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
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
