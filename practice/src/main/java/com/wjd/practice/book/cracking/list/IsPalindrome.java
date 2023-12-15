package com.wjd.practice.book.cracking.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 面试题 02.06. 回文链表
 * <p>
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * <p>
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 * <p>
 * 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author weijiaduo
 * @since 2023/12/15
 */
public class IsPalindrome {

    /**
     * 思路：利用快慢指针定位到中点，将链表后半部分反转，然后前后双指针遍历判断回文
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了94.32% 的Java用户
     * 内存消耗:47.5 MB,击败了22.87% 的Java用户
     */
    @TestCase(input = {"[1,2,2,1]", "[1,2]"},
            output = {"true", "false"})
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 快慢指针找到中间节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        // 拆分成两条链表，头插法
        ListNode dummy = new ListNode(-1);
        ListNode p = head2;
        while (p != null) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }

        // 对比两条链表是否一样
        ListNode p1 = head, p2 = dummy.next;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 恢复原始链表，头插法
        p = dummy.next;
        while (p != null) {
            ListNode next = p.next;
            p.next = slow.next;
            slow.next = p;
            p = next;
        }
        return true;
    }

}
