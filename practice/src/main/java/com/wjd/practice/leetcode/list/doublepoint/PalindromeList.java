package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 234. 回文链表
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 10⁵] 内
 * 0 <= Node.val <= 9
 *
 * @author weijiaduo
 * @since 2023/6/10
 */
public class PalindromeList {

    /**
     * 思路：利用快慢指针定位到中点，将链表后半部分反转，然后前后双指针遍历判断回文
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了79.22% 的Java用户
     * 内存消耗:58 MB,击败了26.02% 的Java用户
     */
    @TestCase(input = {"[1,2,2,1]", "[1,2]"},
            output = {"true", "false"})
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 快慢指针定位到中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分链表指针
        ListNode head2 = slow, p = slow;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = head2;
            head2 = p;
            p = tmp;
        }

        // 判断回文
        boolean flag = true;
        ListNode l = head, r = head2;
        while (l != r) {
            if (l.val != r.val) {
                flag = false;
                break;
            }
            l = l.next;
            r = r.next;
        }

        // 恢复后半部分的链表
        p = head2;
        while (head2 != slow) {
            ListNode tmp = p.next;
            p.next = head2;
            head2 = p;
            p = tmp;
        }

        return flag;
    }

}
