package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 52. 两个链表的第一个公共结点
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class FirstCommonNodesInLists {

    @TestCase(input = {"[1,2,3,4,5,6,7]", "[8,9,5,6,7]"},
            output = {"5"})
    public ListNode test(int[] values1, int[] values2) {
        int m = values1.length, n = values2.length;
        ListNode list1 = ListNode.build(values1);
        ListNode list2 = ListNode.build(values2);
        int size = 0;
        for (int i = 1; i <= m && i <= n; i++) {
            if (values1[m - i] != values2[n - i]) {
                break;
            }
            size = i;
        }
        if (size >= 0) {
            ListNode pre1 = list1;
            for (int i = 1; i < m - size; i++) {
                pre1 = pre1.next;
            }
            ListNode pre2 = list2;
            for (int i = 1; i < n - size; i++) {
                pre2 = pre2.next;
            }
            pre1.next = pre2.next;
        }
        return doublePoint(list1, list2);
    }

    /**
     * 思路：栈
     * <p>
     * 两个链表从尾到头开始比较，找到第一个不同的节点
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(n)
     */
    public ListNode stack(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        // 将链表节点保存到栈中
        List<ListNode> stack1 = new ArrayList<>();
        List<ListNode> stack2 = new ArrayList<>();
        ListNode p = head1, q = head2;
        while (p != null) {
            stack1.add(p);
            p = p.next;
        }
        while (q != null) {
            stack2.add(q);
            q = q.next;
        }

        // 验证是否有公共节点
        int p1 = stack1.size() - 1, p2 = stack2.size() - 1;
        if (stack1.get(p1) != stack2.get(p2)) {
            return null;
        }

        // 从尾到头寻找第一个不同节点
        ListNode common = stack1.get(p1);
        while (stack1.get(p1) == stack2.get(p2)) {
            common = stack1.get(p1);
            p1--;
            p2--;
        }
        return common;
    }

    /**
     * 思路：双指针
     * <p>
     * 首先计算两个链表的长度，计算出它们的距离差
     * <p>
     * 如果有公共节点，那就让长链表先走一段距离，然后再两个链表同时走，直到找到第一个公共节点
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(1)
     */
    public ListNode doublePoint(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        // 计算两个链表的长度
        ListNode tail1 = head1, tail2 = head2;
        ListNode p1 = head1, p2 = head2;
        int size1 = 0, size2 = 0;
        while (p1 != null) {
            size1++;
            tail1 = p1;
            p1 = p1.next;
        }
        while (p2 != null) {
            size2++;
            tail2 = p2;
            p2 = p2.next;
        }

        // 验证是否有公共节点
        if (tail1 != tail2) {
            return null;
        }

        // 长链表先走
        ListNode lp = size1 > size2 ? head1 : head2;
        ListNode sp = size1 > size2 ? head2 : head1;
        int diff = Math.abs(size1 - size2);
        while (diff-- > 0) {
            lp = lp.next;
        }

        // 寻找第一个公共节点
        while (lp != sp) {
            lp = lp.next;
            sp = sp.next;
        }
        return lp;
    }

}
