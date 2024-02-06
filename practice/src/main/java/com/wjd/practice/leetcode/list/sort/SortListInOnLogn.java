package com.wjd.practice.leetcode.list.sort;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 148. 排序链表
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 10⁴] 内
 * -10⁵ <= Node.val <= 10⁵
 *
 * @author weijiaduo
 * @since 2022-06-27
 */
public class SortListInOnLogn {

    /**
     * 思路：归并，分治处理子链表，再将它们合并起来
     * <p>
     * 复杂度：时间 O(nlogn)，空间 O(1)
     * <p>
     * 执行耗时:10 ms,击败了91.68% 的Java用户
     * 内存消耗:54.8 MB,击败了20.31% 的Java用户
     */
    @TestCase(input = {"[4,2,1,3]", "[-1,5,3,4,0]", "[]"},
            output = {"[1,2,3,4]", "[-1,0,3,4,5]", "[]"})
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针找到中点，分割成2条链表
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        // 分别对两段进行排序
        head = mergeSort(head);
        head2 = mergeSort(head2);

        // 合并两条链表
        return merge(head, head2);
    }

    /**
     * 合并有序链表
     */
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        ListNode p1 = h1, p2 = h2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ListNode next = p1.next;
                p1.next = tail.next;
                tail.next = p1;
                tail = tail.next;
                p1 = next;
            } else {
                ListNode next = p2.next;
                p2.next = tail.next;
                tail.next = p2;
                tail = tail.next;
                p2 = next;
            }
        }
        tail.next = p1 != null ? p1 : p2;
        return dummy.next;
    }

}
