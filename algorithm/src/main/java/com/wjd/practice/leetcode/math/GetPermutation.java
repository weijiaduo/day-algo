package com.wjd.practice.leetcode.math;

import com.wjd.practice.leetcode.Solution;

/**
 * 60. 排列序列
 * <p>
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * <p>
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 输入：n = 3, k = 3
 * 输出："213"
 * <p>
 * @since 2022/5/31
 */
public class GetPermutation implements Solution<String> {

    @Override
    public String solve(Object... args) {
        int n = 3;
        int k = 5;
        String result = getPermutation(n, k);
        System.out.println(result);
        return result;
    }

    String ans = null;
    int count = 0;
    boolean[] visited = null;

    public String getPermutation(int n, int k) {
        ans = null;
        count = k;
        visited = new boolean[n];
        char[] nums = new char[n];
        dfs(nums, 0);
        return ans;
    }

    /**
     * 递归法
     *
     * 好像有点慢呀
     *
     * 执行耗时:176 ms,击败了25.46% 的Java用户
     * 内存消耗:38.7 MB,击败了87.71% 的Java用户
     */
    private void dfs(char[] nums, int index) {
        if (index >= nums.length) {
            if (--count == 0) {
                ans = new String(nums);
            }
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            nums[index] = (char)('1' + i);
            dfs(nums, index + 1);
            visited[i] = false;
            nums[index] = ' ';
            if (count <= 0) {
                break;
            }
        }
    }

}
