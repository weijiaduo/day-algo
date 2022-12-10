package com.wjd.algorithm.tree.binary.traverse;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历（不包括层级中间的 null 节点）
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public class SimpleLevelTraverse implements ListTraverse {

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
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                visitor.visit(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

}
