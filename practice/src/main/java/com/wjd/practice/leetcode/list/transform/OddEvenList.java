package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 328. 奇偶链表
 * <p>
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * <p>
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * <p>
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * <p>
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [1,2,3,4,5]
 * 输出:[1,3,5,2,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * <p>
 * 提示:
 * <p>
 * n == 链表中的节点数
 * 0 <= n <= 10⁴
 * -10⁶ <= Node.val <= 10⁶
 *
 * @author weijiaduo
 * @since 2023/10/9
 */
public class OddEvenList {

    /**
     * 思路：直接拆分成两条链表，再接起来就行了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了62.87% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "[2,1,3,5,6,4,7]"},
            output = {"[1,3,5,2,4]", "[2,3,6,7,1,5,4]"})
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oh = head, eh = head.next;
        ListNode ot = oh, et = eh;
        while (et != null && et.next != null) {
            ot.next = et.next;
            ot = ot.next;
            et.next = et.next.next;
            et = et.next;
        }
        ot.next = eh;
        return oh;
    }

}
