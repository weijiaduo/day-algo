package com.wjd.practice.leetcode.list;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 返回复制链表的头节点。
 *
 * @author weijiaduo
 * @since 2022/6/26
 */
public class CopyRandomList implements Solution<Node> {

    @Override
    public Node solve(Object... args) {
        return null;
    }

    private Node copyRandomList(Node head) {
        return hashCopyRandomList(head);
    }

    /**
     * 思路：哈希表保存新旧节点映射
     * <p>
     * 复杂度：时间 o(n)，空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了60.97% 的Java用户
     */
    private Node hashCopyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }

        p = head;
        while (p != null) {
            Node node = map.get(p);
            if (p.next != null) {
                node.next = map.get(p.next);
            }
            if (p.random != null) {
                node.random = map.get(p.random);
            }
            p = p.next;
        }

        return map.get(head);
    }

    /**
     * 思路：在原链表上直接复制一份节点，插入原节点后面，构造好关系后，再拆分成2条链表
     * <p>
     * 复杂度：时间 O(n)，空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了5.26% 的Java用户
     */
    private Node doubleCopyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 每个节点都复制一份，放在后一个位置
        Node p = head, q;
        while (p != null) {
            q = p.next;
            Node node = new Node(p.val);
            node.next = q;
            p.next = node;
            p = q;
        }

        // 新节点指向新的随机节点
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 拆分成2条链表
        Node newHead = head.next;
        p = head;
        q = newHead;
        while (p != null) {
            p.next = q.next;
            p = p.next;
            if (p != null) {
                q.next = p.next;
                q = q.next;
            }
        }

        return newHead;
    }

}
