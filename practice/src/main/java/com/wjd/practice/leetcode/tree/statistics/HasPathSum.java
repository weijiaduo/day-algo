package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 112. 路径总和
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * <p>
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * <p>
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @since 2022/6/19
 */
public class HasPathSum {

    /**
     * 思路：深度优先计算总和，到叶子节点的时候判断是否相等即可
     * <p>
     * 需要注意，叶子节点是左右子节点都为null，这个搞错了好几次~~~
     * <p>
     * 复杂度：时间 O(n) 空间 O(h)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.3 MB,击败了29.83% 的Java用户
     */
    @TestCase(input = {"[5,4,8,11,null,13,4,7,2,null,null,null,1]", "22",
            "[1,2,3]", "5"},
            output = {"true", "false"})
    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return dfs(root.left, targetSum - root.val)
                || dfs(root.right, targetSum - root.val);
    }

}
