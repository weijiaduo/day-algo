package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 25. K个一组翻转链表
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * 提示：
 * <p>
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * @since 2022/5/17
 */
public class ReverseKGroup {

    /**
     * 思路：新开一条链表，按每 k 个节点倒序添加到新链表尾
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了44.02% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "2", "[1,2,3,4,5]", "3"},
            output = {"[2,1,4,3,5]", "[3,2,1,4,5]"})
    public ListNode iterate(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy, h = dummy;
        ListNode p = head, q, t;
        while (p != null) {
            q = p;

            // 移动k个节点
            int i = 0;
            while (i++ < k && p != null) {
                p = p.next;
            }

            // 不够k个节点
            if (i <= k) {
                tail.next = q;
                break;
            }

            // 翻转节点
            tail = q;
            while (q != p) {
                t = q;
                q = q.next;
                t.next = h.next;
                h.next = t;
            }
            h = tail;
        }
        return dummy.next;
    }

    /**
     * 思路：递归，拿出前 k 个节点反转，然后递归后面的 n-k 个节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n/k)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42 MB,击败了21.00% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "2", "[1,2,3,4,5]", "3"},
            output = {"[2,1,4,3,5]", "[3,2,1,4,5]"})
    public ListNode recursive(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 前 k 个节点
        ListNode h = head;
        int i = 0;
        while (i++ < k && h != null) {
            h = h.next;
        }
        // 不够 k 个节点
        if (i <= k) {
            return head;
        }

        // 头插法插入前 k 个节点
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        while (p != h) {
            ListNode tmp = p;
            p = p.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        // 递归后 n-k 个节点
        head.next = recursive(h, k);
        return dummy.next;
    }

}
