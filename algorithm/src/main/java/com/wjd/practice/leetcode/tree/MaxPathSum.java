package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * <p>
 * 同一个节点在一条路径序列中 至多出现一次 。
 * <p>
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * @author weijiaduo
 * @since 2022/6/21
 */
public class MaxPathSum implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        Integer[] values = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.traverse(root));
        int result = maxPathSum(root);
        System.out.println(result);
        return result;
    }

    private int maxPathSum(TreeNode root) {
        int[] result = dfs2(root);
        return result[0] > 0 ? result[0] : result[2];
    }

    /**
     * 思路：路径分为3种情况：1、路径经过根节点 2、路径只在左子树 3、路径只在右子树
     *
     * 单纯的深度遍历，会重复计算很多次子节点的值，改为使用数组返回子节点的值，就可以复用子节点的值
     *
     * 执行耗时:1 ms,击败了23.03% 的Java用户
     * 内存消耗:42.9 MB,击败了58.30% 的Java用户
     */
    private int[] dfs2(TreeNode root) {
        int[] max = { 0, 0, Integer.MIN_VALUE };
        if (root == null) {
            return max;
        }

        int[] l = dfs2(root.left);
        int[] r = dfs2(root.right);

        // 1、最大值路径经过根节点
        // 2、最大值路径在左子树
        // 3、最大值路径在右子树
        int sum = root.val + Math.max(0, l[1]) + Math.max(0, r[1]);
        max[0] = Math.max(Math.max(l[0], r[0]), sum);
        // 以此根节点为起点的路径最大值
        max[1] = root.val + Math.max(0, Math.max(l[1], r[1]));
        // 维护一个最大值，避免全部是负数的情况
        max[2] = Math.max(root.val, Math.max(l[2], r[2]));
        return max;
    }

    int maxSum = Integer.MIN_VALUE;

    /**
     * 官解还是简洁呀，我感觉我被误导了
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.8 MB,击败了61.73% 的Java用户
     */
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

}
