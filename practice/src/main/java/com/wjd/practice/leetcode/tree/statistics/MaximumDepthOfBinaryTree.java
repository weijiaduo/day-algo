package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,null,2]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [0, 10⁴] 区间内。
 * -100 <= Node.val <= 100
 *
 * @since 2022-06-13
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 思路：深度优先，取左右子树的最大高度返回
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了62.74% 的Java用户
     */
    @TestCase(input = {"[3,9,20,null,null,15,7]", "[1,null,2]"},
            output = {"3", "2"})
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);
        return 1 + (Math.max(ld, rd));
    }

}
