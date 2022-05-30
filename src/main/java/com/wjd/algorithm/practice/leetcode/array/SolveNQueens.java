package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 * <p>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * <p>
 * @since 2022/5/31
 */
public class SolveNQueens implements Solution<List<List<String>>> {

    @Override
    public List<List<String>> solve(Object... args) {
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
        return result;
    }

    public List<List<String>> solveNQueens(int n) {
        // return solveDFS(n);
        return backtrace(n);
    }

    private List<List<String>> solveDFS(int n) {
        char[][] queues = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queues[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        dfs(queues, 0, ans);
        return ans;
    }

    /**
     * 递归法
     */
    private void dfs(char[][] queens, int index, List<List<String>> ans) {
        if (index >= queens.length) {
            List<String> str = new ArrayList<>();
            for (char[] queue : queens) {
                String s = new String(queue);
                str.add(s);
            }
            ans.add(str);
            return;
        }
        for (int i = 0; i < queens[index].length; i++) {
            boolean isValid = true;
            // 同一列
            for (int j = 0; j < index; j++) {
                if (queens[j][i] == 'Q') {
                    isValid = false;
                    break;
                }
            }
            // 斜线
            for (int j = 0; isValid && j < index; j++) {
                for (int k = 0; k < queens[j].length; k++) {
                    if (queens[j][k] == 'Q' && Math.abs(j - index) == Math.abs(k - i)) {
                        isValid = false;
                        break;
                    }
                }
            }
            if (!isValid) {
                continue;
            }

            queens[index][i] = 'Q';
            dfs(queens, index + 1, ans);
            queens[index][i] = '.';
        }
    }

    /**
     * 回溯法
     *
     * 这比我想象中的要慢很多呀~
     *
     * 执行耗时:5 ms,击败了25.47% 的Java用户
     * 内存消耗:41.6 MB,击败了57.05% 的Java用户
     */
    private List<List<String>> backtrace(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] indexes = new int[n];
        int k = 0;
        while (k >= 0) {
            // 当前行已遍历完，需要回溯上一行
            if (k >= n || indexes[k] >= n) {
                if (k >= n) {
                    // 遍历完了所有行，说明是有效的方案
                    ans.add(indexToString(indexes));
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

    private List<String> indexToString(int[] indexes) {
        List<String> str = new ArrayList<>();
        int n = indexes.length;
        ArrayUtil.print(indexes);
        for (int index : indexes) {
            char[] s = new char[n];
            Arrays.fill(s, '.');
            s[index] = 'Q';
            str.add(new String(s));
        }
        return str;
    }
}
