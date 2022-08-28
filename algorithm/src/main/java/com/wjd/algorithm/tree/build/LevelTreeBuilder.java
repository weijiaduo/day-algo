package com.wjd.algorithm.tree.build;

import com.wjd.structure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 层序遍历构建树
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public class LevelTreeBuilder implements TreeBuilder<Integer[]> {

    @Override
    public TreeNode build(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        int n = values.length, i = 0;
        TreeNode root = new TreeNode(values[i++]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (i < n) {
                Integer leftVal = values[i++];
                if (leftVal != null) {
                    parent.left = new TreeNode(leftVal);
                    queue.offer(parent.left);
                }
            }
            if (i < n) {
                Integer rightVal = values[i++];
                if (rightVal != null) {
                    parent.right = new TreeNode(rightVal);
                    queue.offer(parent.right);
                }
            }
        }
        return root;
    }

}
