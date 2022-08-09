package com.wjd.practice.leetcode.tree;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * <p>
 * @since 2022/6/16
 */
public class BuildTreeFromPreorderAndInorder implements Solution<TreeNode> {

    @Override
    public TreeNode solve(Object... args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode result = buildTree(preorder, inorder);
        System.out.println(TreeNode.bfs(result));
        return result;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 思路：递归构造二叉树
     *
     * 比想象中要慢啊
     *
     * 执行耗时:3 ms,击败了50.99% 的Java用户
     * 内存消耗:41.4 MB,击败了13.97% 的Java用户
     */
    public TreeNode build(int[] preorder, int f1, int t1, int[] inorder, int f2, int t2) {
        if (f1 >= t1 || f2 >= t2 || (t1 - f1 != t2 - f2)) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[f1]);
        int index = f2;
        while (inorder[index] != preorder[f1]) {
            index++;
        }
        int leftNum = index - f2;
        root.left = build(preorder, f1 + 1, f1 + 1 + leftNum, inorder, f2, index);
        root.right = build(preorder, f1 + 1 + leftNum, t1, inorder, index + 1, t2);
        return root;
    }

}
