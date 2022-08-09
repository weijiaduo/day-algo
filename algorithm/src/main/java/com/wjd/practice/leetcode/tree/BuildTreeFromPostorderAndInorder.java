package com.wjd.practice.leetcode.tree;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * <p>
 * 请你构造并返回这颗 二叉树 。
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * <p>
 * @since 2022/6/16
 */
public class BuildTreeFromPostorderAndInorder implements Solution<TreeNode> {

    @Override
    public TreeNode solve(Object... args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode result = buildTree(inorder, postorder);
        System.out.println(TreeNode.bfs(result));
        return result;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length, inorder, 0, inorder.length);
    }

    /**
     * 思路：递归构造二叉树
     *
     * 比想象中要慢啊
     *
     * 执行耗时:3 ms,击败了59.03% 的Java用户
     * 内存消耗:41.4 MB,击败了14.21% 的Java用户
     */
    public TreeNode build(int[] postorder, int f1, int t1, int[] inorder, int f2, int t2) {
        if (f1 >= t1) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[t1 - 1]);
        int index = f2;
        while (inorder[index] != postorder[t1 - 1]) {
            index++;
        }
        int leftNum = index - f2;
        root.left = build(postorder, f1, f1 + leftNum, inorder, f2, index);
        root.right = build(postorder, f1 + leftNum, t1 - 1, inorder, index + 1, t2);
        return root;
    }

}
