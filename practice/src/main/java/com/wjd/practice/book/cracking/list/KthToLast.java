package com.wjd.practice.book.cracking.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * <p>
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * <p>
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 *
 * @author weijiaduo
 * @since 2023/11/25
 */
public class KthToLast {

    /**
     * 思路：前后指针，
     * <p>
     * 一个指针先移动 k 步，
     * <p>
     * 然后两个指针一起移动，前指针到达末尾时，后指针指向倒数第 k 个节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了50.08% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "1", "[1,2,3]", "4",},
            output = {"[3]", "[]"})
    public int find(ListNode head, int k) {
        int i = 0;
        ListNode p = head, q = head;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return q.val;
    }

}
