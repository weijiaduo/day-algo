package com.wjd.practice.leetcode.tree.statistics;


import com.wjd.structure.tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *
 * @since 2022-06-18
 */
public class MinimumTreeDepth {

    /**
     * 执行耗时:8 ms,击败了32.70% 的Java用户
     * 内存消耗:61.8 MB,击败了5.04% 的Java用户
     */
    public int minDepth(TreeNode root) {
        return bfs(root);
    }

    /**
     * 思路：深度优先，计算左右子树的高度，再判断最小值
     * <p>
     * 看来性能有点差，应该是遍历了很多没有用的子树
     * <p>
     * 执行耗时:8 ms,击败了32.70% 的Java用户
     * 内存消耗:61.8 MB,击败了5.04% 的Java用户
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 思路：广度优先，确实会快一些，毕竟只要遇到叶子节点即可返回
     * <p>
     * 执行耗时:1 ms,击败了89.43% 的Java用户
     * 内存消耗:60.6 MB,击败了69.05% 的Java用户
     */
    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            height++;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left == null && node.right == null) {
                    return height;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return height;
    }

}
