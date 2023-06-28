package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * @since 2022/5/16
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // return iterate(head);
        return recursive(head);
    }

    /**
     * 思路：哨兵，将链表重新加入新链表，添加的时候，先加第2个，再加第1个
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了43.20% 的Java用户
     */
    private ListNode iterate(ListNode head) {
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

    /**
     * 思路：递归，先交换后面的节点，再递归回表头
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了11.94% 的Java用户
     */
    private ListNode recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = recursive(next.next);
        next.next = head;
        return next;
    }

}
