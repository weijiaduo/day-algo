package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39.组合总和
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * <p>
 * 找出 candidates 中可以使数字和为目标数 target 的所有 不同组合 ，并以列表形式返回。
 * <p>
 * 你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。
 * <p>
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 * @since 2021/10/18
 */
public class CombinationSum {

    /**
     * 思路：回溯，每个数字可以有 2 种选择：选择或不选择
     * <p>
     * 根据这2种情况进行回溯，直到找到 target 的值为止
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了99.95% 的Java用户
     * 内存消耗:42.8 MB,击败了33.65% 的Java用户
     */
    @TestCase(input = {"[2,3,6,7]", "7", "[2,3,5]", "8", "[2]", "1"},
            output = {"[[2,2,3],[7]]", "[[2,2,2,2],[2,3,3],[3,5]]", "[]"})
    public List<List<Integer>> backtrack(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 排序，方便后面快速剪枝
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, list, ans);
        return ans;
    }

    /**
     * 回溯
     *
     * @param candidates 备选值
     * @param index      当前索引
     * @param target     剩余值
     * @param list       当前集合
     * @param ans        结果集
     */
    private void backtrack(int[] candidates, int index, int target, List<Integer> list,
                           List<List<Integer>> ans) {
        if (index >= candidates.length || target < 0) {
            return;
        }

        // 满足要求
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 快速剪枝
        if (candidates[index] > target) {
            return;
        }

        // 包括当前元素
        list.add(candidates[index]);
        backtrack(candidates, index, target - candidates[index], list, ans);
        list.remove(list.size() - 1);

        // 不包括当前元素
        backtrack(candidates, index + 1, target, list, ans);
    }

}
