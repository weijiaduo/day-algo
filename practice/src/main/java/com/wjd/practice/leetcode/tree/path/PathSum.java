package com.wjd.practice.leetcode.tree.path;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和2
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @since 2022/6/19
 */
public class PathSum {

    /**
     * 思路：深度优先遍历，到达叶子节点后，判断和是否相同即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了99.99% 的Java用户
     * 内存消耗:41.5 MB,击败了75.64% 的Java用户
     */
    @TestCase(input = {"[5,4,8,11,null,13,4,7,2,null,null,5,1]", "22"},
            output = {"[[5,4,11,2],[5,8,4,5]]"})
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            dfs(root.left, sum - root.val, path, ans);
            dfs(root.right, sum - root.val, path, ans);
        }
        path.remove(path.size() - 1);
    }

}
