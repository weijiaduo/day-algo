package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和3
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * <p>
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class CombinationSum3 implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        int k = 9;
        int n = 45;
        List<List<Integer>> result = combinationSum3(k, n);
        System.out.println(result);
        return result;
    }

    List<List<Integer>> ans;
    List<Integer> nums;

    private List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        nums = new ArrayList<>(k);
        combination2(1, 10, k, n);
        return ans;
    }

    /**
     * 思路：回溯法，组合所有k个数字的情况，验证结果是否等于n
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了32.24% 的Java用户
     *
     * @param l [l, r)
     * @param r [l, r)
     * @param k 还差k个数字
     * @param n 还剩余的数值和
     */
    private void combination(int l, int r, int k, int n) {
        // 快速剪枝
        if (n < 0) {
            return;
        }
        // 返回结果
        if (k == 0) {
            if (n == 0) {
                ans.add(new ArrayList<>(nums));
            }
            return;
        }

        // 回溯遍历所有数字
        for (int j = l; j < r; j++) {
            nums.add(j);
            combination(j + 1, r, k - 1, n - j);
            nums.remove(nums.size() - 1);
        }
    }

    /**
     * 思路：回溯法，每个数字都有选择和不选择2种情况
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.9 MB,击败了68.21% 的Java用户
     *
     * @param l [l, r)
     * @param r [l, r)
     * @param k 还差k个数字
     * @param n 还剩余的数值和
     */
    private void combination2(int l, int r, int k, int n) {
        // 快速剪枝
        if (r < l || n < 0) {
            return;
        }
        // 返回结果
        if (k == 0) {
            if (n == 0) {
                ans.add(new ArrayList<>(nums));
            }
            return;
        }

        // 选择当前数字
        nums.add(l);
        combination2(l + 1, r, k - 1, n - l);
        nums.remove(nums.size() - 1);

        // 不选择当前数字
        combination(l + 1, r, k, n);
    }

}
