package com.wjd.practice.book.sword.dynamic;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 60. n 个骰子的点数
 * <p>
 * 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s。
 * <p>
 * 输入 n，打印出 s 的所有可能的值出现的概率。
 *
 * @author weijiaduo
 * @since 2023/11/29
 */
public class DicesProbability {

    /**
     * 思路：动态规划
     * <p>
     * 定义 f(i,j) 为 i 个骰子点数和为 j 的情况数量
     * <p>
     * 则有 f(i,j) = f(i-1,j-1) + f(i-1,j-2) + ... + f(i-1,j-6)
     * <p>
     * 只依赖于上一行的结果，实际上可以压缩成 2 行数组就可以计算了，但是这里懒得优化了
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"1", "2"},
            output = {"{1=0.1667,2=0.1667,3=0.1667,4=0.1667,5=0.1667,6=0.1667}",
                    "{2=0.0278,3=0.0555,4=0.0833,5=0.1111,6=0.1389,7=0.1667,8=0.1389,9=0.1111,10=0.0833,11=0.0555,12=0.0278}"})
    public Map<Integer, Double> dynamic2(int n) {
        // 骰子的面数
        final int m = 6;
        // 骰子的全排列数量 6^n
        double total = Math.pow(m, n);

        // 状态定义
        // dp[i][j] 表示有 i 个骰子时和为 j 的情况数量
        // 其中 1 <= i <= n，m <= j <= n * m
        int[][] dp = new int[n + 1][n * m + 1];

        // 状态初始化
        // 骰子数量为 1 时，点数只有 1 种情况
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }

        // 状态转移
        for (int i = 2; i <= n; i++) {
            // i 个骰子的点数范围是 [i, i*m]
            for (int j = i; j <= i * m; j++) {
                // dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + ... + dp[i-1][j-m]
                for (int k = 1; k <= m; k++) {
                    if (j - k > 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        // 计算每种点数的出现概率
        Map<Integer, Double> map = new HashMap<>();
        for (int j = n; j <= n * m; j++) {
            map.put(j, dp[n][j] / total);
        }
        return map;
    }

}
