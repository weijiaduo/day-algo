package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 * <p>
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * @since 2022/5/22
 */
public class SolveSudoku implements Solution<Void> {

    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] boxes = new boolean[3][3][9];
    List<int[]> spaces = new ArrayList<>();
    
    @Override
    public Void solve(Object args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        ArrayUtil.print(board);
        return null;
    }

    public void solveSudoku(char[][] board) {
        // deepSudoku(board);
        prepare(board);
        dfs(board, 0);
    }

    /**
     * 暴力法
     *
     * 执行耗时:4 ms,击败了60.32% 的Java用户
     * 内存消耗:40.6 MB,击败了7.81% 的Java用户
     */
    private boolean deepSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                
                boolean[] usedNumbers = new boolean[9];
                for (int k = 0; k < board[0].length; k++) {
                    if (board[i][k] != '.') {
                        usedNumbers[board[i][k] - '1'] = true;
                    }
                }
                for (int k = 0; k < board.length; k++) {
                    if (board[k][j] != '.') {
                        usedNumbers[board[k][j] - '1'] = true;
                    }
                }
                int boxLeft = j / 3 * 3;
                int boxTop = i / 3 * 3;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[boxTop + m][boxLeft + n] != '.') {
                            usedNumbers[board[boxTop + m][boxLeft + n] - '1'] = true;
                        }
                    }
                }

                for (int k = 0; k < usedNumbers.length; k++) {
                    if (usedNumbers[k]) {
                        continue;
                    }
                    board[i][j] = (char)('1' + k);
                    boolean result = deepSudoku(board);
                    if (result) {
                        return true;
                    } else {
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private void prepare(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int index = board[i][j] - '1';
                    rows[i][index] = true;
                    cols[j][index] = true;
                    boxes[i / 3][j / 3][index] = true;
                }
            }
        }
    }

    /**
     * 空间换时间
     *
     * 执行耗时:2 ms,击败了91.42% 的Java用户
     * 内存消耗:38.6 MB,击败了87.68% 的Java用户
     */
    private boolean dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            return true;
        }

        int[] point = spaces.get(pos);
        int i = point[0];
        int j = point[1];
        for (int k = 0; k < 9; k++) {
            if (rows[i][k] || cols[j][k] || boxes[i / 3][j / 3][k]) {
                continue;
            }
            rows[i][k] = cols[j][k] = boxes[i / 3][j / 3][k] = true;
            board[i][j] = (char)('1' + k);
            boolean result = dfs(board,pos + 1);
            rows[i][k] = cols[j][k] = boxes[i / 3][j / 3][k] = false;
            if (result) {
                return true;
            } else {
                board[i][j] = '.';
            }
        }
        return false;
    }
}
