package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Z字形打印树
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * <p>
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * <p>
 *
 * @since 2022-06-13
 */
public class ZigzagLevelOrder {

    /**
     * 双栈遍历
     * <p>
     * 思路：父子节点分别放2个栈中，交替遍历父子栈
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了59.45% 的Java用户
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> leftStack = new LinkedList<>();
        Deque<TreeNode> rightStack = new LinkedList<>();
        leftStack.offer(root);
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            if (!leftStack.isEmpty()) {
                // 从左至右
                int count = leftStack.size();
                List<Integer> level = new ArrayList<>(count);
                for (int i = 0; i < count; i++) {
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
                int count = rightStack.size();
                List<Integer> level = new ArrayList<>(count);
                for (int i = 0; i < count; i++) {
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
     * 双向队列
     * <p>
     * 思路：把2个栈用一个双向队列替换，效果一样
     * <p>
     * 执行耗时:1 ms,击败了71.84% 的Java用户
     * 内存消耗:40.2 MB,击败了49.06% 的Java用户
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftLevel = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (leftLevel) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(new LinkedList<>(level));
            leftLevel = !leftLevel;
        }

        return list;
    }

}
