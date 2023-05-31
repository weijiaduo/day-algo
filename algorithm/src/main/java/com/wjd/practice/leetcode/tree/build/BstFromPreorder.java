package com.wjd.practice.leetcode.tree.build;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 1008. 前序遍历构造二叉搜索树
 * <p>
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 * <p>
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 * <p>
 * 二叉搜索树 是一棵二叉树，其中每个节点，
 * <p>
 * Node.left 的任何后代的值 严格小于 Node.val ,
 * <p>
 * Node.right 的任何后代的值 严格大于 Node.val。
 * <p>
 * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 * <p>
 * 输入：preorder = [8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 *
 * @author weijiaduo
 * @since 2022/12/17
 */
public class BstFromPreorder {

    /**
     * 思路：递归，根节点在第一个位置，后面分为左右子树，一直递归生成即可
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了27.39% 的Java用户
     *
     * @param preorder 前序遍历列表
     * @return 二叉搜索树根节点
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    /**
     * 深度遍历
     *
     * @param values 前序遍历列表
     * @param start  区间[start, end]
     * @param end    区间[start, end]
     * @return 区间根节点
     */
    private TreeNode dfs(int[] values, int start, int end) {
        if (end < start) {
            return null;
        }

        TreeNode root = new TreeNode(values[start]);
        int middle = end + 1;
        for (int i = start + 1; i <= end; i++) {
            if (values[i] > root.val) {
                middle = i;
                break;
            }
        }

        root.left = dfs(values, start + 1, middle - 1);
        root.right = dfs(values, middle, end);
        return root;
    }

}
