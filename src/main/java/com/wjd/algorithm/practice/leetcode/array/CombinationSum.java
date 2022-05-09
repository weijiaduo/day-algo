package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<List<Integer>> solve(Object args) {
        int[] candidates = {1};
        int target = 2;
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

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int[] keys = new int[candidates.length];
        Arrays.fill(keys, 0);
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j < candidates.length; j++) {

            }
        }

        int val = target;
        int i = 0, j = 0;
        while (i >= 0) {
            if (candidates[j] > val) {
                while (i >= 0 && keys[i] == 0) {
                    i--;
                }
                if (i < 0) {
                    break;
                }
                j++;
                keys[i]--;
                val += candidates[i];
            } else if (candidates[j] < val) {
                keys[j]++;
                val -= candidates[j];
            } else {
                List<Integer> list = new ArrayList<>();
                for (int m = 0; m <= i; m++) {
                    for (int n = 0; n < keys[m]; n++) {
                        list.add(candidates[m]);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

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
