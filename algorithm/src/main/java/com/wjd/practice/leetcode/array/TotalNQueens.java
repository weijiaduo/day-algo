package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * 52. N皇后2
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * @since 2022/5/31
 */
public class TotalNQueens implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 1;
        int result = totalNQueens(n);
        System.out.println(result);
        return result;
    }

    public int totalNQueens(int n) {
        return backtrace(n);
    }

    /**
     * 回溯法
     *
     * 这比我想象中的要慢很多呀~
     *
     * 执行耗时:4 ms,击败了17.96% 的Java用户
     * 内存消耗:38.3 MB,击败了53.00% 的Java用户
     */
    private int backtrace(int n) {
        int ans = 0;
        int[] indexes = new int[n];
        int k = 0;
        while (k >= 0) {
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

            if (!isValid) {
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

}
