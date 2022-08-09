package com.wjd.practice.leetcode.tree;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * @since 2022/6/19
 */
public class PreorderTraversal implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object... args) {
        Integer[] values = {2,1,3,null,4};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        List<Integer> result = preorderTraversal(root);
        System.out.println(result);
        return result;
    }

    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return iterator(root);
    }

    /**
     * 思路：递归，递归确实简单
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了59.54% 的Java用户
     */
    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    /**
     * 思路：迭代法，使用栈保存根节点，用于后面访问右节点
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了39.34% 的Java用户
     */
    private List<Integer> iterator(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                // 访问根节点
                ans.add(node.val);
                stack.push(node);

                // 访问左节点
                node = node.left;
                continue;
            }
            // 回到上个根节点
            node = stack.pop();
            // 访问右节点
            node = node.right;
        }
        return ans;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了58.12% 的Java用户
     */
    private List<Integer> iterator2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 根节点
            TreeNode node = stack.pop();
            ans.add(node.val);
            // 右节点
            if (node.right != null) {
                stack.push(node.right);
            }
            // 左节点
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

}
