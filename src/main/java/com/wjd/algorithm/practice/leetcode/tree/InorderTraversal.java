package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * @since 2022/6/11
 */
public class InorderTraversal implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object... args) {
        Integer[] values = {1,null,2,3};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // dfs(root, ans);
        ans = iterator(root);
        return ans;
    }

    /**
     * 递归法
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了10.36% 的Java用户
     */
    private void dfs(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        dfs(node.left, ans);
        ans.add(node.val);
        dfs(node.right, ans);
    }

    /**
     * 迭代法
     *
     * 思路：使用栈保存根节点，优先遍历左子树
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了5.13% 的Java用户
     */
    private List<Integer> iterator(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                // 保存当前节点
                stack.push(node);
                // 优先遍历左子树
                node = node.left;
                continue;
            }

            // 遍历根节点
            node = stack.pop();
            ans.add(node.val);

            // 最后遍历右子树
            node = node.right;
        }
        return ans;
    }

}
