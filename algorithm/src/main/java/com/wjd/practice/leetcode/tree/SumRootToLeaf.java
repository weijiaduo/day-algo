package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

/**
 * 1022. 从根到叶的二进制之和
 * <p>
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * <p>
 * @since 2022/5/30
 */
public class SumRootToLeaf implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        Integer[] values = {0};
        TreeNode root = TreeNode.build(values);
        int result = sumRootToLeaf(root);
        System.out.println(result);
        return result;
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 思路：只是0和1，那直接用位操作就行了，深度遍历，到叶子节点就返回值
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了69.54% 的Java用户
     */
    private int dfs(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }

        // 叶子节点
        int value = (num << 1) | node.val;
        if (node.left == null && node.right == null) {
            return value;
        }

        // 非叶子节点
        int sum = 0;
        if (node.left != null) {
            sum += dfs(node.left, value);
        }
        if (node.right != null) {
            sum += dfs(node.right, value);
        }
        return sum;
    }

}
