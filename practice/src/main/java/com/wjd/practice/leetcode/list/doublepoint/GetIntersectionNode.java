package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 160. 相交链表
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * <p>
 * 如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 自定义评测：
 * <p>
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 * <p>
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * <p>
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。
 * <p>
 * 如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。
 * <p>
 * 换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
 * <p>
 * 示例 2：
 * <p>
 * 输入：intersectVal= 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
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
 * 1 <= m, n <= 3 * 10⁴
 * 1 <= Node.val <= 10⁵
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class GetIntersectionNode {

    /**
     * 思路：前后双指针，先算2条链表的长度，再提前移动长链表的指针，然后同时移动长短链表的指针，双指针相等的地方就是相交点
     * <p>
     * 复杂度：时间O(m + n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了97.85% 的Java用户
     * 内存消耗:44.2 MB,击败了56.31% 的Java用户
     */
    @TestCase(input = {"[4,1,8,4,5]", "[5,6,1,8,4,5]", "[1,9,1,2,4]", "[3,2,4]", "[2,6,4]", "[1,5]"},
            output = {"[8,4,5]", "[2,4]", ""})
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // 计算两条链表长度
        ListNode p = headA, q = headB;
        int al = 1, bl = 1;
        while (p.next != null) {
            p = p.next;
            al++;
        }
        while (q.next != null) {
            q = q.next;
            bl++;
        }

        // 判断是否相交
        if (p != q) {
            return null;
        }

        // 先分出长短链表
        ListNode l, s;
        int k = 0;
        if (al < bl) {
            l = headB;
            s = headA;
            k = bl - al;
        } else {
            l = headA;
            s = headB;
            k = al - bl;
        }

        // 前后指针，长链表先走，短链表后走
        for (int i = 0; i < k; i++) {
            l = l.next;
        }
        while (l != s) {
            l = l.next;
            s = s.next;
        }
        return l;
    }

    /**
     * 官解：这么简洁的吗
     * <p>
     * 思路：假装将两条链表拼接起来，一条是 A+B，一条是 B+A
     * <p>
     * 这样遍历两条链表，最终两指针相等的地方就是链表的交接处
     * <p>
     * 复杂度：时间O(m + n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了97.85% 的Java用户
     * 内存消耗:44.3 MB,击败了43.16% 的Java用户
     */
    @TestCase(input = {"[4,1,8,4,5]", "[5,6,1,8,4,5]", "[1,9,1,2,4]", "[3,2,4]", "[2,6,4]", "[1,5]"},
            output = {"[8,4,5]", "[2,4]", ""})
    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
