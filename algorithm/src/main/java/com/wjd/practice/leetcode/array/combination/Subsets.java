package com.wjd.practice.leetcode.array.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @since 2022/6/5
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // for (int i = 0; i <= nums.length; i++) {
        //     dfs(nums, 0, i, new ArrayList<>(), ans);
        // }
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 思路：遍历每种长度的子集，每个子集用回溯法找出所有排列
     * <p>
     * 复杂度：时间 O(n * 2^n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了7.74% 的Java用户
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

    /**
     * 思路：回溯法，每个数字都有2个选择：选中/不选中
     * <p>
     * 复杂度：时间 O(n * 2^n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了70.77% 的Java用户
     */
    private void backtrack(int[] nums, int i, List<Integer> list, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 算上当前元素
        list.add(nums[i]);
        backtrack(nums, i + 1, list, ans);
        list.remove(list.size() - 1);

        // 不算当前元素
        backtrack(nums, i + 1, list, ans);
    }

}
