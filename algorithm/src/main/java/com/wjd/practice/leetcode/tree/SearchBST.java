package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。
 * <p>
 * 如果节点不存在，则返回 null 。
 * <p>
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 *
 * @author weijiaduo
 * @since 2022/12/14
 */
public class SearchBST {

    /**
     * 思路：迭代二叉搜索即可
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了12.87% 的Java用户
     *
     * @param root 根节点
     * @param val  指定值
     * @return val对应的节点/null
     */
    public TreeNode solve(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

}
