package com.wjd.practice.leetcode.matrix;

import com.wjd.practice.leetcode.TestCase;

/**
 * 2352. 相等行列对
 * <p>
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 10⁵
 *
 * @author weijiaduo
 * @since 2023/6/6
 */
public class EqualPairs {

    /**
     * 思路：模拟，遍历矩阵的每个点，以该点为一行一列的交叉点，验证行列是否相等
     * <p>
     * 复杂度：时间 O(n^3) 空间 O(1)
     * <p>
     * 执行耗时:32 ms,击败了59.94% 的Java用户
     * 内存消耗:44.8 MB,击败了98.76% 的Java用户
     *
     * @param grid the grid
     * @return the int
     */
    @TestCase(input = {"[[3,2,1],[1,7,6],[2,7,7]]", "[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]"},
            output = {"1", "3"})
    public int imitate(int[][] grid) {
        int cnt = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (equalPairs(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 指定点的行列是否相等
     *
     * @param grid grid
     * @param i    row index
     * @param j    column index
     * @return true/false
     */
    private boolean equalPairs(int[][] grid, int i, int j) {
        int n = grid.length;
        for (int k = 0; k < n; k++) {
            if (grid[i][k] != grid[k][j]) {
                return false;
            }
        }
        return true;
    }

}
