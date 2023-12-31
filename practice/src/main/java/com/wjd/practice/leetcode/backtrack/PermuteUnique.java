package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列2
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],[1,2,1],[2,1,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @since 2022/5/28
 */
public class PermuteUnique {

    /**
     * 思路：回溯法
     * <p>
     * 重复的候选值只能选一个
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了99.82% 的Java用户
     * 内存消耗:44.1 MB,击败了5.01% 的Java用户
     */
    @TestCase(input = {"[1,1,2]", "[1,2,3]"},
            output = {"[[1,1,2],[1,2,1],[2,1,1]]",
                    "[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]"})
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans);
        return ans;
    }

    /**
     * 回溯
     *
     * @param nums  数组
     * @param index 待选位置下标
     * @param ans   结果集合
     */
    private void backtrack(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> path = new ArrayList<>(nums.length);
            for (int num : nums) {
                path.add(num);
            }
            ans.add(path);
            return;
        }

        // 相同数字只能选一次
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = index; i < n; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
            backtrack(nums, index + 1, ans);
            nums[i] = nums[index];
            nums[index] = tmp;
        }
    }

}
