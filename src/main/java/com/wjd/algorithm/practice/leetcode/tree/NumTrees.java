package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 96. 不同的二叉树搜索树
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 输入：n = 3
 * 输出：5
 * <p>
 * @since 2022/6/11
 */
public class NumTrees implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 4;
        int result = numTrees(n);
        System.out.println(result);
        return result;
    }

    public int numTrees(int n) {
        return dynamic(n);
    }

    /**
     * 递归法
     *
     * 思路：计算不同左右子树的数量乘积
     *
     * Time Limit Exceeded
     *
     * 测试用例:17
     */
    private int backtrack(int from, int to) {
        if (from >= to) {
            return 1;
        }
        int sum = 0;
        for (int i = from; i < to; i++) {
            sum += backtrack(from, i) * backtrack(i + 1, to);
        }
        return sum;
    }

    /**
     * 动态规划
     *
     * 思路：不同的树 = 不同左子树 * 不同右子树，后面的值可由前面的值遍历得到
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了52.75% 的Java用户
     */
    private int dynamic(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 以j为根，左子树j-1，右子树i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 数学法
     *
     * 卡塔兰数，数学公式直接计算
     */
    public int catalan(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long c = 1;
        for (int i = 0; i < n; ++i) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) c;
    }

}
