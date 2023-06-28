package com.wjd.practice.leetcode.list.transform;

import com.wjd.practice.leetcode.structure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * <p>
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 * @author weijiaduo
 * @since 2023/6/11
 */
public class RemoveZeroSumSublists {

    public ListNode removeZeroSumSublists(ListNode head) {
        return prefix2(head);
    }

    /**
     * 类似 560. 和为 K 的子数组
     * <p>
     * 思路：前缀和，记录前缀和 pre[r]，sum[l, r] 可由 pre[r] - pre[j] 得到
     * <p>
     * 求 pre[r] - pre[l] = 0，等价于求 pre[l] = pre[r]
     * <p>
     * 只要遍历到 r 时，然后在前面找到前缀和为 pre[r] - k 的 pre[l]
     * <p>
     * 复杂度：最好时间 O(n) 最坏时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:9 ms,击败了5.50% 的Java用户
     * 内存消耗:42.5 MB,击败了5.18% 的Java用户
     */
    private ListNode prefix(ListNode head) {
        boolean mayHasZero = true;
        while (mayHasZero) {
            mayHasZero = false;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            Map<Integer, ListNode> map = new HashMap<>();
            map.put(0, dummy);
            int prefix = 0;
            ListNode p = head;
            while (p != null) {
                prefix += p.val;
                // 找到满足 pre[r] - pre[l] = 0 的位置
                ListNode s = map.get(prefix);
                if (s != null) {
                    // 移除和为 0 的子链表
                    s.next = p.next;
                    // 继续下一轮移除
                    mayHasZero = true;
                    break;
                }
                // 记录当前位置的前缀和
                map.put(prefix, p);
                p = p.next;
            }
            head = dummy.next;
        }
        return head;
    }

    /**
     * 思路：前缀和，但是优化了删除算法，不需要一轮一轮地删除和为 0 的子链表
     * <p>
     * 假如存在多个 pre[i] = pre[j] = pre[k]，且 i < j < k
     * <p>
     * 那么实际上只要删除 [i+1, k] 子链表，实际上就已经将 [i+1, j] 包括在内了
     * <p>
     * 所以，相同前缀和只需要保留最后一个位置即可，然后删除时自会删除掉中间所有和为 0 的子链表
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了82.52% 的Java用户
     * 内存消耗:42 MB,击败了20.72% 的Java用户
     */
    private ListNode prefix2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();

        // 记录所有节点的前缀和
        // 存在相同前缀和时，记录索引最大的那个
        int prefix = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            prefix += p.val;
            map.put(prefix, p);
        }

        // 找到 pre[r] = pre[l] 的位置，移除 [l+1, r]
        // 相同的前缀 pre[r] 在上一步中保留的是最大的索引
        // 所以直接删除的话，中间所有和为 0 子串都会被删除
        prefix = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            prefix += p.val;
            ListNode q = map.get(prefix);
            p.next = q.next;
        }
        return dummy.next;
    }

}
