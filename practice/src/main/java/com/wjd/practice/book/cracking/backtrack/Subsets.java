package com.wjd.practice.book.cracking.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * <p>
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author weijiaduo
 * @since 2023/12/30
 */
public class Subsets {

    /**
     * 思路：回溯遍历
     * <p>
     * 每个数字都有 2 种情况：选择和不选
     * <p>
     * 复杂度：时间 O(2^n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了8.51% 的Java用户
     */
    @TestCase(input = {"[1,2,3]"},
            output = {"[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]"})
    public List<List<Integer>> backtrack(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 回溯遍历
     *
     * @param nums 数组
     * @param i    下标
     * @param list 当前集合
     * @param ret  所有集合
     */
    private void backtrack(int[] nums, int i, List<Integer> list, List<List<Integer>> ret) {
        if (i >= nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        // 不选择当前元素
        backtrack(nums, i + 1, list, ret);
        // 选择当前元素
        list.add(nums[i]);
        backtrack(nums, i + 1, list, ret);
        list.remove(list.size() - 1);
    }

    /**
     * 思路：递推
     * <p>
     * 通过子集 s(i) 递推出 s(i+1)
     * <p>
     * s(i) = s(i-1) + nums[i]*s(i-1)
     * <p>
     * 复杂度：时间 O(2^n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了6.44% 的Java用户
     */
    @TestCase(input = {"[1,2,3]"},
            output = {"[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]"})
    public List<List<Integer>> dfs(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    /**
     * 递归
     *
     * @param nums 数组
     * @param i    下标
     * @return 幂集
     */
    private List<List<Integer>> dfs(int[] nums, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i < 0) {
            ans.add(new ArrayList<>()); // 空集合
            return ans;
        }
        List<List<Integer>> sub = dfs(nums, i - 1);
        ans.addAll(sub);
        for (List<Integer> s : sub) {
            List<Integer> ns = new ArrayList<>(s);
            ns.add(nums[i]);
            ans.add(ns);
        }
        return ans;
    }

}
