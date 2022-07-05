package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173. 二叉搜索树迭代器
 * <p>
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器
 * <p>
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 *
 * @author weijiaduo
 * @since 2022/7/5
 */
public class BSTIterator implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        Integer[] values = {7, 3, 15, null, null, 9, 20};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));

        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        return null;
    }

    Deque<TreeNode> stack;

    /**
     * 思路：使用栈保存未访问的根节点，访问后将其右子树加入栈中
     * <p>
     * 复杂度：时间O(1) 空间O(h)
     * <p>
     * 执行耗时:16 ms,击败了93.54% 的Java用户
     * 内存消耗:45.1 MB,击败了57.16% 的Java用户
     */
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        findNodes(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        findNodes(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void findNodes(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

}
