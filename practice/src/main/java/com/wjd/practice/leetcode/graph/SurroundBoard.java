package com.wjd.practice.leetcode.graph;

import com.wjd.practice.TestCase;

/**
 * 130. 被围绕的区域
 * <p>
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，或不与边界上的'O'相连的'O'最终都
 * 会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * @author weijiaduo
 * @since 2022/6/22
 */
public class SurroundBoard {

    /**
     * 思路：深度优先搜索，找出靠四边的O，剩下的O就是被X包围的
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:1 ms,击败了99.93% 的Java用户
     * 内存消耗:43.2 MB,击败了80.27% 的Java用户
     */
    @TestCase(input = {"[['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]",
            "[['X']]"},
            output = {"[['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]",
                    "[['X']]"})
    public void dfs(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        // 上边和下边
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        // 左边和右边
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        // 把所有S设置回O，非S的设为X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 深度遍历相邻的O
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        // 随便找个字符暂时替代O
        board[i][j] = 'S';
        // 遍历四边的字符O
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

}
