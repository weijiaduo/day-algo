package com.wjd.practice.leetcode.tree.build;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，
 * <p>
 * 请构造二叉树并返回其根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * <p>
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 * @since 2022/6/16
 */
public class BuildTreeFromPreorderAndInorder {

    /**
     * 思路：分治法，递归构造二叉树
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了50.99% 的Java用户
     * 内存消耗:41.4 MB,击败了13.97% 的Java用户
     * <p>
     * 比想象中要慢啊
     */
    @TestCase(input = {"[3,9,20,15,7]", "[9,3,15,20,7]", "[-1]", "[-1]"},
            output = {"[3,9,20,null,null,15,7]", "[-1]"})
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int f1, int t1, int[] inorder, int f2, int t2) {
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
