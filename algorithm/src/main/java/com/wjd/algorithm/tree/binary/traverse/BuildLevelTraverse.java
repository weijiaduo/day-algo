package com.wjd.algorithm.tree.binary.traverse;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 构建层次遍历
 * <p>
 * 根据构建层次列表，可以构建出一棵唯一二叉树
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public class BuildLevelTraverse implements ListTraverse {

    @Override
    public List<TreeNode> traverse(TreeNode root) {
        ListVisitor visitor = new ListVisitor();
        bfs(root, visitor);
        return visitor.getList();
    }

    /**
     * 广度优先遍历
     *
     * @param root 根节点
     * @param visitor 访问者
     */
    private void bfs(TreeNode root, Visitor visitor) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int notNull = queue.size();
        while (notNull > 0) {
            TreeNode node = queue.poll();
            notNull--;
            visitor.visit(node);
            if (node == null) {
                continue;
            }

            queue.offer(node.left);
            if (node.left != null) {
                notNull = queue.size();
            }

            queue.offer(node.right);
            if (node.right != null) {
                notNull = queue.size();
            }
        }
    }

}
