package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * <p>
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * <p>
 *
 * @since 2022/6/19
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        // return dfs(root, new ArrayList<>());
        return iterator(root);
    }

    /**
     * 思路：递归确实简单
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了44.20% 的Java用户
     */
    private List<Integer> dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ans;
        }
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
        return ans;
    }

    /**
     * 迭代法
     * <p>
     * 这个没写出来啊
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40 MB,击败了5.00% 的Java用户
     */
    private List<Integer> iterator(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root, prev = null;
        while (!stack.isEmpty() || node != null) {
            // 左节点
            if (node != null) {
                stack.push(node);
                node = node.left;
                continue;
            }

            node = stack.pop();
            // 右节点
            if (node.right != prev && node.right != null) {
                stack.push(node);
                node = node.right;
                continue;
            }

            // 根节点
            ans.add(node.val);
            prev = node;
            node = null;
        }

        return ans;
    }

}
