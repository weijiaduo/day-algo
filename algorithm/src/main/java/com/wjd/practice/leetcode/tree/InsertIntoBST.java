package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * <p>
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * <p>
 * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
 * <p>
 * 你可以返回 任意有效的结果 。
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 *
 * @author weijiaduo
 * @since 2022/12/15
 */
public class InsertIntoBST {

    /**
     * 思路：迭代 + 二分，找到合适的位置
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.6 MB,击败了5.06% 的Java用户
     *
     * @param root 根节点
     * @param val  指定值
     * @return 根节点
     */
    public TreeNode solve(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        // 已存在相同值时不插入
        TreeNode node = root;
        while (node.val != val) {
            if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }

}
