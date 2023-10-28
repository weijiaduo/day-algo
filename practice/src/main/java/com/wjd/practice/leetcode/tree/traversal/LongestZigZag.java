package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 1372. 二叉树中的最长交错路径
 * <p>
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * <p>
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * <p>
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * <p>
 * 改变前进方向：左变右或者右变左。
 * <p>
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * <p>
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * <p>
 * 请你返回给定树中最长 交错路径 的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 50000 个节点。
 * 每个节点的值在 [1, 100] 之间。
 *
 * @author weijiaduo
 * @since 2023/10/11
 */
public class LongestZigZag {

    /**
     * 最长交错路径
     */
    private int ans;

    /**
     * 思路：递归，从下往上返回最长交错路径
     * <p>
     * 返回的交错路径分为，左边交错路径和右边交错路径
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:6 ms,击败了80.51% 的Java用户
     * 内存消耗:54.8 MB,击败了13.15% 的Java用户
     */
    @TestCase(input = {"[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]",
            "[1,1,1,null,1,null,null,1,1,null,1]",
            "[1]"},
            output = {"3", "4", "0"})
    public int longestZigZag(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    /**
     * 深度优先遍历，返回以当前节点为起点的左右交错路径长度
     *
     * @param root 当前节点
     * @return 以当前节点为起点的左右交错路径长度
     */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            // [左交错路径长度, 右交错路径长度]
            return new int[]{-1, -1};
        }
        int lz = dfs(root.left)[1] + 1;
        int rz = dfs(root.right)[0] + 1;
        ans = Math.max(Math.max(lz, rz), ans);
        return new int[]{lz, rz,};
    }

}
