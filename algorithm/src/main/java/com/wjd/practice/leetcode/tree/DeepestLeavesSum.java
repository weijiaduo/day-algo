package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * <p>
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 * @author weijiaduo
 * @since 2022/8/17
 */
public class DeepestLeavesSum implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        Integer[] values = {6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        int result = deepestLeavesSum(root);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：层次优先遍历，计算每层的和，最后一层的和就是结果
     * <p>
     * 复杂度：时间 O(n) 空间 O(w)
     * <p>
     * 执行耗时:6 ms,击败了53.73% 的Java用户
     * 内存消耗:43.8 MB,击败了54.12% 的Java用户
     *
     * @param root 根节点
     * @return 最深层次叶子节点之和
     */
    private int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }

}
