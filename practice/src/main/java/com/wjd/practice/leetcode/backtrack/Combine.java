package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @since 2022/6/5
 */
public class Combine {

    /**
     * 思路：回溯，每个元素都有选择和不选择2种情况，分别列举这2种情况即可
     * <p>
     * 复杂度：时间 O(C(n,k) * k) 空间 O(n)
     * <p>
     * 执行耗时:11 ms,击败了97.09% 的Java用户
     * 内存消耗:90.9 MB,击败了34.77% 的Java用户
     */
    @TestCase(input = {"4", "2", "1", "1"},
            output = {"[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]", "[[1]]"})
    public List<List<Integer>> backtrack(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 回溯
     *
     * @param i    当前索引
     * @param n    最大索引
     * @param k    剩余数量
     * @param list 当前数字集合
     * @param ans  结果集
     */
    private void backtrack(int i, int n, int k, List<Integer> list, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 快速剪枝
        if (i > n || n - i + 1 < k) {
            return;
        }

        // 算上当前元素
        list.add(i);
        backtrack(i + 1, n, k - 1, list, ans);
        list.remove(list.size() - 1);

        // 不算当前元素
        backtrack(i + 1, n, k, list, ans);
    }

}
