package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

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

        // 1. 快慢指针对半分链表
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        // 2. 翻转链表
        head2 = reverse(head2);

        // 3. 对比两半连接是否一致
        boolean ans = true;
        ListNode p1 = head, p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                ans = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. 恢复链表
        head2 = reverse(head2);
        slow.next = head2;

        return ans;
    }

    /**
     * 翻转链表
     *
     * @param head 链表头节点
     * @return 翻转后的链头
     */
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        return dummy.next;
    }

}
