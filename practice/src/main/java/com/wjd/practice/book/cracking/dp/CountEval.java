package com.wjd.practice.book.cracking.dp;

import com.wjd.practice.TestCase;

/**
 * 面试题 08.14. 布尔运算
 * <p>
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR)符号组成。
 * <p>
 * 实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "1^0|0|1", result = 0
 * <p>
 * 输出: 2
 * 解释:两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "0&0&0&1^1|0", result = 1
 * <p>
 * 输出: 10
 * <p>
 * 提示：
 * <p>
 * 运算符的数量不超过 19 个
 *
 * @author weijiaduo
 * @since 2024/1/2
 */
public class CountEval {

    /**
     * 思路：递归+记忆化搜索
     * <p>
     * 记录 s[i..j] 等于 0 和等于 1 的结果数量
     * <p>
     * 然后进一步判断整个表达式的结果数量
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了55.79% 的Java用户
     * 内存消耗:41.3 MB,击败了10.00% 的Java用户
     */
    @TestCase(input = {"1^0|0|1", "0", "0&0&0&1^1|0", "1"},
            output = {"2", "10"})
    public int dfs(String s, int result) {
        int n = s.length();
        int[][][] meno = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                meno[i][j][0] = meno[i][j][1] = -1;
            }
        }
        return dfs(s, 0, n - 1, result, meno);
    }

    /**
     * 递归
     *
     * @param s      字符串
     * @param i      [i,j]
     * @param j      [i,j]
     * @param result 目标值
     * @param meno   记忆化存储
     * @return 结果数量
     */
    private int dfs(String s, int i, int j, int result, int[][][] meno) {
        if (j < i) {
            return 0;
        }
        if (meno[i][j][result] > -1) {
            return meno[i][j][result];
        }
        if (i == j) {
            int ch = s.charAt(i) - '0';
            int ret = ch - result == 0 ? 1 : 0;
            meno[i][j][result] = ret;
            return ret;
        }
        int sum = 0;
        for (int k = i + 1; k < j; k += 2) {
            char ch = s.charAt(k);
            if (ch == '&') {
                if (result == 0) {
                    sum += dfs(s, i, k - 1, 0, meno) * dfs(s, k + 1, j, 0, meno);
                    sum += dfs(s, i, k - 1, 0, meno) * dfs(s, k + 1, j, 1, meno);
                    sum += dfs(s, i, k - 1, 1, meno) * dfs(s, k + 1, j, 0, meno);
                } else {
                    sum += dfs(s, i, k - 1, 1, meno) * dfs(s, k + 1, j, 1, meno);
                }
            } else if (ch == '|') {
                if (result == 0) {
                    sum += dfs(s, i, k - 1, 0, meno) * dfs(s, k + 1, j, 0, meno);
                } else {
                    sum += dfs(s, i, k - 1, 0, meno) * dfs(s, k + 1, j, 1, meno);
                    sum += dfs(s, i, k - 1, 1, meno) * dfs(s, k + 1, j, 0, meno);
                    sum += dfs(s, i, k - 1, 1, meno) * dfs(s, k + 1, j, 1, meno);
                }
            } else if (ch == '^') {
                if (result == 0) {
                    sum += dfs(s, i, k - 1, 0, meno) * dfs(s, k + 1, j, 0, meno);
                    sum += dfs(s, i, k - 1, 1, meno) * dfs(s, k + 1, j, 1, meno);
                } else {
                    sum += dfs(s, i, k - 1, 0, meno) * dfs(s, k + 1, j, 1, meno);
                    sum += dfs(s, i, k - 1, 1, meno) * dfs(s, k + 1, j, 0, meno);
                }
            }
        }
        meno[i][j][result] = sum;
        return sum;
    }

    /**
     * 思路：动态规划，递推
     * <p>
     * dp[i][j][k] 表示s[i..j]结果等于 k 时的结果数量
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:6 ms,击败了14.74% 的Java用户
     * 内存消耗:41.1 MB,击败了12.11% 的Java用户
     */
    @TestCase(input = {"1^0|0|1", "0", "0&0&0&1^1|0", "1"},
            output = {"2", "10"})
    public int dynamic2(String s, int result) {
        // 状态定义
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        // 初始化定义
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                dp[i][i][0] = 1;
            } else if (ch == '1') {
                dp[i][i][1] = 1;
            }
        }
        // 状态转移
        for (int i = n - 1; i >= 0; i -= 2) {
            for (int j = i + 2; j < n; j += 2) {
                for (int k = i + 1; k < j; k += 2) {
                    char ch = s.charAt(k);
                    int zz = dp[i][k - 1][0] * dp[k + 1][j][0];
                    int zo = dp[i][k - 1][0] * dp[k + 1][j][1];
                    int oz = dp[i][k - 1][1] * dp[k + 1][j][0];
                    int oo = dp[i][k - 1][1] * dp[k + 1][j][1];
                    if (ch == '&') {
                        dp[i][j][1] += oo;
                        dp[i][j][0] += zz + zo + oz;
                    } else if (ch == '|') {
                        dp[i][j][0] += zz;
                        dp[i][j][1] += oo + oz + zo;
                    } else if (ch == '^') {
                        dp[i][j][0] += zz + oo;
                        dp[i][j][1] += oz + zo;
                    }
                }
            }
        }
        return dp[0][n - 1][result];
    }

}
