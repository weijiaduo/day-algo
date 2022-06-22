package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * 130. 被围绕的区域
 * <p>
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * <p>
 * @author weijiaduo
 * @since 2022/6/22
 */
public class SurroundBoard implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        ArrayUtil.print(board);
        surround(board);
        ArrayUtil.print(board);
        return null;
    }

    /**
     * 思路：找出靠四边的O，剩下的O就是被X包围的
     *
     * 执行耗时:1 ms,击败了99.93% 的Java用户
     * 内存消耗:43.2 MB,击败了80.27% 的Java用户
     */
    private void surround(char[][] board) {
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
        if (board[i][j] == 'X' || board[i][j] == 'S') {
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
