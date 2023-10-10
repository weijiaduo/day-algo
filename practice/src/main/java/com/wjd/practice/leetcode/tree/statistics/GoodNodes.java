package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * <p>
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * <p>
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * 解释：根节点是好节点。
 * <p>
 * 提示：
 * <p>
 * 二叉树中节点数目范围是 [1, 10^5] 。
 * 每个节点权值的范围是 [-10^4, 10^4] 。
 *
 * @author weijiaduo
 * @since 2023/10/10
 */
public class GoodNodes {

    /**
     * 思路：深度优先遍历，记录路径最大值
     * <p>
     * 取 max(当前值，最大值) 作为新的最大值递归遍历
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:48.8 MB,击败了94.12% 的Java用户
     */
    @TestCase(input = {"[3,1,4,3,null,1,5]", "[3,3,null,4,2]", "[1]"},
            output = {"4", "3", "1"})
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    /**
     * 深度优先搜索，统计好节点数量
     *
     * @param root 当前节点
     * @param max  当前路径上的最大值
     * @return 好节点数量
     */
    private int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int delta = root.val >= max ? 1 : 0;
        max = Math.max(root.val, max);
        return delta + dfs(root.left, max) + dfs(root.right, max);
    }

}
