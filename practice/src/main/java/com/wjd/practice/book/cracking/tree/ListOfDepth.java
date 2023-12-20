package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.list.ListNode;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表
 * <p>
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * //        1
 * //       /  \
 * //      2    3
 * //     / \    \
 * //    4   5    7
 * //   /
 * //  8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * @author weijiaduo
 * @since 2023/12/20
 */
public class ListOfDepth {

    /**
     * 思路：层序遍历，拿到每一层的节点就能构造成链表
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了48.72% 的Java用户
     * 内存消耗:40.6 MB,击败了5.13% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5,null,7,8]"},
            output = {"[[1],[2,3],[4,5,7],[8]]"})
    public ListNode[] bfs(TreeNode tree) {
        if (tree == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(-1), tail = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                tail.next = new ListNode(node.val);
                tail = tail.next;
            }
            list.add(dummy.next);
        }
        return list.toArray(new ListNode[0]);
    }

}
