package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 7. 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * <p>
 * 则重建二叉树并返回。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class ReconstructBinaryTree {

    /**
     * 思路：前序遍历的第一个数字是根节点的值，在中序遍历中找到该值，左边是左子树，右边是右子树
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     *
     * @param pre 前序遍历
     * @param in  中序遍历
     * @return 二叉树根节点
     */
    @TestCase(input = {"[1,2,4,7,3,5,6,8]", "[4,7,2,1,5,3,8,6]"},
            output = "[1,2,3,4,null,5,6,null,7,null,null,8]")
    public TreeNode reconstruct(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return build(pre, 0, in, 0, pre.length);
    }

    /**
     * 基于前序遍历和中序遍历构建二叉树
     *
     * @param pre    前序遍历
     * @param ps     前序遍历开始位置
     * @param in     中序遍历
     * @param is     中序遍历开始位置
     * @param length 长度
     * @return 二叉树根节点
     */
    private TreeNode build(int[] pre, int ps, int[] in, int is, int length) {
        if (length <= 0) {
            return null;
        }

        // 前序遍历的第一个数字是根节点的值
        TreeNode root = new TreeNode(pre[ps]);

        // 找到根节点在中序遍历中的位置
        int inRoot = is;
        while (inRoot < in.length && in[inRoot] != pre[ps]) {
            inRoot++;
        }

        // 左子树和右子树长度
        int leftLength = inRoot - is;
        int rightLength = length - leftLength - 1;
        // 递归构建左子树和右子树
        root.left = build(pre, ps + 1, in, is, leftLength);
        root.right = build(pre, ps + 1 + leftLength, in, inRoot + 1, rightLength);
        return root;
    }

}
