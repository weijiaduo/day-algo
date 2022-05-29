package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021/10/18
 * <p>
 * 39.组合总和
 * <p>
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * <p>
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 */
public class CombinationSum implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object ...args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
        return result;
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        find(candidates, 0, target, result, list);
        return result;
    }

    /**
     * 递归
     * <p>
     * 执行耗时:3 ms,击败了53.98% 的Java用户
     * 内存消耗:41.5 MB,击败了76.28% 的Java用户
     */
    private void find(int[] candicates, int index, int target,
                      List<List<Integer>> combines, List<Integer> list) {
        if (index >= candicates.length || target < 0) {
            return;
        }
        if (target == 0) {
            combines.add(new ArrayList<>(list));
            return;
        }

        // 包括当前元素
        list.add(candicates[index]);
        find(candicates, index, target - candicates[index], combines, list);
        list.remove(list.size() - 1);

        // 不包括当前元素
        find(candicates, index + 1, target, combines, list);
    }

}
