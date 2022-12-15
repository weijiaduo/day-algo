package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * <p>
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * @author weijiaduo
 * @since 2022/12/16
 */
public class LowestCommonAncestor {

    /**
     * 思路：从上往下，判断两个值是否是位于不同子树，是则表明是最近的公共节点
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:5 ms,击败了99.95% 的Java用户
     * 内存消耗:42.1 MB,击败了83.25% 的Java用户
     *
     * @param root 根节点
     * @param p    指定值1
     * @param q    指定值2
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 2 个值分别在节点的不同子树中（或者有一个值是另一个值的祖先）
        if (p.val <= root.val && root.val <= q.val
                || q.val <= root.val && root.val <= p.val) {
            return root;
        }
        if (root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

}
