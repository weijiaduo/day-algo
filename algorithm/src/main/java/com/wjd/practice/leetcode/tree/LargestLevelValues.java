package com.wjd.practice.leetcode.tree;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * <p>
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * <p>
 * 输出: [1,3,9]
 *
 * @author weijiaduo
 * @since 2022/6/24
 */
public class LargestLevelValues implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object... args) {
        Integer[] values = {1, 2, 3};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        List<Integer> result = largestValues(root);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接按层遍历就可以
     * <p>
     * 执行耗时:2 ms,击败了88.47% 的Java用户
     * 内存消耗:41.4 MB,击败了65.44% 的Java用户
     */
    private List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }

}
