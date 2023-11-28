package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 55.2 平衡二叉树
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 如果某二叉树中任意结点的左右子树的深度相差不超过 1，那么它就是一棵平衡二叉树。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class IsBalancedTree {

    /**
     * 思路：后序遍历，先判断左右子树是否平衡，再判断左右子树的深度差是否超过 1
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     */
    @TestCase(input = {"[8,8,7,9,2,#,#,#,#,4,7]", "[8,8,7,9,2]"},
            output = {"false", "true"})
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return depth(root) != -1;
    }

    /**
     * 返回树的深度
     * <p>
     * 当树不平衡时，返回 -1
     *
     * @param root 根节点
     * @return 树的深度
     */
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 计算左右子树的深度，并检查是否平衡
        int lh = depth(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = depth(root.right);
        if (rh == -1) {
            return -1;
        }

        // 判断是否平衡，不平衡时返回 -1
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        // 返回当前树的深度
        return 1 + Math.max(lh, rh);
    }

}
