package com.wjd.practice.leetcode.stack;

import com.wjd.practice.leetcode.structure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1019. 链表中的下一个更大节点
 * <p>
 * 给定一个长度为 n 的链表 head
 * <p>
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * <p>
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
 * ，设置 answer[i] = 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数为 n
 * 1 <= n <= 10⁴
 * 1 <= Node.val <= 10⁹
 *
 * @author weijiaduo
 * @since 2023/4/10
 */
public class NextLargerNodes {

    /**
     * 思路：单调栈，单调递增
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:8 ms,击败了96.10% 的Java用户
     * 内存消耗:44.7 MB,击败了60.78% 的Java用户
     *
     * @param head 链表头
     */
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        int[] ans = new int[n];
        p = head;
        Deque<Pair> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().value < p.val) {
                Pair pair = stack.pop();
                ans[pair.index] = p.val;
            }
            stack.push(new Pair(i, p.val));
            p = p.next;
        }
        return ans;
    }

    record Pair(int index, int value) {
    }

}
