package com.wjd.practice.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和2
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 *
 * @since 2022/5/22
 */
public class CombinationSum2 {

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, list);
        return result;
    }

    /**
     * 暴力递归
     * <p>
     * 执行耗时:4 ms,击败了41.30% 的Java用户
     * 内存消耗:41.8 MB,击败了42.67% 的Java用户
     */
    private void dfs(int[] candidates, int index, int target, List<List<Integer>> combines, List<Integer> list) {
        if (target == 0) {
            combines.add(new ArrayList<>(list));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            /*
             * 存在重复值时，按照顺序遍历，不能跳着遍历，这样做可以保证不重复
             * 比如 222，普通遍历为 222(1,2,3)、22(1,3)、22(2,3)、2(3)，括号内是索引
             * 改成按顺序遍历，则递归遍历效果为：222(1,2,3)、22(2,3)、2(3)
             */
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            /*
             * 关键的剪枝操作，排好序了，提前返回
             *
             * 执行耗时:2 ms,击败了99.79% 的Java用户
             * 内存消耗:41.1 MB,击败了99.75% 的Java用户
             */
            if (target < candidates[i]) {
                break;
            }

            list.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], combines, list);
            list.remove(list.size() - 1);
        }
    }

}
