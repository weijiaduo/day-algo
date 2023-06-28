package com.wjd.practice.leetcode.tree.transform;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * <p>
 * 修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。
 * <p>
 * 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * <p>
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 *
 * @author weijiaduo
 * @since 2022/9/10
 */
public class TrimBST {

    /**
     * 思路：递归，分3种情况：根节点小于low；根节点大于high；根节点在[low, high]之内。递归判断这几种情况
     * <p>
     * 复杂度：时间 O(logn) 空间 log(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了55.11% 的Java用户
     *
     * @param root 根节点
     * @param low  [low, high]
     * @param high [low, high]
     * @return 新的根节点
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        // 1. 根节点小于low
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // 2. 根节点大于high
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // 3. 根节点在[low, high]之内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /**
     * 思路：迭代，把递归翻译成迭代
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了51.66% 的Java用户
     *
     * @param root 根节点
     * @param low  [low, high]
     * @param high [low, high]
     * @return 新的根节点
     */
    private TreeNode trimBST2(TreeNode root, int low, int high) {
        // 找到 [low, high] 内的根节点
        TreeNode newRoot = root;
        while (newRoot != null) {
            if (newRoot.val < low) {
                newRoot = newRoot.right;
            } else if (newRoot.val > high) {
                newRoot = newRoot.left;
            } else {
                break;
            }
        }

        if (newRoot == null) {
            return null;
        }

        // 修剪左子树
        TreeNode node = newRoot;
        while (node.left != null) {
            if (node.left.val < low) {
                // 当前左节点不满足要求，验证左节点的右节点
                node.left = node.left.right;
            } else {
                // 当前左节点满足要求，验证下一层左节点
                node = node.left;
            }
        }

        // 修剪右子树
        node = newRoot;
        while (node.right != null) {
            if (node.right.val > high) {
                // 当前右节点不满足要求，验证右节点的左节点
                node.right = node.right.left;
            } else {
                // 当前右节点满足要求，验证下一层右节点
                node = node.right;
            }
        }

        return newRoot;
    }

}
