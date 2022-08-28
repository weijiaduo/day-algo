package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.TreeNode;

/**
 * 112. 路径总和
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * <p>
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * <p>
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * <p>
 * @since 2022/6/19
 */
public class HasPathSum implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        Integer[] values = {1,2,3};
        int targetSum = 5;
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.traverse(root));
        boolean result = hasPathSum(root, targetSum);
        System.out.println(result);
        return result;
    }

    private boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    /**
     * 思路：深度优先计算总和，到叶子节点的时候判断是否相等即可
     *
     * 需要注意，叶子节点是左右子节点都为null，这个搞错了好几次~~~
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了62.76% 的Java用户
     */
    private boolean dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == sum + root.val;
        }
        return dfs(root.left, targetSum, root.val + sum) ||
                dfs(root.right, targetSum, root.val + sum);
    }

}
