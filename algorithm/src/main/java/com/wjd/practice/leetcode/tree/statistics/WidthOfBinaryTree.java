package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 626. 二叉树最大宽度
 * <p>
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * <p>
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在 32 位 带符号整数范围内。
 * <p>
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 *
 * @author weijiaduo
 * @since 2022/8/27
 */
public class WidthOfBinaryTree {

    /**
     * 思路：
     * <p>
     * 队列记录节点和节点在层级上的索引（从0开始），计算第一个节点和最后一个节点的距离差即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(w)
     * <p>
     * 执行耗时:1 ms,击败了99.78% 的Java用户
     * 内存消耗:40.9 MB,击败了72.70% 的Java用户
     *
     * @param root 根节点
     * @return 最大宽度
     */
    private int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long width = 0;
        Queue<Long> indexes = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        indexes.offer(0L);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long left = 0, right = -1;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                Long index = indexes.poll();
                if (node == null || index == null) {
                    continue;
                }
                if (i == 0) {
                    left = index;
                }
                if (i == size - 1) {
                    right = index;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    indexes.offer(index * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indexes.offer(index * 2 + 1);
                }
            }
            if (left <= right) {
                width = Math.max(width, right - left + 1);
            }
        }
        return (int) width;
    }

}
