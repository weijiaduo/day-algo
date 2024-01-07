package com.wjd.practice.book.cracking.matrix;


import com.wjd.practice.TestCase;

/**
 * 面试题 16.04. 井字游戏
 * <p>
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * <p>
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；
 * 如果游戏以平局结束，则返回 "Draw"；
 * 如果仍会有行动（游戏未结束），则返回"Pending"。
 * <p>
 * 示例 1：
 * <p>
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * <p>
 * 示例 2：
 * <p>
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * <p>
 * 示例 3：
 * <p>
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 *
 * @author weijiaduo
 * @since 2024/1/7
 */
public class Tictactoe {

    /**
     * 思路：暴力遍历所有可能的情况
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了22.45% 的Java用户
     */
    @TestCase(input = {"[\"OX \",\"OX \",\"O  \"]",
            "[\"O\"]",
            "[\"O X\",\" XO\",\"X O\"]",
            "[\"OOX\",\"XXO\",\"OXO\"]",
            "[\"OOX\",\"XXO\",\"OX \"]",
            "[\"OOXXOXXX\",\"XXXOXOXO\",\"OXOXXXOO\",\"XOXOXXXX\",\"OXOOXOOO\",\"XOOOOOOO\",\"OXXXOOOX\",\"XOXOOXXX\"]"},
            output = {"O", "O", "X", "Draw", "Pending", "Draw"})
    public String check(String[] board) {
        // 检查 O 赢的情况
        boolean checkO = checkRows(board, 'O')
                         || checkCols(board, 'O')
                         || checkCross(board, 'O');
        if (checkO) {
            return "O";
        }

        // 检查 X 赢的情况
        boolean checkX = checkRows(board, 'X')
                         || checkCols(board, 'X')
                         || checkCross(board, 'X');
        if (checkX) {
            return "X";
        }

        // 平局或者进行中
        String ret = "Draw";
        for (String s : board) {
            if (s.contains(" ")) {
                ret = "Pending";
                break;
            }
        }
        return ret;
    }

    /**
     * 检查对角线是否赢了
     *
     * @param board 数组
     * @param ch    字符
     * @return true/false
     */
    private boolean checkCross(String[] board, char ch) {
        // 主对角线
        int n = board.length, i = 0;
        for (; i < n; i++) {
            if (board[i].charAt(i) != ch) {
                break;
            }
        }
        if (i == n) {
            return true;
        }
        // 副对角线
        i = 0;
        for (; i < n; i++) {
            if (board[i].charAt(n - 1 - i) != ch) {
                break;
            }
        }
        return i == n;
    }

    /**
     * 检查列是否赢了
     *
     * @param board 数组
     * @param ch    字符
     * @return true/false
     */
    private boolean checkCols(String[] board, char ch) {
        int n = board.length;
        for (int c = 0; c < n; c++) {
            int r = 0;
            for (; r < n; r++) {
                if (board[r].charAt(c) != ch) {
                    break;
                }
            }
            if (r == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查行是否赢了
     *
     * @param board 数组
     * @param ch    字符
     * @return true/false
     */
    private boolean checkRows(String[] board, char ch) {
        for (String s : board) {
            int n = s.length(), r = 0;
            for (; r < n; r++) {
                if (s.charAt(r) != ch) {
                    break;
                }
            }
            if (r == n) {
                return true;
            }
        }
        return false;
    }

}
