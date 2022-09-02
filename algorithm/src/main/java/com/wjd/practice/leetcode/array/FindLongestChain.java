package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * <p>
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 * @author weijiaduo
 * @since 2022/9/3
 */
public class FindLongestChain implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
        int result = findLongestChain(pairs);
        System.out.println(result);
        return result;
    }

    private int findLongestChain(int[][] pairs) {
        // 方法1
        // Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        // return dfs(pairs, 0);

        // 方法2
        // Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        // int[] cache = new int[pairs.length];
        // Arrays.fill(cache, -1);
        // return dfsCache(pairs, 0, cache);

        // 方法3
        // return dynamic(pairs);

        // 方法4
        return greedy(pairs);
    }

    /**
     * 思路：回溯遍历，当前元素分为2种情况：属于最长数对链，不属于最长数对链
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     *
     * @param pairs 数对
     * @param index 当前元素索引
     * @return 从当前元素开始的子数组的最长数对链长度
     */
    private int dfs(int[][] pairs, int index) {
        if (index >= pairs.length) {
            return 0;
        }

        int max = 1;
        int[] cur = pairs[index];
        for (int i = index + 1; i < pairs.length; i++) {
            if (pairs[i][0] > cur[1]) {
                // 当前元素在数对链中
                max = Math.max(dfs(pairs, i) + 1, max);
            } else {
                // 当前元素不在数对链中
                max = Math.max(dfs(pairs, i), max);
            }
        }
        return max;
    }

    /**
     * 思路：回溯遍历，当前元素分为2种情况：属于最长数对链，不属于最长数对链
     * <p>
     * 为了避免重复计算，添加缓存记录已经算过的值
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:64 ms,击败了5.56% 的Java用户
     * 内存消耗:41.3 MB,击败了92.84% 的Java用户
     *
     * @param pairs 数对
     * @param index 当前元素索引
     * @param cache 缓存
     * @return 从当前元素开始的子数组的最长数对链长度
     */
    private int dfsCache(int[][] pairs, int index, int[] cache) {
        if (index >= pairs.length) {
            return 0;
        }

        // 优先走缓存
        if (cache[index] != -1) {
            return cache[index];
        }

        int max = 1;
        for (int i = index + 1; i < pairs.length; i++) {
            if (pairs[i][0] > pairs[index][1]) {
                // 当前元素在数对链中
                max = Math.max(dfsCache(pairs, i, cache) + 1, max);
            } else {
                // 当前元素不在数对链中
                max = Math.max(dfsCache(pairs, i, cache), max);
            }
        }
        cache[index] = max;
        return max;
    }

    /**
     * 思路：动态规划，先计算得到[0, i - 1]的所有数对链，从而推导出[0, i]的最长数对链
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:31 ms,击败了35.15% 的Java用户
     * 内存消耗:41.3 MB,击败了84.72% 的Java用户
     *
     * @param pairs 数对
     * @return 最长数对链的长度
     */
    private int dynamic(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;

        // 初始化动态数组
        // dp[i] 表示已i为结尾的数对链的最大长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // 动态推导下一个状态
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    /**
     * 思路：贪心，优先选择[i,j]中较小的区间
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:8 ms,击败了98.18% 的Java用户
     * 内存消耗:41.3 MB,击败了89.53% 的Java用户
     *
     * @param pairs 数对
     * @return 最长数对链的长度
     */
    private int greedy(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int max = 0;
        int last = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > last) {
                last = pair[1];
                max++;
            }
        }
        return max;
    }

}
