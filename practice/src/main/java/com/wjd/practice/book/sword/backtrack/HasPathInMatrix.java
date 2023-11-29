package com.wjd.practice.book.sword.backtrack;

import com.wjd.practice.TestCase;

/**
 * 12. 矩阵中的路径
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * <p>
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * <p>
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * <p>
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * <p>
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class HasPathInMatrix {

    /**
     * 思路：回溯，遍历矩阵，对每个元素进行回溯
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     */
    @TestCase(input = {"[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCB",
            "[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]", "ABCCED"},
            output = {"false", "true"})
    public boolean hasPath(char[][] matrix, String path) {
        if (matrix == null || matrix.length == 0 || path == null || path.length() == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(matrix, i, j, visited, path, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯
     *
     * @param matrix  矩阵
     * @param i       行
     * @param j       列
     * @param visited 访问标记
     * @param path    路径
     * @param index   路径索引
     * @return 是否存在路径
     */
    private boolean backtrack(char[][] matrix, int i, int j, boolean[][] visited, String path, int index) {
        if (index == path.length()) {
            return true;
        }

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
            || visited[i][j] || matrix[i][j] != path.charAt(index)) {
            return false;
        }

        // 递归前后，记得恢复现场
        visited[i][j] = true;
        boolean res = backtrack(matrix, i - 1, j, visited, path, index + 1)
                      || backtrack(matrix, i + 1, j, visited, path, index + 1)
                      || backtrack(matrix, i, j - 1, visited, path, index + 1)
                      || backtrack(matrix, i, j + 1, visited, path, index + 1);
        visited[i][j] = false;

        return res;
    }

}
