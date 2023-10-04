package com.wjd.practice.leetcode.tree.path;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 543. 二叉树的直径
 * <p>
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 10⁴] 内
 * -100 <= Node.val <= 100
 *
 * @author weijiaduo
 * @since 2023/6/13
 */
public class DiameterOfBinaryTree {

    /**
     * 思路：递归，先拿到子树的最大高度和最长路径，然后判断根节点的高度和最长路径
     * <p>
     * 最长路径可能有 3 种情况：
     * <p>
     * 1. 左子树中
     * 2. 右子树中
     * 3. 左子树 + 根节点 + 右子树
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了5.10% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "[1,2]"},
            output = {"3", "1"})
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            // [最大高度, 最长路径]
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        // 根节点高度
        int h = Math.max(l[0], r[0]) + 1;
        // 当前树的最长路径
        int p = Math.max(l[0] + r[0], Math.max(l[1], r[1]));
        return new int[]{h, p};
    }

}
