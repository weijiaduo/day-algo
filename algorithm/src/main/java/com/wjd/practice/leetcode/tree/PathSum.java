package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和2
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * @since 2022/6/19
 */
public class PathSum implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        Integer[] values = {1,2};
        int targetSum = 0;
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.traverse(root));
        List<List<Integer>> result = pathSum(root, targetSum);
        System.out.println(result);
        return result;
    }

    private List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 思路：深度优先遍历，到达叶子节点后，判断和是否相同即可
     *
     * 执行耗时:1 ms,击败了99.99% 的Java用户
     * 内存消耗:41.5 MB,击败了75.64% 的Java用户
     */
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
