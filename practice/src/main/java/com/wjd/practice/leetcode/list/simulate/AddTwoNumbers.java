package com.wjd.practice.leetcode.list.simulate;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

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
 *
 * @author weijiaduo
 * @since 2023/7/2
 */
public class AddTwoNumbers {

    /**
     * 思路：直接模拟加法即可，加个哨兵节点避免头节点判断
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.1 MB,击败了20.87% 的Java用户
     */
    @TestCase(input = {"[2,4,3]", "[5,6,4]", "[0]", "[0]", "[9,9,9,9,9,9,9]", "[9,9,9,9]"},
            output = {"[7,0,8]", "[0]", "[8,9,9,9,0,0,0,1]"})
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy, p1 = l1, p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0) {
            // 执行加法，当前数位和 + 上一轮的进位
            int sum = carry;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            // 保存当前数位的结果，并记录进位
            carry = sum / 10;
            int r = sum % 10;
            t.next = new ListNode(r);
            t = t.next;
        }
        return dummy.next;
    }

}
