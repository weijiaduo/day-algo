package com.wjd.algorithm.practice.leetcode.list;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.ListNode;

/**
 * 86. 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * @since 2022/6/6
 */
public class Partition implements Solution<ListNode> {

    @Override
    public ListNode solve(Object... args) {
        int x = 2;
        int[] values = {2,1};
        ListNode head = ListNode.build(values);
        System.out.println(ListNode.listString(head));
        ListNode result = partition(head, x);
        System.out.println(ListNode.listString(result));
        return result;
    }

    /**
     * 双指针法
     *
     * 思路：使用两条链表分别表示小于和大于等于的情况，最后再合并起来
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了5.24% 的Java用户
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lh = new ListNode(0), lt = lh;
        ListNode gh = new ListNode(0), gt = gh;

        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                lt.next = p;
                lt = lt.next;
            } else {
                gt.next = p;
                gt = gt.next;
            }
            p = p.next;
        }

        gt.next = null;
        lt.next = gh.next;
        return lh.next;
    }

}
