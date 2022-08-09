package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.*;

/**
 * 90. 子集2
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * @since 2022/6/10
 */
public class SubsetsWithDup implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        int[] nums = {1,2,2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
        return result;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, false, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 执行耗时:1 ms,击败了99.70% 的Java用户
     * 内存消耗:41.5 MB,击败了63.50% 的Java用户
     */
    private void dfs(int[] nums, int k, boolean prevChoose, List<Integer> path, List<List<Integer>> ans) {
        if (k == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不选当前元素
        dfs(nums, k + 1, false, path, ans);

        // 和上一个元素相同时，上一个元素已经覆盖了当前元素选中的情况，无需再选中当前元素
        // 唯一例外就是，前面所有相同元素全都选中了，此时再加上当前元素就是一种新的情况
        if (k > 0 && nums[k] == nums[k - 1] && !prevChoose) {
            return;
        }

        // 选择当前元素
        path.add(nums[k]);
        dfs(nums, k + 1, true, path, ans);
        path.remove(path.size() - 1);
    }

}
