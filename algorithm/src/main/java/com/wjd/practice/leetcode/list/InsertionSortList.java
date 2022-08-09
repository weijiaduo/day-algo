package com.wjd.practice.leetcode.list;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 147. 对链表进行插入排序
 * <p>
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * <p>
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 *
 * @author weijiaduo
 * @since 2022-06-27
 */
public class InsertionSortList implements Solution<ListNode> {

    @Override
    public ListNode solve(Object... args) {
        int[] values = {-1, 5, 3, 4, 0};
        ListNode head = ListNode.build(values);
        ListNode result = insertionSortList2(head);
        System.out.println(ListNode.listString(result));
        return result;
    }

    /**
     * 思路：逐个把旧链表的每个节点插入新链表的正确位置
     * <p>
     * 复杂度：时间O(n^2)，空间 O(1)
     * <p>
     * 执行耗时:25 ms,击败了8.66% 的Java用户
     * 内存消耗:40.9 MB,击败了59.68% 的Java用户
     */
    private ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null, p = head, q;
        while (p != null) {
            // 从旧链表中拆一个节点插到新链表头部
            q = p;
            p = p.next;
            q.next = newHead;
            newHead = q;

            // 插入新节点到新链表的正确位置
            while (q.next != null && q.val > q.next.val) {
                int temp = q.val;
                q.val = q.next.val;
                q.next.val = temp;
                q = q.next;
            }
        }

        return newHead;
    }

    /**
     * 思路：减少节点的交换次数，先定位到插入点，再插入，不用一个个交换过去
     * <p>
     * 复杂度：时间O(n^2)，空间 O(1)
     * <p>
     * 执行耗时:21 ms,击败了32.89% 的Java用户
     * 内存消耗:40.9 MB,击败了55.27% 的Java用
     */
    private ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode q = p;
            p = p.next;

            // 找到新节点在新链表的正确位置
            ListNode t = dummy;
            while (t.next != null && t.next.val < q.val) {
                t = t.next;
            }

            // 插入指定位置
            q.next = t.next;
            t.next = q;
        }

        return dummy.next;
    }

}
