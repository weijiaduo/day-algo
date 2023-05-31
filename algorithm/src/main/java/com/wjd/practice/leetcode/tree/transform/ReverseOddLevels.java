package com.wjd.practice.leetcode.tree.transform;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 6182. 反转二叉树的奇数层
 *
 * @author weijiaduo
 * @since 2022/9/18
 */
public class ReverseOddLevels {

    /**
     * 思路：层次遍历，奇数层时直接交换层次节点的值。
     * <p>
     * 如果题目要求不能改变节点值的话，可能会麻烦一些
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     *
     * @param root 根节点
     * @return 根节点
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = -1;
        while (!queue.isEmpty()) {
            level++;
            boolean isOdd = level % 2 != 0;
            int size = queue.size();
            TreeNode[] nodes = isOdd ? new TreeNode[size] : null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOdd) {
                    nodes[i] = node;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (nodes != null) {
                // 交换两边的数值，实现反转
                for (int i = 0; i < size / 2; i++) {
                    int temp = nodes[i].val;
                    nodes[i].val = nodes[size - 1 - i].val;
                    nodes[size - 1 - i].val = temp;
                }
            }
        }
        return root;
    }

}
