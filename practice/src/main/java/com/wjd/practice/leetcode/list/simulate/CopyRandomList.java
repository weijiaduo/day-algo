package com.wjd.practice.leetcode.list.simulate;

import com.wjd.practice.leetcode.structure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * <p>
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * <p>
 * 复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。
 * <p>
 * 那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * <p>
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
 * <p>
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * -10⁴ <= Node.val <= 10⁴
 * Node.random 为 null 或指向链表中的节点。
 *
 * @author weijiaduo
 * @since 2022/6/26
 */
public class CopyRandomList {

    /**
     * 思路：哈希表保存新旧节点映射
     * <p>
     * 复杂度：时间 o(n)，空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了60.97% 的Java用户
     */
    public Node hashCopyRandomList(Node head) {
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
    public Node doubleCopyRandomList(Node head) {
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
