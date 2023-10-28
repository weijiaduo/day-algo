package com.wjd.practice.leetcode.tree.path;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * <p>
 * 同一个节点在一条路径序列中 至多出现一次 。
 * <p>
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 10⁴]
 * -1000 <= Node.val <= 1000
 *
 * @author weijiaduo
 * @since 2022/6/21
 */
public class MaxPathSum {

    /**
     * 思路：路径分为3种情况：1、路径经过根节点 2、路径只在左子树 3、路径只在右子树
     * <p>
     * 单纯的深度遍历，会重复计算很多次子节点的值，改为使用数组返回子节点的值，就可以复用子节点的值
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:1 ms,击败了23.03% 的Java用户
     * 内存消耗:42.9 MB,击败了58.30% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "[-10,9,20,null,null,15,7]"},
            output = {"6", "42"})
    public int dfs(TreeNode root) {
        int[] result = dfs0(root);
        return result[0] > 0 ? result[0] : result[2];
    }

    private int[] dfs0(TreeNode root) {
        // [0] 当前子树内所有路径的最大值
        // [1] 从当前节点出发的路径最大值
        // [2] 所有节点中的最大值
        int[] max = {0, 0, Integer.MIN_VALUE};
        if (root == null) {
            return max;
        }

        int[] l = dfs0(root.left);
        int[] r = dfs0(root.right);

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
     * <p>
     * 思路：也是分 3 种情况：1、路径经过根节点 2、路径只在左子树 3、路径只在右子树
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.8 MB,击败了61.73% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "[-10,9,20,null,null,15,7]"},
            output = {"6", "42"})
    public int maxGain(TreeNode root) {
        maxGain0(root);
        return maxSum;
    }

    private int maxGain0(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain0(node.left), 0);
        int rightGain = Math.max(maxGain0(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewPath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

}
