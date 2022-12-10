package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 687. 最长同值路径
 * <p>
 * 给定一个二叉树的root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。
 * <p>
 * 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * <p>
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 *
 * @author weijiaduo
 * @since 2022/9/2
 */
public class LongestUnivaluePath implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        Integer[] values = {1, null, 1, 1, 1, 1, 1, 1};
        TreeNode root = TreeNode.build(values);
        int result = longestUnivaluePath(root);
        System.out.println(result);
        return result;
    }

    int maxPath;

    private int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    /**
     * 思路：深度优先遍历，经过根节点的最大路径长度 = 左子节点的路径长度 + 右子节点的路径长度
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了96.54% 的Java用户
     * 内存消耗:45.4 MB,击败了5.08% 的Java用户
     *
     * @param root 根节点
     * @return 经过根节点的最大路径长度
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 经过左子节点的路径长度
        int leftPath = dfs(root.left);
        if (root.left != null && root.left.val == root.val) {
            leftPath += 1;
        } else {
            leftPath = 0;
        }

        // 经过右子节点的路径长度
        int rightPath = dfs(root.right);
        if (root.right != null && root.right.val == root.val) {
            rightPath += 1;
        } else {
            rightPath = 0;
        }

        int path = leftPath + rightPath;
        maxPath = Math.max(path, maxPath);
        return Math.max(leftPath, rightPath);
    }

}
