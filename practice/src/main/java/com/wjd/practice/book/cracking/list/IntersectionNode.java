package com.wjd.practice.book.cracking.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 面试题 02.07. 链表相交
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * <p>
 * 提示：
 * <p>
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 10⁴
 * 1 <= Node.val <= 10⁵
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * <p>
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 *
 * @author weijiaduo
 * @since 2023/12/16
 */
public class IntersectionNode {

    /**
     * 思路：前后双指针，先算2条链表的长度，
     * <p>
     * 再提前移动长链表的指针，然后同时移动长短链表的指针，双指针相等的地方就是相交点
     * <p>
     * 复杂度：时间O(m + n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.23% 的Java用户
     * 内存消耗:45.7 MB,击败了5.93% 的Java用户
     */
    @TestCase(input = {"[4,1,8,4,5]", "[5,6,1,8,4,5]", "[1,9,1,2,4]", "[3,2,4]", "[2,6,4]", "[1,5]"},
            output = {"[8,4,5]", "[2,4]", ""})
    public ListNode intersect(ListNode headA, ListNode headB) {
        // 计算两条链表的长度
        int lenA = 0, lenB = 0;
        ListNode p = headA;
        while (p != null) {
            lenA++;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            lenB++;
            p = p.next;
        }
        if (lenA == 0 || lenB == 0) {
            return null;
        }

        // 长链表先往前走
        ListNode pa = headA, pb = headB;
        int k = Math.abs(lenA - lenB);
        if (lenA < lenB) {
            for (int i = 0; i < k; i++) {
                pb = pb.next;
            }
        } else {
            for (int i = 0; i < k; i++) {
                pa = pa.next;
            }
        }

        // 寻找公共节点
        while (pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }

}
