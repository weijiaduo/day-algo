package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * <p>
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 *
 * @author weijiaduo
 * @since 2022/7/31
 */
public class MaxLevelSum implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        Integer[] values = {989, null, 10250, 98693, -89388, null, null, null, -32127};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.traverse(root));
        int result = maxLevelSum(root);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：层次遍历树，统计每层的和，并更新最大和的层数即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(w)
     * <p>
     * 执行耗时:8 ms,击败了78.17% 的Java用户
     * 内存消耗:43.9 MB,击败了88.95% 的Java用户
     *
     * @param root 根节点
     * @return 最大和层数
     */
    private int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxSum = root.val, maxLevel = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        for (int level = 1; !queue.isEmpty(); level++) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > maxSum) {
                maxLevel = level;
                maxSum = sum;
            }
        }
        return maxLevel;
    }

}
