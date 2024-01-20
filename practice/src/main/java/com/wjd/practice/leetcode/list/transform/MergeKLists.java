package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
     * 这里是因为 @TestCase 注解的问题，需要写成 List，才多增加一个方法
     */
    @TestCase(input = {"[[1,4,5],[1,3,4],[2,6]]"},
            output = {"[1,1,2,3,4,4,5,6]"})
    public ListNode heap(List<ListNode> lists) {
        return heap(lists.toArray(new ListNode[0]));
    }

    /**
     * 思路：最小堆，保存每条链表的头节点
     * <p>
     * 然后每次从堆顶获取最小值，即是有序的
     * <p>
     * 复杂度：时间 O(kn * logk) 空间 O(logk)
     * <p>
     * 执行耗时:6 ms,击败了34.42% 的Java用户
     * 内存消耗:43.4 MB,击败了15.18% 的Java用户
     */
    private ListNode heap(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        ListNode dummy = new ListNode(-1), tail = dummy;
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            ListNode next = cur.next;
            tail.next = cur;
            tail = tail.next;
            cur = next;
            if (cur != null) {
                heap.add(cur);
            }
        }
        return dummy.next;
    }

    /**
     * 这里是因为 @TestCase 注解的问题，需要写成 List，才多增加一个方法
     */
    @TestCase(input = {"[[1,4,5],[1,3,4],[2,6]]"},
            output = {"[1,1,2,3,4,4,5,6]"})
    public ListNode divide(List<ListNode> lists) {
        return divide(lists.toArray(new ListNode[0]));
    }

    /**
     * 思路：分治法，链表两两合并起来，最后合成 1 条
     * <p>
     * 复杂度：时间 O(kn * logk) 空间 O(logk)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.1 MB,击败了94.83% 的Java用户
     * <p>
     * 这里是因为 @TestCase 注解的问题，需要写成 List，才多增加一个方法
     */
    private ListNode divide(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }

    /**
     * 分治法合并多条有序链表
     *
     * @param lists 链表集合
     * @param start [start, end]
     * @param end   [start, end]
     * @return 合并链表
     */
    private ListNode divide(ListNode[] lists, int start, int end) {
        if (end <= start) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid + 1, end);
        return merge(left, right);
    }

    /**
     * 合并两条有序链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode p = list1, q = list2;
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
