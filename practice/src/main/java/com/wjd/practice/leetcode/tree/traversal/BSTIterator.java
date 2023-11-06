package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173. 二叉搜索树迭代器
 * <p>
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * <p>
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。
 * <p>
 * BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * <p>
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * <p>
 * int next()将指针向右移动，然后返回指针处的数字。
 * <p>
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next",
 * "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next(); // 返回 3
 * bSTIterator.next(); // 返回 7
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next(); // 返回 9
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next(); // 返回 15
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next(); // 返回 20
 * bSTIterator.hasNext(); // 返回 False
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 10⁵] 内
 * 0 <= Node.val <= 10⁶
 * 最多调用 10⁵ 次 hasNext 和 next 操作
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高
 * 度。
 *
 * @author weijiaduo
 * @since 2022/7/5
 */
public class BSTIterator {

    @TestCase(input = {"[7, 3, 15, null, null, 9, 20]"},
            output = {})
    public void test(TreeNode root) {
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
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

    public BSTIterator() {
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
