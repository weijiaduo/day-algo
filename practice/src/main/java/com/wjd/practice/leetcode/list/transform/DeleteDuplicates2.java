package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @since 2022/6/6
 */
public class DeleteDuplicates2 {

    /**
     * 思路：因为不保留重复元素，所以有可能表头会发生变化，所以用一个哨兵节点来实现
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了77.42% 的Java用户
     */
    @TestCase(input = {"[1,2,3,3,4,4,5]", "[1,1,1,2,3]"},
            output = {"[1,2,5]", "[2,3]"})
    public ListNode delete(ListNode head) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            if (next != null && p.val == next.val) {
                // 去除重复节点
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
            } else {
                // 非重复节点
                p.next = tail.next;
                tail.next = p;
                tail = p;
                p = next;
            }
        }
        return dummy.next;
    }
}
