package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.practice.leetcode.structure.ListNode;

/**
 * 2095. 删除链表的中间节点
 * <p>
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * <p>
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * <p>
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,4,7,1,2,6]
 * 输出：[1,3,4,1,2,6]
 * 解释：
 * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
 * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
 * 返回结果为移除节点后的新链表。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,2,4]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [2,1]
 * 输出：[2]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
 * 值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [1, 10⁵] 内
 * 1 <= Node.val <= 10⁵
 *
 * @author weijiaduo
 * @since 2023/10/9
 */
public class DeleteMiddle {

    /**
     * 思路：快慢指针，当快指针走到链尾时，慢指针刚好在中间位置
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了100.00% 的Java用户
     * 内存消耗:62.2 MB,击败了21.82% 的Java用户
     */
    @TestCase(input = {"[1,3,4,7,1,2,6]", "[1,2,3,4]", "[2,1]"},
            output = {"[1,3,4,1,2,6]", "[1,2,4]", "[2]"})
    public ListNode slowFast(ListNode head) {
        // 增加哨兵节点，以处理只有一个节点的情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 删除中间节点
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

}
