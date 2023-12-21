package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 面试题 04.04. 检查平衡性
 * <p>
 * 实现一个函数，检查二叉树是否平衡。
 * <p>
 * 在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * 示例 1: 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * //    3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * <p>
 * 返回 true 。
 * <p>
 * 示例 2: 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * //       1
 * //      / \
 * //     2   2
 * //    / \
 * //   3   3
 * //  / \
 * //  4 4
 * <p>
 * 返回false 。
 *
 * @author weijiaduo
 * @since 2023/12/21
 */
public class IsBalanced {

    /**
     * 思路：递归，返回左右子树的高度，验证是否平衡
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.1 MB,击败了5.00% 的Java用户
     */
    @TestCase(input = {"[3,9,20,null,null,15,7]", "[1,2,2,3,3,null,null,4,4]"},
            output = {"true", "false"})
    public boolean isBalanced(TreeNode root) {
        return height(root) > -1;
    }

    /**
     * 平衡时，返回树的高度
     * <p>
     * 非平衡时，返回 -1
     *
     * @param root 当前节点
     * @return 树的高度/-1
     */
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        if (lh < 0) {
            return lh;
        }
        int rh = height(root.right);
        if (rh < 0) {
            return rh;
        }
        // 返回负数表示不平衡
        if (Math.abs(rh - lh) > 1) {
            return -1;
        }
        return 1 + Math.max(lh, rh);
    }

}
