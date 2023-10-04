package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.practice.leetcode.structure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @since 2022/5/15
 */
public class RemoveNthFromEnd {

    /**
     * 官方题解
     * <p>
     * 思路：算出倒数第 n 个节点的正向偏移量，然后移除它
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了12.56% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "2", "[1]", "1", "[1,2]", "1"},
            output = {"[1,2,3,5]", "[]", "[1]"})
    public ListNode offset(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        // 哨兵节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 统计链表长度
        int len = 0;
        ListNode p = dummy;
        while (p != null) {
            len++;
            p = p.next;
        }
        // 非法移除参数
        if (len < n) {
            return head;
        }

        // 移动偏移量，倒数第 n+1 个节点
        p = dummy;
        for (int i = 1; i < len - n; i++) {
            p = p.next;
        }
        // 移除倒数第 n 个节点
        p.next = p.next.next;
        return dummy.next;
    }

    /**
     * 官方题解
     * <p>
     * 思路：栈，使用栈保存链表所有节点，再重新弹出时，第 n 个弹出的就是要移除的
     * <p>
     * 复杂度：O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了4.95% 的Java用户
     * 内存消耗:39.6 MB,击败了47.09% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "2", "[1]", "1", "[1,2]", "1"},
            output = {"[1,2,3,5]", "[]", "[1]"})
    public ListNode stack(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        Deque<ListNode> stack = new LinkedList<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        // 非法移除参数
        if (stack.size() < n) {
            return head;
        }

        // 先弹出 n 个节点
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        // 移除倒数第 n 个节点
        p = stack.peek();
        p.next = p.next.next;
        return dummy.next;
    }

    /**
     * 思路：快慢指针，快指针比慢指针快 n 个节点，等快指针达到尾部时，慢指针就是倒数第 n 个节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了19.37% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "2", "[1]", "1", "[1,2]", "1"},
            output = {"[1,2,3,5]", "[]", "[1]"})
    public ListNode doublePoint(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, q = dummy;
        int k = n;
        while (p.next != null) {
            // p 最终指向倒数第1个节点
            p = p.next;
            if (k == 0) {
                // q 最终指向倒数第n+1个节点
                q = q.next;
            } else {
                // 走过n个节点
                k--;
            }
        }
        // 删除倒数第 n 个节点
        q.next = q.next.next;
        return dummy.next;
    }

}
