package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 92. 反转链表2
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * <p>
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * @since 2022/6/11
 */
public class ReverseBetween {

    /**
     * 思路：遍历到 [left, right] 时，反向插入链表节点，其他节点在链尾追加
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了58.80% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "2", "4", "[5]", "1", "1"},
            output = {"[1,4,3,2,5]", "[5]"})
    public ListNode splice(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy, p = head, q = tail;
        for (int k = 1; p != null; k++) {
            ListNode t = p;
            p = p.next;
            if (left <= k && k <= right) {
                // 反向插入
                t.next = q.next;
                q.next = t;
                if (q == tail) {
                    tail = t;
                }
            } else {
                // 追加
                t.next = null;
                tail.next = t;
                q = tail = tail.next;
            }
        }
        return dummy.next;
    }

    /**
     * 思路：在原始链上之间用头插法
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了29.03% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "2", "4", "[5]", "1", "1"},
            output = {"[1,4,3,2,5]", "[5]"})
    public ListNode inplace(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode t = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode cur = t.next;
            t.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }

}
