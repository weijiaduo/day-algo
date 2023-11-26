package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 32.3 按之字形顺序打印二叉树
 * <p>
 * 请实现一个函数按照之字形打印二叉树，
 * <p>
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * <p>
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class PrintTreeInZigzag {

    /**
     * 思路：利用两个栈，一个从左往右，一个从右往左
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"[8,6,10,5,7,9,11]"},
            output = "[[8], [10, 6], [5, 7, 9, 11]]")
    public List<List<Integer>> print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 从左往右
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        // 从右往左
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        leftStack.offer(root);
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            List<Integer> levels;
            if (!leftStack.isEmpty()) {
                // 从左往右遍历
                levels = new ArrayList<>(leftStack.size());
                while (!leftStack.isEmpty()) {
                    TreeNode cur = leftStack.poll();
                    levels.add(cur.val);
                    if (cur.left != null) {
                        rightStack.push(cur.left);
                    }
                    if (cur.right != null) {
                        rightStack.push(cur.right);
                    }
                }
            } else {
                // 从右往左遍历
                levels = new ArrayList<>(rightStack.size());
                while (!rightStack.isEmpty()) {
                    TreeNode cur = rightStack.poll();
                    levels.add(cur.val);
                    if (cur.right != null) {
                        leftStack.push(cur.right);
                    }
                    if (cur.left != null) {
                        leftStack.push(cur.left);
                    }
                }
            }
            res.add(levels);
        }
        return res;
    }

}
