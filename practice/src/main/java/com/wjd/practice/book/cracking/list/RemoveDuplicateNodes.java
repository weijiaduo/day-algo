package com.wjd.practice.book.cracking.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * <p>
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * <p>
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * <p>
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * @author weijiaduo
 * @since 2023/12/14
 */
public class RemoveDuplicateNodes {

    /**
     * 思路：hash 去重
     * <p>
     * 将链表节点转移到新链表，加入新链表前使用 hash 去重
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了94.40% 的Java用户
     * 内存消耗:43 MB,击败了26.94% 的Java用户
     */
    @TestCase(input = {"[1, 2, 3, 3, 2, 1]", "[1, 1, 1, 1, 2]"},
            output = {"[1, 2, 3]", "[1, 2]"})
    public ListNode hash(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        Set<Integer> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            if (set.add(p.val)) {
                tail.next = p;
                tail = tail.next;
                tail.next = null;
            }
            p = next;
        }
        return dummy.next;
    }

}
