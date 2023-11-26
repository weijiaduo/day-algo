package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 28. 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * <p>
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class SymmetricalTree {

    /**
     * 思路：递归判断二叉树的左右子树是否对称
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     */
    @TestCase(input = {"[8,6,6,5,7,7,5]", "[8,6,9,5,7,7,5]"},
            output = {"true", "false"})
    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        // 判断左右子树是否对称
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }

}
