package com.wjd.practice.leetcode.matrix;

/**
 * 1254. 统计封闭岛屿的数目
 * <p>
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。
 * <p>
 * 岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
 * 0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 * @author weijiaduo
 * @since 2023/6/18
 */
public class ClosedIsland {

    /**
     * 思路：模拟，从0出发，深度优先遍历，将所有相关的0都改成-1
     * <p>
     * 遍历过程中，如果碰到了矩阵的边界，说明不是封闭岛屿，反之则是封闭岛屿
     * <p>
     * 复杂度：时间 O(mn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了70.69% 的Java用户
     */
    public int closedIsland(int[][] grid) {
        int cnt = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 深度优先遍历
     *
     * @return 是否触碰到了边界
     */
    private boolean dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (grid[i][j] != 0) {
            return true;
        }
        grid[i][j] = -1;
        boolean l = dfs(grid, i, j - 1);
        boolean u = dfs(grid, i - 1, j);
        boolean r = dfs(grid, i, j + 1);
        boolean b = dfs(grid, i + 1, j);
        return l && u && r && b;
    }

}
