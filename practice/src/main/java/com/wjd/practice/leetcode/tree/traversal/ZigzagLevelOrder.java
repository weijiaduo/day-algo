package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 103. Z字形打印树
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 * @since 2022-06-13
 */
public class ZigzagLevelOrder {

    /**
     * 思路：双栈遍历，父子节点分别放2个栈中，交替遍历父子栈
     * <p>
     * 复杂度：时间 O(n) 空间 O(w)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了59.45% 的Java用户
     */
    @TestCase(input = {"[3,9,20,null,null,15,7]", "[1]"},
            output = {"[[3],[20,9],[15,7]]", "[[1]]"})
    public List<List<Integer>> doubleStack(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        leftStack.offer(root);
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            if (!leftStack.isEmpty()) {
                // 从左至右
                int size = leftStack.size();
                List<Integer> level = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode node = leftStack.pop();
                    level.add(node.val);
                    if (node.left != null) {
                        rightStack.push(node.left);
                    }
                    if (node.right != null) {
                        rightStack.push(node.right);
                    }
                }
                list.add(level);
            } else {
                // 从右至左
                int size = rightStack.size();
                List<Integer> level = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode node = rightStack.pop();
                    level.add(node.val);
                    if (node.right != null) {
                        leftStack.push(node.right);
                    }
                    if (node.left != null) {
                        leftStack.push(node.left);
                    }
                }
                list.add(level);
            }
        }
        return list;
    }

    /**
     * 思路：双向队列，把2个栈用一个双向队列替换，效果一样
     * <p>
     * 复杂度：时间 O(n) 空间 O(w)
     * <p>
     * 执行耗时:1 ms,击败了73.46% 的Java用户
     * 内存消耗:39.7 MB,击败了98.68% 的Java用户
     */
    @TestCase(input = {"[3,9,20,null,null,15,7]", "[1]"},
            output = {"[[3],[20,9],[15,7]]", "[[1]]"})
    public List<List<Integer>> deque(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftStart = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (leftStart) {
                    // 从左往右
                    node = queue.pollFirst();
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    // 从右往左
                    node = queue.pollLast();
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
                level.add(node.val);
            }
            list.add(level);
            leftStart = !leftStart;
        }
        return list;
    }

}
