package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.TestCase;

import java.util.*;

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
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 *
 * @since 2022/5/31
 */
public class SolveNQueens {

    /**
     * 思路：回溯法，递归实现
     * <p>
     * 复杂度：时间 O(n!) 空间 O(mn)
     * <p>
     * 执行耗时:3 ms,击败了55.83% 的Java用户
     * 内存消耗:42.8 MB,击败了28.68% 的Java用户
     */
    @TestCase(input = {"4", "1"},
            output = {"[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]", "[[\"Q\"]]"})
    public List<List<String>> dfs(int n) {
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

    private void dfs(char[][] queens, int index, List<List<String>> ans) {
        if (index >= queens.length) {
            List<String> str = new ArrayList<>();
            for (char[] queue : queens) {
                str.add(new String(queue));
            }
            ans.add(str);
            return;
        }
        int n = queens[index].length;
        for (int j = 0; j < n; j++) {
            if (!isValid(queens, index, j)) {
                continue;
            }

            queens[index][j] = 'Q';
            dfs(queens, index + 1, ans);
            queens[index][j] = '.';
        }
    }

    /**
     * 位置 [i,j] 是否是有效的
     */
    private boolean isValid(char[][] queens, int i, int j) {
        // 同一列冲突
        for (int x = 0; x < i; x++) {
            if (queens[x][j] == 'Q') {
                return false;
            }
        }
        // 对角线冲突
        int n = queens[i].length;
        for (int x = 0; x < i; x++) {
            for (int y = 0; y < n; y++) {
                if (queens[x][y] == 'Q' && Math.abs(x - i) == Math.abs(y - j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 这比我想象中的要慢很多呀~
     * <p>
     * 思路：回溯法，迭代实现
     * <p>
     * 复杂度：时间 O() 空间 O()
     * <p>
     * 执行耗时:5 ms,击败了25.47% 的Java用户
     * 内存消耗:41.6 MB,击败了57.05% 的Java用户
     */
    @TestCase(input = {"4", "1"},
            output = {"[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]", "[[\"Q\"]]"})
    public List<List<String>> iterate(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] indexes = new int[n];
        int k = 0;
        while (k >= 0) {
            // 当前行已遍历完，需要回溯上一行
            if (k >= n || indexes[k] >= n) {
                if (k >= n) {
                    // 遍历完了所有行，说明是有效的方案
                    ans.add(arrayToMatrix(indexes));
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

    /**
     * 官方题解
     * <p>
     * 思路：回溯，递归实现
     * <p>
     * 用 Set 记录列、左斜线、右斜线的皇后位置, 可实现 O(1) 复杂度判断位置是否合法
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了42.88% 的Java用户
     * 内存消耗:42.8 MB,击败了32.98% 的Java用户
     */
    @TestCase(input = {"4", "1"},
            output = {"[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]", "[[\"Q\"]]"})
    public List<List<String>> backtrack(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> dlr = new HashSet<>();
        Set<Integer> drl = new HashSet<>();
        backtrack(queens, 0, n, col, dlr, drl, ans);
        return ans;
    }

    private void backtrack(int[] queens, int r, int n,
                           Set<Integer> col, Set<Integer> dlr, Set<Integer> drl,
                           List<List<String>> ans) {
        if (r >= queens.length) {
            ans.add(arrayToMatrix(queens));
            return;
        }
        for (int c = 0; c < n; c++) {
            // 同一列
            if (col.contains(c)) {
                continue;
            }
            // 对角线
            int d1 = r - c, d2 = r + c;
            if (dlr.contains(d1) || drl.contains(d2)) {
                continue;
            }

            queens[r] = c;
            col.add(c);
            dlr.add(d1);
            drl.add(d2);
            backtrack(queens, r + 1, n, col, dlr, drl, ans);
            drl.remove(d2);
            dlr.remove(d1);
            col.remove(c);
            queens[r] = -1;
        }
    }

    private List<String> arrayToMatrix(int[] indexes) {
        List<String> str = new ArrayList<>();
        int n = indexes.length;
        for (int index : indexes) {
            char[] s = new char[n];
            Arrays.fill(s, '.');
            s[index] = 'Q';
            str.add(new String(s));
        }
        return str;
    }

}
