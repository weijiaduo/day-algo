package com.wjd.practice.leetcode.list.sort;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.practice.leetcode.structure.ListNode;

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
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分别对2条链表进行排序
        ListNode right = mergeSort(slow.next);
        slow.next = null;
        ListNode left = mergeSort(head);

        // 合并排序好的2条链表
        return merge(left, right);
    }

    /**
     * 合并有序链表
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        while (left != null && right != null) {
            if (left.val > right.val) {
                tail.next = right;
                right = right.next;
            } else {
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }
        tail.next = left != null ? left : right;
        return dummy.next;
    }

}
