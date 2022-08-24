package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * @since 2022-06-13
 */
public class MaximumDepthOfBinaryTree implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        Integer[] values = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        int result = maxDepth(root);
        System.out.println(result);
        return result;
    }

    /**
     * 深度优先
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了62.74% 的Java用户
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);
        return 1 + (Math.max(ld, rd));
    }
}
