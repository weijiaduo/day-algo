package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @since 2022/5/22
 */
public class DeleteDuplicates {

    /**
     * 思路：新开链表，追加节点时判断是否和链尾的值相等
     * <p>
     * 如果相等，就不添加；反之添加
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了56.33% 的Java用户
     */
    @TestCase(input = {"[1,1,2]", "[1,1,2,3,3]"},
            output = {"[1,2]", "[1,2,3]"})
    public ListNode delete(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 头节点不会变化，所以直接用就行
        ListNode tail = head, p = tail.next;
        // 避免后面连着重复节点
        tail.next = null;
        while (p != null) {
            ListNode next = p.next;
            if (tail.val != p.val) {
                p.next = tail.next;
                tail.next = p;
                tail = tail.next;
            }
            p = next;
        }
        return head;
    }

}
