package com.wjd.practice.leetcode.list;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 83. 删除排序链表中的重复元素2
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。
 * <p>
 * 返回 已排序的链表 。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 *
 * @since 2022/6/6
 */
public class DeleteDuplicates2 {

    /**
     * 思路：因为不保留重复元素，所以有可能表头会发生变化，所以用一个哨兵节点来实现
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了77.42% 的Java用户
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = head, tail = dummy;
        while (p != null) {
            if (p.next != null && p.next.val == p.val) {
                // 重复元素
                ListNode q = p;
                while (p != null && p.val == q.val) {
                    p = p.next;
                }
            } else {
                // 非重复元素
                tail.next = p;
                tail = tail.next;
                p = p.next;
                // 这个必须设置为nul，如果后面都是重复元素的话，会连在后面
                tail.next = null;
            }
        }
        return dummy.next;
    }
}
