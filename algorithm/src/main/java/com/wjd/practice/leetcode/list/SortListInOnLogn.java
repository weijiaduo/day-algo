package com.wjd.practice.leetcode.list;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 148. 排序链表
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * /输出：[-1,0,3,4,5]
 *
 * @author weijiaduo
 * @since 2022-06-27
 */
public class SortListInOnLogn {

    public ListNode sortList(ListNode head) {
        return dfs(head);
    }

    /**
     * 思路：归并，分治处理子链表，再将它们合并起来
     * <p>
     * 复杂度：时间 O(nlogn)，空间 O(1)
     * <p>
     * 执行耗时:10 ms,击败了54.12% 的Java用户
     * 内存消耗:49 MB,击败了67.31% 的Java用户
     */
    private ListNode dfs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针找到中点，分割成2条链表
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分别对2条链表进行排序
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);

        // 合并排序好的2条链表
        return merge(left, right);
    }

    /**
     * 合并有序链表
     */
    public static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (left != null && right != null) {
            if (left.val > right.val) {
                p.next = right;
                right = right.next;
            } else {
                p.next = left;
                left = left.next;
            }
            p = p.next;
        }

        if (left != null) {
            p.next = left;
        }
        if (right != null) {
            p.next = right;
        }

        return dummy.next;
    }

}
