package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
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

    /**
     * 思路：二分法，递归找到第一个大于指定值的节点
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:44.6 MB,击败了5.25% 的Java用户
     */
    @TestCase(input = {"[2,1,3]"},
            output = {"[2,1,3]"})
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        // 有右子树时，在最左节点
        TreeNode suc = null;
        if (p.right != null) {
            suc = p.right;
            while (suc.left != null) {
                suc = suc.left;
            }
            return suc;
        }

        // 无右子树，在父节点上面
        TreeNode q = root;
        while (q != null) {
            if (q.val > p.val) {
                suc = q;
                q = q.left;
            } else {
                q = q.right;
            }
        }
        return suc;
    }

}
