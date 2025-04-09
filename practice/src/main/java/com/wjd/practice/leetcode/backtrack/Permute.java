package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @since 2022/5/28
 */
public class Permute {

    /**
     * 思路：回溯，数字不重复，所以直接递归遍历，直接按照全排列的定义计算
     * 第1个位置，有n种情况
     * 第2个位置，有n-1种情况
     * ......
     * 第n个位置，有1种情况
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了52.44% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "[0,1]", "[1]"},
            output = {"[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]", "[[0,1],[1,0]]", "[[1]]"})
    public List<List<Integer>> backtrack(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans);
        return ans;
    }

    /**
     * 回溯
     *
     * @param nums 候选值
     * @param index 当前索引
     * @param ans 结果集
     */
    private void backtrack(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length - 1) {
            List<Integer> path = new ArrayList<>(nums.length);
            for (int num : nums) {
                path.add(num);
            }
            ans.add(path);
            return;
        }

        // 从候选值中选择一个值放在 index 位置
        for (int i = index; i < nums.length; i++) {
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            backtrack(nums, index + 1, ans);
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

    /**
     * 思路：回溯，使用额外空间记录已使用过的数字
     * 第1个位置，有n种情况
     * 第2个位置，有n-1种情况
     * ......
     * 第n个位置，有1种情况
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了96.74% 的Java用户
     * 内存消耗:43.5 MB,击败了95.93% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "[0,1]", "[1]"},
            output = {"[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]", "[[0,1],[1,0]]", "[[1]]"})
    public List<List<Integer>> backtrack2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        boolean[] used = new boolean[nums.length];
        backtrack2(nums, path, used, ans);
        return ans;
    }

    /**
     * 回溯
     *
     * @param nums 数组
     * @param path 当前选中路径
     * @param used 已选择的数字
     * @param ans 结果
     */
    private void backtrack2(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backtrack2(nums, path, used, ans);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
