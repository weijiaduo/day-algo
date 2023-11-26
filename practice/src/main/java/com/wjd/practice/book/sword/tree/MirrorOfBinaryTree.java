package com.wjd.practice.book.sword.tree;


import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 27. 二叉树的镜像
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 二叉树的镜像定义：源二叉树
 * <p>
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * <p>
 * 镜像二叉树
 * <p>
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class MirrorOfBinaryTree {

    /**
     * 思路：递归交换二叉树的左右子树
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     */
    @TestCase(input = {"[7, 8, 9]"},
            output = {"[7, 9, 8]"})
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归交换子树
        mirror(root.left);
        mirror(root.right);
    }

}
