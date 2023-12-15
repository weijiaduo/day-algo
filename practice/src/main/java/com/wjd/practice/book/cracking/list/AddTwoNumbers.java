package com.wjd.practice.book.cracking.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 面试题 02.05. 链表求和
 * <p>
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * <p>
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * @author weijiaduo
 * @since 2023/12/15
 */
public class AddTwoNumbers {

    /**
     * 思路：直接模拟加法即可，加个哨兵节点避免头节点判断
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.6 MB,击败了5.29% 的Java用户
     */
    @TestCase(input = {"[2,4,3]", "[5,6,4]", "[0]", "[0]", "[9,9,9,9,9,9,9]", "[9,9,9,9]"},
            output = {"[7,0,8]", "[0]", "[8,9,9,9,0,0,0,1]"})
    public ListNode add(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        ListNode p1 = l1, p2 = l2;
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
            tail.next = new ListNode(r);
            tail = tail.next;
        }
        return dummy.next;
    }

}
