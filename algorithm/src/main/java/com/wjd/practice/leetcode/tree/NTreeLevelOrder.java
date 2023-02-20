package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.generic.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 *
 * @author weijiaduo
 * @since 2022/12/10
 */
public class NTreeLevelOrder {

    /**
     * 思路：按层序遍历直接遍历即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:3 ms,击败了85.10% 的Java用户
     * 内存消耗:42.2 MB,击败了80.03% 的Java用户
     */
    public List<List<Integer>> solve(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }

                level.add(node.val);
                List<Node> children = node.children;
                if (children != null) {
                    for (Node child : children) {
                        queue.offer(child);
                    }
                }
            }
            ret.add(level);
        }
        return ret;
    }

}
