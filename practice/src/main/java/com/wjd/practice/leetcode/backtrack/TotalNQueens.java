package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.TestCase;

/**
 * 52. N皇后2
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 *
 * @since 2022/5/31
 */
public class TotalNQueens {

    /**
     * 思路：回溯法，迭代形式
     * <p>
     * 回溯统计所有的满足的情况
     * <p>
     * 复杂度：时间 O(n^n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了40.66% 的Java用户
     * 内存消耗:37.9 MB,击败了84.71% 的Java用户
     * <p>
     * 这比我想象中的要慢很多呀~
     */
    @TestCase(input = {"4", "1"},
            output = {"2", "1"})
    private int iterate(int n) {
        int ans = 0;
        int[] indexes = new int[n];
        for (int k = 0; k >= 0; ) {
            // 当前行已遍历完，需要回溯上一行
            if (k >= n || indexes[k] >= n) {
                if (k >= n) {
                    ans++;
                }

                // 回溯上一行
                if (--k >= 0) {
                    indexes[k]++;
                }
                continue;
            }

            // 验证当前位置是否有效
            if (!isValid(indexes, k)) {
                // 无效，继续遍历当前行的下一列
                indexes[k]++;
            } else {
                // 有效，遍历下一行
                if (++k < n) {
                    indexes[k] = 0;
                }
            }
        }
        return ans;
    }

    /**
     * 思路：回溯法，递归形式
     * <p>
     * 复杂度：时间 O(n^n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了65.33% 的Java用户
     * 内存消耗:37.8 MB,击败了94.29% 的Java用户
     */
    @TestCase(input = {"4", "1"},
            output = {"2", "1"})
    private int dfs(int n) {
        return dfs(0, n, new int[n]);
    }

    private int dfs(int k, int n, int[] indexes) {
        if (k >= n) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            indexes[k] = i;
            if (isValid(indexes, k)) {
                ans += dfs(k + 1, n, indexes);
            }
        }
        return ans;
    }

    /**
     * 验证当前位置是否有效（前面的位置确保是正确的）
     *
     * @param indexes 位置信息，i 表示列，indexes[i] 表示行
     * @param k       验证第 k 列
     * @return true/false
     */
    private boolean isValid(int[] indexes, int k) {
        boolean isValid = true;
        for (int i = 0; i < k; i++) {
            // 同列
            if (indexes[i] == indexes[k]) {
                isValid = false;
                break;
            }
            // 斜线
            if (Math.abs(i - k) == Math.abs(indexes[i] - indexes[k])) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

}
