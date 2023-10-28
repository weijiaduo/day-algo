package com.wjd.practice.leetcode.tree.path;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,1000]
 * <p>
 * -10⁹ <= Node.val <= 10⁹
 * -1000 <= targetSum <= 1000
 *
 * @author weijiaduo
 * @since 2023/6/13
 */
public class PathSum3 {

    /**
     * 思路：递归，以每个节点为起始节点，往下遍历所有子节点，寻找目标值
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(logn)
     * <p>
     * 执行耗时:31 ms,击败了40.23% 的Java用户
     * 内存消耗:41.9 MB,击败了53.66% 的Java用户
     */
    @TestCase(input = {"[10,5,-3,3,2,null,11,3,-2,null,1]", "8",
            "[5,4,8,11,null,13,4,7,2,null,null,5,1]", "22"},
            output = {"3", "3"})
    public int dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        cnt += rootSum(root, targetSum);
        cnt += dfs(root.left, targetSum);
        cnt += dfs(root.right, targetSum);
        return cnt;
    }

    /**
     * 统计以 root 为起点，满足和为 target 的路径数量
     *
     * @param root   当前节点
     * @param target 目标数值
     * @return 路径数量
     */
    private int rootSum(TreeNode root, long target) {
        if (root == null) {
            return 0;
        }

        int cnt = 0;
        if (root.val == target) {
            cnt += 1;
        }
        cnt += rootSum(root.left, target - root.val);
        cnt += rootSum(root.right, target - root.val);
        return cnt;
    }

    /**
     * 官方题解
     * <p>
     * 思路：前缀和，利用 pre[j] - pre[k] = target 的方式，来寻找满足条件的路径
     * <p>
     * 从上往下计算前缀和时，同时记录前缀和的频率，这样可以快速统计出右多少个满足要求的路径
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:41.18MB,击败了16.35% 的Java用户
     */
    @TestCase(input = {"[10,5,-3,3,2,null,11,3,-2,null,1]", "8",
            "[5,4,8,11,null,13,4,7,2,null,null,5,1]", "22"},
            output = {"3", "3"})
    public int prefix(TreeNode root, int targetSum) {
        // 前缀和频率
        Map<Long, Integer> freq = new HashMap<>();
        freq.put(0L, 1);
        return prefix(root, targetSum, 0, freq);
    }

    private int prefix(TreeNode root, int targetSum, long sum, Map<Long, Integer> freq) {
        if (root == null) {
            return 0;
        }

        // 当前节点的前缀和
        sum += root.val;
        int cnt = freq.getOrDefault(sum - targetSum, 0);

        // 增加新的前缀和
        freq.put(sum, freq.getOrDefault(sum, 0) + 1);

        // 递归前缀和
        cnt += prefix(root.left, targetSum, sum, freq);
        cnt += prefix(root.right, targetSum, sum, freq);

        // 不连续的前缀和不能用，所以要去掉
        freq.put(sum, freq.get(sum) - 1);
        return cnt;
    }

}
