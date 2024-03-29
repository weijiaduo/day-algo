package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * <p>
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
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

    /**
     * 思路：哨兵，将链表重新加入新链表，添加的时候，先加第2个，再加第1个
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了43.20% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4]", "[]", "[1]"},
            output = {"[2,1,4,3]", "[]", "[1]"})
    public ListNode iterate(ListNode head) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode p1 = p, p2 = p.next;
            ListNode next = p2.next;
            // 交换节点
            tail.next = p2;
            p2.next = p1;
            // 下一轮
            tail = p1;
            p = next;
        }
        // 末尾的 0 个或 1个节点
        tail.next = p;
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
    @TestCase(input = {"[1,2,3,4]", "[]", "[1]"},
            output = {"[2,1,4,3]", "[]", "[1]"})
    public ListNode recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = recursive(next.next);
        next.next = head;
        return next;
    }

}
