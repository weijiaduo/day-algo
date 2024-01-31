package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

/**
 * LCR 140. 训练计划 II
 * <p>
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [2,4,7,8], cnt = 1
 * 输出：8
 * <p>
 * 提示：
 * <p>
 * 1 <= head.length <= 100
 * 0 <= head[i] <= 100
 * 1 <= cnt <= head.length
 *
 * @author weijiaduo
 * @since 2024/1/31
 */
public class TrainingPlan {

    /**
     * 思路：前后指针
     * <p>
     * 前指针先行，后指针再走
     * <p>
     * 当前指针抵达链尾时，后指针正好指向目标节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.5 MB,击败了20.73% 的Java用户
     */
    @TestCase(input = {"[2,4,7,8]", "1"},
            output = {"8"})
    public ListNode doublePoint(ListNode head, int cnt) {
        ListNode p = head, q = head;
        // 1. 前指针先行
        for (int i = 0; i < cnt; i++) {
            p = p.next;
        }
        // 2. 后指针也出发
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        // 3. 后指针正好指向目标节点
        return q;
    }

}
