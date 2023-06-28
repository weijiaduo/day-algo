package com.wjd.practice.leetcode.list.sort;

import com.wjd.practice.leetcode.structure.Node;

/**
 * [剑指 Offer || 029]排序的循环链表
 * <p>
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 * <p>
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * <p>
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * <p>
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * <p>
 *
 * @since 2022/6/18
 */
public class InsertSorted {

    public Node solve(Object... args) {
        int[] values = {3, 3, 5};
        int insertVal = 4;
        Node head = Node.buildList(values);
        makeCircle(head);
        System.out.println(head);
        Node result = insert(head, insertVal);
        System.out.println(result);
        return result;
    }

    private void makeCircle(Node head) {
        if (head == null) {
            return;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
    }

    /**
     * 啧啧啧，竟然提交了那么多次才成功
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了5.37% 的Java用户
     */
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }

        Node p = head;
        while (p.next != null) {
            if (p.val <= p.next.val) {
                // 非降序部分
                if (p.val <= insertVal && insertVal <= p.next.val) {
                    insertNode.next = p.next;
                    p.next = insertNode;
                    break;
                }
            } else {
                // 头尾循环部分
                if (p.val <= insertVal || insertVal <= p.next.val) {
                    insertNode.next = p.next;
                    p.next = insertNode;
                    break;
                }
            }
            if (p.next == head) {
                insertNode.next = p.next;
                p.next = insertNode;
                break;
            }
            p = p.next;
        }

        return head;
    }

}
