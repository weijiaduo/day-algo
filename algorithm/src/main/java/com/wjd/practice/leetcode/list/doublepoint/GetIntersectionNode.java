package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 160. 相交链表
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * <p>
 * 如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class GetIntersectionNode {

    /**
     * 思路：前后双指针，先算2条链表的长度，再提前移动长链表的指针，然后同时移动长短链表的指针，双指针相等的地方就是相交点
     * <p>
     * 复杂度：时间O(m + n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了97.85% 的Java用户
     * 内存消耗:44.2 MB,击败了56.31% 的Java用户
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 分别计算出长短链表的长度
        int m = 0, n = 0;
        ListNode p = headA, q = headB;
        while (p != null) {
            m++;
            p = p.next;
        }
        while (q != null) {
            n++;
            q = q.next;
        }
        if (m == 0 || n == 0) {
            return null;
        }

        // 长链表的指针先往前移动一段距离
        int k;
        if (m > n) {
            p = headA;
            q = headB;
            k = m - n;
        } else {
            p = headB;
            q = headA;
            k = n - m;
        }
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        // 同时移动长短链表的指针，碰面的地方就是相交点
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    /**
     * 官解：这么简洁的吗
     * <p>
     * 复杂度：时间O(m + n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了97.85% 的Java用户 内存消耗:44.3 MB,击败了43.16% 的Java用户
     */
    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
