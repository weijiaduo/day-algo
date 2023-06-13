package com.wjd.practice.leetcode.tree.path;

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

    public int pathSum(TreeNode root, int targetSum) {
        // return dfs(root, targetSum);
        return prefix(root, targetSum);
    }

    private int dfs(TreeNode root, int targetSum) {
        return dfs(root, targetSum, false);
    }

    /**
     * 思路：递归，以每个节点为起始节点，往下遍历所有子节点，寻找目标值
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(logn)
     * <p>
     * 执行耗时:37 ms,击败了10.16% 的Java用户
     * 内存消耗:41.4 MB,击败了46.85% 的Java用户
     *
     * @param root    根节点
     * @param target  目标值，用 int 类型的话，可能会溢出
     * @param started 路径是否已经开始
     */
    private int dfs(TreeNode root, long target, boolean started) {
        if (root == null) {
            return 0;
        }

        // 满足条件
        int cnt = 0;
        if (root.val == target) {
            cnt++;
        }

        // 从根节点出发
        cnt += dfs(root.left, target - root.val, true);
        cnt += dfs(root.right, target - root.val, true);

        // 路径是连续的，如果是从父节点上面下来的路径不能再从子节点出发
        if (!started) {
            // 从子节点出发
            cnt += dfs(root.left, target, false);
            cnt += dfs(root.right, target, false);
        }
        return cnt;
    }

    // 前缀和频率
    Map<Long, Integer> map = new HashMap<>();

    private int prefix(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0L, 1);
        return prefix(root, targetSum, 0);
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
     * 执行耗时:3 ms,击败了79.34% 的Java用户
     * 内存消耗:42.3 MB,击败了8.42% 的Java用户
     */
    private int prefix(TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return 0;
        }

        // 当前节点的前缀和
        sum += root.val;
        int cnt = map.getOrDefault(sum - targetSum, 0);

        // 增加新的前缀和
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        // 递归前缀和
        cnt += prefix(root.left, targetSum, sum);
        cnt += prefix(root.right, targetSum, sum);

        // 不连续的前缀和不能用，所以要去掉
        map.put(sum, map.get(sum) - 1);
        return cnt;
    }

}
