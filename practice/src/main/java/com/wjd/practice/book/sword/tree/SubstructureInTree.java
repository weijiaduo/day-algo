package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 26. 树的子结构
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * <p>
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 * @author weijiaduo
 * @since 2023/11/25
 */
public class SubstructureInTree {

    /**
     * 思路：递归
     * <p>
     * 对于 2 棵树的比较，分为 2 种情况：
     * <p>
     * 1. 匹配当前节点，且根节点相同，递归比较子树
     * 2. 不匹配当前节点，往下递归
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"[8,8,7,9,2,#,#,#,#,4,7]", "[8,9,2]"},
            output = {"true"})
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        boolean flag = false;
        // 尝试匹配当前节点
        if (root1.val == root2.val) {
            flag = contains(root1, root2);
        }
        // 如果当前节点不匹配，往左右子树递归匹配
        flag = flag || (hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2));
        return flag;
    }

    /**
     * 递归判断两棵树是否是包含关系
     *
     * @param root1 根节点
     * @param root2 被包含树的根节点
     * @return 是否包含
     */
    private boolean contains(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            return (contains(root1.left, root2.left) && contains(root1.right, root2.right));
        }
        return false;
    }

}
