package com.wjd.practice.leetcode.list.simulate;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 2. 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoNumbers {

    /**
     * 思路：直接模拟加法即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.1 MB,击败了20.87% 的Java用户
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l = new ListNode(-1);
        ListNode t = l, p = l1, q = l2;
        int carry = 0;
        while (p != null || q != null || carry != 0) {
            // 执行加法，当前数位和 + 上一轮的进位
            int num1 = p != null ? p.val : 0;
            int num2 = q != null ? q.val : 0;
            int sum = num1 + num2 + carry;

            // 保存当前数位的结果，并记录进位
            t.next = new ListNode(sum % 10);
            carry = sum / 10;
            t = t.next;

            // 执行到下一个数位
            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
        }
        return l.next;
    }

}
