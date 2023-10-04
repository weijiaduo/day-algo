package com.wjd.practice.leetcode.tree.transform;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 226. 翻转二叉树
 * <p>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author weijiaduo
 * @since 2022/12/4
 */
public class InvertTree {

    /**
     * 思路：递归，反转左右子树
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.9 MB,击败了73.63% 的Java用户
     */
    @TestCase(input = {"[4,2,7,1,3,6,9]", "[2,1,3]", "[]"},
            output = {"[4,7,2,9,6,3,1]", "[2,3,1]", "[]"})
    public TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invert(root.right);
        root.right = invert(left);
        return root;
    }

}
