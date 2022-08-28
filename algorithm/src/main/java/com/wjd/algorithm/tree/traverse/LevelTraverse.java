package com.wjd.algorithm.tree.traverse;

import com.wjd.structure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历（不包括层级中间的 null 节点）
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public class LevelTraverse implements Traverse {

    @Override
    public List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        bfs(root, list);
        return list;
    }

    /**
     * 广度优先遍历
     *
     * @param root 根节点
     * @param list 节点列表
     */
    private void bfs(TreeNode root, List<TreeNode> list) {
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
                list.add(node);
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
