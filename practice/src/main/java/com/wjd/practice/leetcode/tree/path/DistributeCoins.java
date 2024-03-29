package com.wjd.practice.leetcode.tree.path;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 979. 在二叉树中分配硬币
 * <p>
 * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
 * <p>
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
 * <p>
 * (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 * <p>
 * 返回使每个结点上只有一枚硬币所需的移动次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,0,0]
 * 输出：2
 * 解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[0,3,0]
 * 输出：3
 * 解释：从根结点的左子结点开始，我们将两枚硬币移到根结点上 [移动两次]。然后，我们把一枚硬币从根结点移到右子结点上。
 * <p>
 * 示例 3：
 * <p>
 * 输入：[1,0,2]
 * 输出：2
 * <p>
 * 示例 4：
 * <p>
 * 输入：[1,0,0,null,3]
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * 1<= N <= 100
 * 0 <= node.val <= N
 *
 * @author weijiaduo
 * @since 2023/7/14
 */
public class DistributeCoins {

    /**
     * 官方题解
     * <p>
     * 思路：定义 dfs(root) 为子节点移交给父节点的金币移动次数
     * <p>
     * 则 dfs(root) = dfs(left) + dfs(right) + root.val - 1
     * <p>
     * 其中，dfs(left) + dfs(right) + root.val 是 root 给子节点分配金币后的剩余金币数量
     * <p>
     * -1 是因为 root 只需要保留 1 个金币，剩余的都移交给 root 的父节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了55.17% 的Java用户
     */
    @TestCase(input = {"[3,0,0]", "[0,3,0]", "[1,0,2]", "[1,0,0,null,3]"},
            output = {"2", "3", "2", "4"})
    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    /**
     * 总的移动步数
     */
    int moves = 0;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMove = 0;
        if (root.left != null) {
            leftMove = dfs(root.left);
        }
        int rightMove = 0;
        if (root.right != null) {
            rightMove = dfs(root.right);
        }
        moves += Math.abs(leftMove) + Math.abs(rightMove);
        return leftMove + rightMove + root.val - 1;
    }

}
