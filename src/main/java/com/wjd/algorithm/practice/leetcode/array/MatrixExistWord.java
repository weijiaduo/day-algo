package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * @since 2022/6/5
 */
public class MatrixExistWord implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        boolean result = exist(board, word);
        System.out.println(result);
        return result;
    }

    public boolean exist(char[][] board, String word) {
        return matrixExist(board, word);
    }

    /**
     * 思路：递归遍历所有情况
     *
     * 看起来很慢啊~~
     *
     * 执行耗时:1514 ms,击败了5.02% 的Java用户
     * 内存消耗:42.2 MB,击败了5.08% 的Java用户
     */
    private boolean setExist(char[][] board, String word) {
        Set<String> keys = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0, keys)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int k, Set<String> keys) {
        if (k >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length) {
            return false;
        }

        String key = i + "_" + j;
        if (keys.contains(key) || board[i][j] != word.charAt(k)) {
            return false;
        }

        keys.add(key);

        if (dfs(board, i + 1, j, word, k + 1, keys)
            || dfs(board, i, j + 1, word, k + 1, keys)
            || dfs(board, i - 1, j, word, k + 1, keys)
            || dfs(board, i, j - 1, word, k + 1, keys)) {
            return true;
        }

        keys.remove(key);
        return false;
    }

    /**
     * 集合换矩阵标记，确实快很多
     *
     * 执行耗时:109 ms,击败了45.61% 的Java用户
     * 存消耗:39.6 MB,击败了51.96% 的Java用户
     */
    private boolean matrixExist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs2(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs2(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        if (k >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length) {
            return false;
        }

        if (visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        visited[i][j] = true;

        if (dfs2(board, i + 1, j, word, k + 1, visited)
                || dfs2(board, i, j + 1, word, k + 1, visited)
                || dfs2(board, i - 1, j, word, k + 1, visited)
                || dfs2(board, i, j - 1, word, k + 1, visited)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

}
