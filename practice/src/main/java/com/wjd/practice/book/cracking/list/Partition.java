package com.wjd.practice.book.cracking.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 面试题 02.04. 分割链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * @author weijiaduo
 * @since 2023/12/15
 */
public class Partition {

    /**
     * 思路：遍历链表，将其分成 2 条链表，最后再拼起来
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.2 MB,击败了7.34% 的Java用户
     */
    @TestCase(input = {"[1,4,3,2,5,2]", "3", "[2,1]", "2"},
            output = {"[1,2,2,4,3,5]", "[1,2]"})
    public ListNode partition(ListNode head, int x) {
        ListNode sd = new ListNode(-1), st = sd;
        ListNode ld = new ListNode(-1), lt = ld;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            if (p.val < x) {
                st.next = p;
                st = st.next;
            } else {
                lt.next = p;
                lt = lt.next;
            }
            p = next;
        }
        lt.next = null;
        st.next = ld.next;
        return sd.next;
    }

}
