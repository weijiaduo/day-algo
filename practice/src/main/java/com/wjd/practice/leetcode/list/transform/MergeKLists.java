package com.wjd.practice.leetcode.list.transform;

import com.wjd.structure.list.ListNode;

/**
 * 23. 合并K个升序链表
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * @since 2022/5/15
 */
public class MergeKLists {

    /**
     * 思路：分治法，链表两两合并起来，最后合成 1 条
     * <p>
     * 复杂度：时间 O(nlogn * l) 空间 O(logn)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.1 MB,击败了94.83% 的Java用户
     */
    // @TestCase(input = {"[[1,4,5],[1,3,4],[2,6]]", "[]", "[[]]"},
    //         output = {"[1,1,2,3,4,4,5,6]", "[]", "[]"})
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return partMerge(lists, 0, lists.length - 1);
    }

    /**
     * 分治法合并多条链表
     */
    private ListNode partMerge(ListNode[] lists, int start, int end) {
        if (end <= start) {
            return lists[start];
        }

        // 分治
        int mid = start + (end - start) / 2;
        ListNode left = partMerge(lists, start, mid);
        ListNode right = partMerge(lists, mid + 1, end);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode p = left, q = right;
        while (p != null && q != null) {
            if (p.val < q.val) {
                tail.next = p;
                p = p.next;
            } else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }
        tail.next = p != null ? p : q;
        return dummy.next;
    }

}
