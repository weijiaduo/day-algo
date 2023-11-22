package com.wjd.practice.book.sword.list;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 6. 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class PrintListFromTailToHead {

    /**
     * 思路：遍历链表，将值放入列表，然后反转列表
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = "[1,2,3]", output = "[3,2,1]")
    public List<Integer> print(ListNode listNode) {
        List<Integer> res = new ArrayList<>();
        ListNode p = listNode;
        while (p != null) {
            res.add(p.val);
            p = p.next;
        }
        // 反转列表，相当于出栈顺序
        if (res.size() > 0) {
            Collections.reverse(res);
        }
        return res;
    }

}
