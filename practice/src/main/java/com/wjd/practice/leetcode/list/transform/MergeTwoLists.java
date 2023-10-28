package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @author weijiaduo
 * @since 2023/6/10
 */
public class MergeTwoLists {

    /**
     * 思路：将两条链表按大小顺序重新插入一条新链表
     * <p>
     * 复杂度：时间 O(min(m, n)) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了96.00% 的Java用户
     */
    @TestCase(input = {"[1,2,4]", "[1,3,4]", "[]", "[]", "[]", "[0]"},
            output = {"[1,1,2,3,4,4]", "[]", "[0]"})
    public ListNode iterate(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 合并两条链表到新链表
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy, p = list1, q = list2;
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
        // 补完剩余的链表（官解这里精彩）
        tail.next = p != null ? p : q;
        return dummy.next;
    }

    /**
     * 官方解答
     * <p>
     * 思路：递归，从尾部开始递归合并两条链表
     * <p>
     * 复杂度：时间 O(min(m, n)) 空间 O(min(m, n))
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.4 MB,击败了84.12% 的Java用户
     */
    @TestCase(input = {"[1,2,4]", "[1,3,4]", "[]", "[]", "[]", "[0]"},
            output = {"[1,1,2,3,4,4]", "[]", "[0]"})
    public ListNode recursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = recursive(list1.next, list2);
            return list1;
        } else {
            list2.next = recursive(list1, list2.next);
            return list2;
        }
    }

}
