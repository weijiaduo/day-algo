package com.wjd.practice.leetcode.tree.validate;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 110. 平衡二叉树
 * <p>
 * 定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 *
 * @since 2022/6/18
 */
public class IsBalancedTree {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /**
     * 思路：深度优先搜索整棵树，对比左右子树的高度，如果非平衡则返回-1，平衡则返回高度
     * <p>
     * 和官解一样，解释比我清楚，自顶向下会计算多次树的高度，而应该采用自底向上遍历
     * 虽然写代码时我也考虑到了这个多次计算的问题，但是解释出来又是一回事，可能我是潜意识的
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了66.73% 的Java用户
     */
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        if (left < 0) {
            return -1;
        }
        int right = height(root.right);
        if (right < 0 || Math.abs(right - left) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}
