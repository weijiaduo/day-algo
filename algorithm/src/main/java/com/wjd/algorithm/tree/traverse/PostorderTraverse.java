package com.wjd.algorithm.tree.traverse;

import com.wjd.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 后序遍历
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public class PostorderTraverse implements Traverse {

    /**
     * 遍历实现类型：
     * 1：递归
     * 2：迭代
     * 3：标记
     */
    private int type = 1;

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (type == 3) {
            mark(root, list);
        } else if (type == 2) {
            iterate(root, list);
        } else {
            recursive(root, list);
        }
        return list;
    }

    /**
     * 递归实现
     *
     * @param root 根节点
     * @param list 节点列表
     */
    private void recursive(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        recursive(root.left, list);
        recursive(root.right, list);
        list.add(root);
    }

    /**
     * 迭代实现，递归改成迭代
     *
     * @param root 根节点
     * @param list 节点列表
     */
    private void iterate(TreeNode root, List<TreeNode> list) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root, prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                // 左子节点
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right != null && cur.right != prev) {
                // 右子节点
                stack.push(cur);
                cur = cur.right;
            } else {
                // 根节点
                list.add(cur);
                prev = cur;
                cur = null;
            }
        }
    }

    /**
     * 标记实现，标记访问过的节点
     *
     * @param root 根节点
     * @param list 节点列表
     */
    private void mark(TreeNode root, List<TreeNode> list) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Boolean> marks = new LinkedList<>();
        stack.push(root);
        marks.push(false);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Boolean mark = marks.pop();
            if (node == null || mark == null) {
                continue;
            }
            if (mark) {
                list.add(node);
            } else {
                // 倒序添加
                // 根节点
                stack.push(node);
                marks.push(true);
                // 右子节点
                stack.push(node.right);
                marks.push(false);
                // 左子节点
                stack.push(node.left);
                marks.push(false);
            }
        }
    }

}
