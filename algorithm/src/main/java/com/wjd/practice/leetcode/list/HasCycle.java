package com.wjd.practice.leetcode.list;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 141. 环形链表
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * @since 2022/6/19
 */
public class HasCycle implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        return null;
    }

    /**
     * 思路：快慢指针，快指针追上慢指针的话，就说明回头了，存在环
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.1 MB,击败了5.07% 的Java用户
     */
    private boolean hasCycle(ListNode head) {
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
