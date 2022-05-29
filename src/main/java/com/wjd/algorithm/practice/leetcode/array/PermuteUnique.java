package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列2
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * @since 2022/5/28
 */
public class PermuteUnique implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object ...args) {
        int[] nums = {2,2,1,1};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
        return result;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrackPermute(nums, 0, visited, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 回溯法
     *
     * 这个我还真没啥思路
     *
     * 执行耗时:1 ms,击败了99.81% 的Java用户
     * 内存消耗:42.3 MB,击败了16.44% 的Java用户
     */
    private void backtrackPermute(int[] nums, int index, boolean[] visited, List<Integer> list, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 去掉重复数字的排列情况
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrackPermute(nums, index + 1, visited, list, ans);
            visited[i] = false;
            list.remove(index);
        }
    }
}
