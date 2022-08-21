package com.wjd.practice.leetcode.list;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.Node;

/**
 * 判断回文链表
 *
 * @author weijiaduo
 * @since 2022/8/21
 */
public class PalindromeList implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        int[] values = {1,2,3,2,1};
        Node head = Node.buildList(values);
        boolean result = isPalindromeList(head);
        System.out.println(result);
        return result;
    }

    private boolean isPalindromeList(Node head) {
        return reversePalindromeList(head);
    }

    /**
     * 思路：快慢指针，反转前半部分链表，从中间往两边遍历链表判断回文
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     *
     * @param head 表头
     * @return true/false
     */
    private boolean reversePalindromeList(Node head) {
        // 翻转前半部分链表
        Node slow = head, fast = head.next;
        Node last = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            Node p = slow;
            slow = slow.next;
            p.next = last;
            last = p;
        }
        // 中点包括在左链表中
        Node right = slow.next;
        Node left = slow;
        left.next = last;

        // 对比左右链表是否相等
        boolean result = true;
        Node p = left, q = right;
        if (fast == null) {
            // 奇数节点时，中点不在比较范围内
            p = p.next;
        }
        while (p != null && q != null) {
            if (p.val != q.val) {
                result = false;
                break;
            }
            p = p.next;
            q = q.next;
        }

        // 恢复翻转的前半部分链表
        last = right;
        while (left != null) {
            p = left;
            left = left.next;
            p.next = last;
            last = p;
        }

        return result;
    }

}
