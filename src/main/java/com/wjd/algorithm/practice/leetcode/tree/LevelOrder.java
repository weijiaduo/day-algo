package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.TreeNode;
import com.wjd.algorithm.practice.leetcode.structure.TreeNode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * @since 2020-06-13
 */
public class LevelOrder implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        Integer[] values = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
        return result;
    }

    /**
     * 执行耗时:1 ms,击败了59.03% 的Java用户
     * 内存消耗:41.7 MB,击败了9.30% 的Java用户
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = queue.size();
        List<Integer> level = new ArrayList<>(count);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count--;
            level.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (count == 0) {
                list.add(level);
                count = queue.size();
                level = new ArrayList<>(count);
            }
        }

        return list;
    }

}
