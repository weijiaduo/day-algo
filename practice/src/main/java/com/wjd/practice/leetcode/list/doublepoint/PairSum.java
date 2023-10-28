package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * 2130. 链表最大孪生和
 * <p>
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，
 * <p>
 * 第 i 个节点（下标从 0 开始）的孪生节点为第(n-1-i) 个节点 。
 * <p>
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * <p>
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 * <p>
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [5,4,2,1]
 * 输出：6
 * 解释：
 * 节点 0 和节点 1 分别是节点 3 和 2 的孪生节点。孪生和都为 6 。
 * 链表中没有其他孪生节点。
 * 所以，链表的最大孪生和是 6 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [4,2,2,3]
 * 输出：7
 * 解释：
 * 链表中的孪生节点为：
 * - 节点 0 是节点 3 的孪生节点，孪生和为 4 + 3 = 7 。
 * - 节点 1 是节点 2 的孪生节点，孪生和为 2 + 2 = 4 。
 * 所以，最大孪生和为 max(7, 4) = 7 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1,100000]
 * 输出：100001
 * 解释：
 * 链表中只有一对孪生节点，孪生和为 1 + 100000 = 100001 。
 * <p>
 * 提示：
 * <p>
 * 链表的节点数目是 [2, 10⁵] 中的 偶数 。
 * 1 <= Node.val <= 10⁵
 *
 * @author weijiaduo
 * @since 2023/10/10
 */
public class PairSum {

    /**
     * 思路：快慢指针，找到中点后，将后半部分链表反转，
     * <p>
     * 反转后变成了两条链表，并且两条链表相交于中点
     * <p>
     * 然后一个从头遍历到中间，一个从末尾遍历到中间，就能算出结果
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了51.06% 的Java用户
     * 内存消耗:65.4 MB,击败了11.14% 的Java用户
     */
    @TestCase(input = {"[5,4,2,1]", "[4,2,2,3]", "[1,100000]"},
            output = {"6", "7", "100001"})
    public int intersect(ListNode head) {
        // 快慢指针找到中点
        ListNode slow = head, fast = head.next;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分链表指针（这里结束后有个自环）
        ListNode q = slow, p = slow;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = q;
            q = p;
            p = tmp;
        }

        // 遍历两条链表求值（利用自环判断遍历结束）
        int ans = Integer.MIN_VALUE;
        ListNode l = head, r = q;
        while (l != r) {
            ans = Math.max(l.val + r.val, ans);
            l = l.next;
            r = r.next;
        }

        // 恢复反转的后半部分链表
        l = q;
        r = null;
        while (r != slow) {
            ListNode tmp = l.next;
            l.next = r;
            r = l;
            l = tmp;
        }

        return ans;
    }

    /**
     * 思路：快慢指针，找到中点后，将后半部分链表反转
     * <p>
     * 反转后还是一条链表
     * <p>
     * 然后一个从头遍历到中间，一个从中间遍历到末尾，就能算出结果
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了51.06% 的Java用户
     * 内存消耗:66.4 MB,击败了7.38% 的Java用户
     */
    @TestCase(input = {"[5,4,2,1]", "[4,2,2,3]", "[1,100000]"},
            output = {"6", "7", "100001"})
    private int reverseHalf(ListNode head) {
        // 快慢指针找到中点
        ListNode slow = head, fast = head.next;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分链表
        slow.next = reverse(slow.next);

        // 遍历两部分链表求值
        int ans = Integer.MIN_VALUE;
        ListNode p = head, q = slow.next;
        while (q != null) {
            ans = Math.max(p.val + q.val, ans);
            p = p.next;
            q = q.next;
        }

        // 恢复反转的后半部分链表
        slow.next = reverse(slow.next);
        return ans;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
