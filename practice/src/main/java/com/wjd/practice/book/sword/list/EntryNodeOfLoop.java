package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 23. 链表中环的入口结点
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author weijiaduo
 * @since 2023/11/25
 */
public class EntryNodeOfLoop {

    @TestCase(input = {"[1,2,3,4,5,6,7]", "3", "[1,2,3,4,5,6,7]", "-1"},
            output = {"[3, 4,5,6,7]", "[]"})
    public ListNode loopEntry(ListNode head, int pos) {
        ListNode tail = head, p = null;
        while (tail.next != null) {
            if (--pos == 0) {
                p = tail;
            }
            tail = tail.next;
        }
        // 构造循环
        tail.next = p;
        return fastSlow(head);
    }

    /**
     * 思路：快慢指针，如果快指针追上了慢指针，说明有环
     * <p>
     * 然后从环上某一节点开始，再次快慢指针，就可以得到环的长度
     * <p>
     * 然后两个指针，一个先走环的长度，然后两个指针一起走，相遇的地方就是环的入口
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    public ListNode fastSlow(ListNode head) {
        if (head == null) {
            return null;
        }

        // 快慢指针，验证是否有环
        boolean hasCycle = false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow || fast.next == slow) {
                hasCycle = true;
                break;
            }
        }
        // 没有环直接返回
        if (!hasCycle) {
            return null;
        }

        // 环节点数量
        int circleSize = 1;
        fast = slow.next;
        while (fast != slow) {
            circleSize++;
            fast = fast.next;
        }

        // 前指针先走环节点数量
        fast = slow = head;
        while (circleSize > 0) {
            fast = fast.next;
            circleSize--;
        }
        // 前后指针同时移动
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
