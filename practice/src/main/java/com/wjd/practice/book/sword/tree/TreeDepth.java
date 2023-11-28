package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 55.1 二叉树的深度
 * <p>
 * 输入一棵二叉树，求该树的深度。
 * <p>
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class TreeDepth {

    /**
     * 思路：深度优先遍历，递归返回左右子树的最大深度
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     */
    @TestCase(input = {"[8,8,7,9,2,#,#,#,#,4,7]"}, output = {"4"})
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 递归返回左右子树的最大深度
        int ld = treeDepth(root.left);
        int rd = treeDepth(root.right);
        // 返回左右子树的最大深度 + 1
        return 1 + Math.max(ld, rd);
    }

}
