package com.wjd.practice.leetcode.matrix;

import java.util.Arrays;

/**
 * 36. 有效的数独
 * <p>
 * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 * @since 2021-10-16
 */
public class ValidSudoku {

    /**
     * 验证是否是有效的9x9数独
     */
    public boolean isValidSudoku(char[][] board) {
        // 校验行
        for (int i = 0; i < board.length; i++) {
            if (!checkRangeValid(board, i, 0, 1, board[i].length)) {
                return false;
            }
        }
        // 校验列
        for (int i = 0; i < board[0].length; i++) {
            if (!checkRangeValid(board, 0, i, board.length, 1)) {
                return false;
            }
        }
        // 校验方格
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if (!checkRangeValid(board, i, j, 3, 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 验证指定范围的有效性
     */
    private boolean checkRangeValid(char[][] board, int x, int y, int rows, int cols) {
        boolean[] flags = new boolean[9];
        Arrays.fill(flags, false);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = board[x + i][y + j];
                if (ch == '.') {
                    continue;
                }
                int index = ch - '1';
                if (flags[index]) {
                    return false;
                }
                flags[index] = true;
            }
        }
        return true;
    }

    /**
     * 官方解法，一次遍历
     */
    private boolean isValidSudoku2(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
