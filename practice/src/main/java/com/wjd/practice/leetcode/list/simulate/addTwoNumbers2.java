package com.wjd.practice.leetcode.list.simulate;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.practice.leetcode.structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 445. 两数相加 II
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * <p>
 * 将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例1：
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * 进阶：如果输入链表不能翻转该如何解决？
 *
 * @author weijiaduo
 * @since 2023/7/3
 */
public class addTwoNumbers2 {

    /**
     * 思路：先将链表倒序过来，再按照正常数字加法模拟即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了72.21% 的Java用户
     * 内存消耗:42.1 MB,击败了47.18% 的Java用户
     */
    @TestCase(input = {"[7,2,4,3]", "[5,6,4]", "[2,4,3]", "[5,6,4]", "[0]", "[0]"},
            output = {"[7,8,0,7]", "[8,0,7]", "[0]"})
    private ListNode reverseAdd(ListNode l1, ListNode l2) {
        // 反转 2 条链表相加
        ListNode list = addNumbers(reverseList(l1), reverseList(l2));
        // 最后再反转链表
        return reverseList(list);
    }

    private ListNode addNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy, p1 = l1, p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0) {
            // 执行加法，当前数位和 + 上一轮的进位
            int num1 = p1 != null ? p1.val : 0;
            int num2 = p2 != null ? p2.val : 0;
            int sum = num1 + num2 + carry;

            // 保存当前数位的结果，并记录进位
            t.next = new ListNode(sum % 10);
            carry = sum / 10;
            t = t.next;

            // 执行到下一个数位
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode list) {
        ListNode dummy = new ListNode(-1);
        ListNode p = list;
        while (p != null) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        return dummy.next;
    }

    /**
     * 思路：递归，先加链尾节点，再往前递归算链头节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了42.35% 的Java用户
     */
    @TestCase(input = {"[7,2,4,3]", "[5,6,4]", "[2,4,3]", "[5,6,4]", "[0]", "[0]"},
            output = {"[7,8,0,7]", "[8,0,7]", "[0]"})
    private ListNode dfsAdd(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        int offset = Math.abs(len1 - len2);
        ListNode p1, p2;
        if (len1 >= len2) {
            p1 = l1;
            p2 = l2;
        } else {
            p1 = l2;
            p2 = l1;
        }

        // 长短列表相加
        ListNode list = dfs(p1, p2, offset);
        return list.val != 0 ? list : list.next;
    }

    /**
     * 两条链表相加
     *
     * @param l1     长链表
     * @param l2     短链表
     * @param offset 长短链表长度差
     * @return 进位的节点，如无进位，返回一个 0 值节点
     */
    private ListNode dfs(ListNode l1, ListNode l2, int offset) {
        if (l1 == null || l2 == null) {
            return new ListNode(0);
        }

        // 数位和
        ListNode next;
        if (offset <= 0) {
            // 先算后面的数位和
            next = dfs(l1.next, l2.next, 0);
            // 当前数位和：当前数位 + 进位
            next.val += l1.val + l2.val;
        } else {
            next = dfs(l1.next, l2, offset - 1);
            next.val += l1.val;
        }

        // 检查进位
        ListNode carry = new ListNode(0);
        carry.next = next;
        carry.val = next.val / 10;
        next.val = next.val % 10;
        return carry;
    }

    private int length(ListNode list) {
        int len = 0;
        ListNode p = list;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    /**
     * 思路：基于栈相加，将链表都压入栈，再出栈相加
     * <p>
     * 复杂度：时间 O(n) 空间 O(m+n)
     * <p>
     * 执行耗时:2 ms,击败了72.21% 的Java用户
     * 内存消耗:42.4 MB,击败了34.88% 的Java用户
     */
    @TestCase(input = {"[7,2,4,3]", "[5,6,4]", "[2,4,3]", "[5,6,4]", "[0]", "[0]"},
            output = {"[7,8,0,7]", "[8,0,7]", "[0]"})
    private ListNode stackAdd(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.next;
        }

        ListNode list = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            node.next = list;
            list = node;
        }
        return list;
    }

}
