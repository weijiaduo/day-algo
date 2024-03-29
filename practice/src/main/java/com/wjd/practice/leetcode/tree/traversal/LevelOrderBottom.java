package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.*;

/**
 * 107. 二叉树的层序遍历2
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * <p>
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 * <p>
 *
 * @since 2022/6/17
 */
public class LevelOrderBottom {

    /**
     * 思路；按照普通的层次遍历，只是结果反过来放而已
     * <p>
     * 执行耗时:1 ms,击败了91.57% 的Java用户
     * 内存消耗:41.6 MB,击败了25.39% 的Java用户
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> level = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            deque.addFirst(level);
        }
        return new ArrayList<>(deque);
    }

}
