package com.wjd.algorithm.tree.binary.traverse;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public class PreorderTraverse implements ListTraverse {

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
        ListVisitor visitor = new ListVisitor();
        if (type == 3) {
            mark(root, visitor);
        } else if (type == 2) {
            iterate(root, visitor);
        } else {
            recursive(root, visitor);
        }
        return visitor.getList();
    }

    /**
     * 递归实现
     *
     * @param root 根节点
     * @param visitor 访问者
     */
    private void recursive(TreeNode root, Visitor visitor) {
        if (root == null) {
            return;
        }

        visitor.visit(root);
        recursive(root.left, visitor);
        recursive(root.right, visitor);
    }

    /**
     * 迭代实现，递归改成迭代
     *
     * @param root 根节点
     * @param visitor 访问者
     */
    private void iterate(TreeNode root, Visitor visitor) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 根节点
                visitor.visit(cur);
                // 保存现场 nextPC
                stack.push(cur);
                // 左节点
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 右节点
                cur = cur.right;
            }
        }
    }

    /**
     * 标记实现，标记访问过的节点
     *
     * @param root 根节点
     * @param visitor 访问者
     */
    private void mark(TreeNode root, Visitor visitor) {
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
                visitor.visit(node);
            } else {
                // 倒序添加
                // 右子节点
                stack.push(node.right);
                marks.push(false);
                // 左子节点
                stack.push(node.left);
                marks.push(false);
                // 根节点
                stack.push(node);
                marks.push(true);
            }
        }
    }

}
