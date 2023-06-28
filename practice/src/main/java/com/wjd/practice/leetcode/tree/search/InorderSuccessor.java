package com.wjd.practice.leetcode.tree.search;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 面试题04.06 后继者
 * <p>
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 *
 * @since 2022/5/16
 */
public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        TreeNode successor = null;
        TreeNode q = root;
        while (q != null) {
            if (q.val > p.val) {
                successor = q;
                q = q.left;
            } else {
                q = q.right;
            }
        }
        return successor;
    }

}
