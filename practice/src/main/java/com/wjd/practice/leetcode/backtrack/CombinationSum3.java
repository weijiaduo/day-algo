package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和3
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * <p>
 * 每个数字 最多使用一次
 * <p>
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * <p>
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * <p>
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * <p>
 * 提示:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class CombinationSum3 {

    List<List<Integer>> ans;
    List<Integer> nums;

    /**
     * 思路：回溯法，组合所有k个数字的情况，验证结果是否等于n
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了32.24% 的Java用户
     *
     * @param k 还差k个数字
     * @param n 还剩余的数值和
     */
    @TestCase(input = {"3", "7", "3", "9", "4", "1"},
            output = {"[[1,2,4]]", "[[1,2,6], [1,3,5], [2,3,4]]", "[]"})
    public List<List<Integer>> combination(int k, int n) {
        ans = new ArrayList<>();
        nums = new ArrayList<>(k);
        combination(1, 10, k, n);
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
     * @param k 还差k个数字
     * @param n 还剩余的数值和
     */
    @TestCase(input = {"3", "7", "3", "9", "4", "1"},
            output = {"[[1,2,4]]", "[[1,2,6], [1,3,5], [2,3,4]]", "[]"})
    public List<List<Integer>> combination2(int k, int n) {
        ans = new ArrayList<>();
        nums = new ArrayList<>(k);
        combination2(1, 10, k, n);
        return ans;
    }

    /**
     * 回溯法，每个数字都有选择和不选择2种情况
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
