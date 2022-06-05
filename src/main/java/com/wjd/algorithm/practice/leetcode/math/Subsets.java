package com.wjd.algorithm.practice.leetcode.math;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * @since 2022/6/5
 */
public class Subsets implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        int[] nums = {1,2,3};
        List<List<Integer>>  result = subsets(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：遍历每种长度的子集
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了7.74% 的Java用户
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, 0, i, new ArrayList<>(), ans);
        }
        return ans;
    }

    /**
     * 递归法
     */
    private void dfs(int[] nums, int i, int k, List<Integer> list, List<List<Integer>> ans) {
        if (k == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 剪枝
        if (i >= nums.length || nums.length - i + list.size() < k) {
            return;
        }

        // 算上当前元素
        list.add(nums[i]);
        dfs(nums, i + 1, k, list, ans);
        list.remove(list.size() - 1);

        // 不算当前元素
        dfs(nums, i + 1, k, list, ans);
    }

}
