package com.wjd.practice.leetcode.list;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 92. 反转链表2
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * <p>
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * @since 2022/6/11
 */
public class ReverseBetween implements Solution<ListNode> {

    @Override
    public ListNode solve(Object... args) {
        int[] values = {5};
        int left = 1, right = 1;
        ListNode head = ListNode.build(values);
        System.out.println(ListNode.listString(head));
        ListNode result = reverseBetween(head, left, right);
        System.out.println(ListNode.listString(result));
        return null;
    }

    /**
     * 思路：遍历到 [left, right] 时，反向插入链表节点
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了58.80% 的Java用户
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy, p = head, q = tail;
        int k = 0;
        while (p != null) {
            k++;
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

}
