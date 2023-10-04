package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 141. 环形链表
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * <p>
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * <p>
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 10⁴]
 * -10⁵ <= Node.val <= 10⁵
 * pos 为 -1 或者链表中的一个 有效索引 。
 *
 * @since 2022/6/19
 */
public class HasCycle {

    /**
     * 思路：快慢指针，快指针追上慢指针的话，就说明回头了，存在环
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.1 MB,击败了5.07% 的Java用户
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p = head.next, q = head;
        while (p != null) {
            if (p == q || p.next == q) {
                return true;
            }
            p = p.next;
            if (p != null) {
                p = p.next;
            }
            q = q.next;
        }

        return false;
    }

}
