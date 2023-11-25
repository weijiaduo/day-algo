package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 142. 环形链表2
 * <p>
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * <p>
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * <p>
 * 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围在范围 [0, 10⁴] 内
 * -10⁵ <= Node.val <= 10⁵
 * pos 的值为 -1 或者链表中的一个有效索引
 *
 * @author weijiaduo
 * @since 2022-06-27
 */
public class DetectCycle {

    @TestCase(input = {"[1,2,3,4,5,6,7]", "3", "[1,2,3,4,5,6,7]", "-1"},
            output = {"[3, 4,5,6,7]", "[]"})
    public ListNode detectCycle(ListNode head, int pos) {
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
     * 思路：快慢指针，先找到环，然后算出环的长度，最后再用一次快慢指针，快指针领先慢指针环长度个节点
     * <p>
     * 复杂度：时间O(n)，空间O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了31.50% 的Java用户
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
