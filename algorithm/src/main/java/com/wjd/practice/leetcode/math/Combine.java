package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * @since 2022/6/5
 */
public class Combine implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
        return result;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 递归法
     *
     * 思路：每个元素都有选择和不选择2种情况，分别列举这2种情况即可
     *
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.9 MB,击败了22.44% 的Java用户
     */
    private void dfs(int i, int n, int k, List<Integer> list, List<List<Integer>> ans) {
        if (k == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 剪枝
        if (i > n || n - i + 1 + list.size() < k) {
            return;
        }

        // 算上当前元素
        list.add(i);
        dfs(i + 1, n, k, list, ans);
        list.remove(list.size() - 1);

        // 不算当前元素
        dfs(i + 1, n, k, list, ans);
    }
}
