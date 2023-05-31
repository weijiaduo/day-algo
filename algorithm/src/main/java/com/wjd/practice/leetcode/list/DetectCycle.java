package com.wjd.practice.leetcode.list;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 142. 环形链表2
 * <p>
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。
 * <p>
 * 如果链表无环，则返回 null。
 * <p>
 * 不允许修改 链表。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @author weijiaduo
 * @since 2022-06-27
 */
public class DetectCycle {

    /**
     * 思路：快慢指针，先找到环，然后算出环的长度，最后再用一次快慢指针，快指针领先慢指针环长度个节点
     * <p>
     * 复杂度：时间O(n)，空间O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了31.50% 的Java用户
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode beginCircle = null;
        ListNode fast = head, slow = head;
        boolean flag = false;

        // 快慢指针，验证是否有环
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow || fast.next == slow) {
                flag = true;
                break;
            }
        }

        if (flag) {
            // 环节点数量
            int circleSize = 1;
            fast = slow.next;
            while (fast != slow) {
                circleSize++;
                fast = fast.next;
            }

            fast = head;
            slow = head;

            // 快指针先走环节点数量
            while (circleSize > 0) {
                fast = fast.next;
                circleSize--;
            }
            // 快慢指针同时移动
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            beginCircle = fast;
        }

        return beginCircle;
    }
}
