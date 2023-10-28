package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @since 2022/6/11
 */
public class InorderTraversal {

    /**
     * 思路：深度优先遍历，先左再中后右
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了10.36% 的Java用户
     */
    @TestCase(input = {"[1,null,2,3]", "[]", "[1]"},
            output = {"[1,3,2]", "[]", "[1]"})
    public List<Integer> dfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        dfs(node.left, ans);
        ans.add(node.val);
        dfs(node.right, ans);
    }

    /**
     * 思路：迭代法，使用栈保存根节点，优先遍历左子树
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了5.13% 的Java用户
     */
    @TestCase(input = {"[1,null,2,3]", "[]", "[1]"},
            output = {"[1,3,2]", "[]", "[1]"})
    public List<Integer> iterator(TreeNode root) {
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
