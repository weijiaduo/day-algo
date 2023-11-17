package com.wjd.practice.leetcode.backtrack;

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

    private static final int[][] DIR = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    char[][] board;
    int m, n;
    Set<Integer> keys;
    boolean[][] visited;


    /**
     * 思路：递归遍历所有情况
     * <p>
     * 复杂度：时间 O(mn*mn) 空间 O(m+n)
     * <p>
     * 执行耗时:552 ms,击败了5.00% 的Java用户
     * 内存消耗:42.9 MB,击败了12.38% 的Java用户
     * <p>
     * 看起来很慢啊~~
     */
    @TestCase(input = {"[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCCED",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "SEE",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCB"},
            output = {"true", "true", "false"})
    public boolean setExist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        keys = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, String word, int k) {
        if (k >= word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        int key = i * n + j;
        if (keys.contains(key) || board[i][j] != word.charAt(k)) {
            return false;
        }

        keys.add(key);
        for (int[] dir : DIR) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (dfs(ni, nj, word, k + 1)) {
                return true;
            }
        }
        keys.remove(key);
        return false;
    }

    /**
     * 思路：集合换矩阵标记（确实快了很多）
     * <p>
     * 复杂度：时间 O(mn*mn) 空间 O(mn)
     * <p>
     * 执行耗时:171 ms,击败了46.74% 的Java用户
     * 内存消耗:39.6 MB,击败了37.31% 的Java用户
     */
    @TestCase(input = {"[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCCED",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "SEE",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCB"},
            output = {"true", "true", "false"})
    public boolean matrixExist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs2(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs2(int i, int j, String word, int k) {
        if (k >= word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        if (visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        visited[i][j] = true;
        for (int[] dir : DIR) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (dfs2(ni, nj, word, k + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

}
