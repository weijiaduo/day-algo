package com.wjd.practice.leetcode.array.traversal;

import com.wjd.practice.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * <p>
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * <p>
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 * @since 2022/6/5
 */
public class MatrixExistWord {

    /**
     * 思路：递归遍历所有情况
     * <p>
     * 复杂度：时间 O(mn*mn) 空间 O(m+n)
     * <p>
     * 执行耗时:1514 ms,击败了5.02% 的Java用户
     * 内存消耗:42.2 MB,击败了5.08% 的Java用户
     * <p>
     * 看起来很慢啊~~
     */
    @TestCase(input = {"[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCCED",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "SEE",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCB"},
            output = {"true", "true", "false"})
    public boolean setExist(char[][] board, String word) {
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
     * 思路：集合换矩阵标记（确实快了很多）
     * <p>
     * 复杂度：时间 O(mn*mn) 空间 O(mn)
     * <p>
     * 执行耗时:109 ms,击败了45.61% 的Java用户
     * 存消耗:39.6 MB,击败了51.96% 的Java用户
     */
    @TestCase(input = {"[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCCED",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "SEE",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCB"},
            output = {"true", "true", "false"})
    public boolean matrixExist(char[][] board, String word) {
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
