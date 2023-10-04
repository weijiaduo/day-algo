package com.wjd.practice.leetcode.matrix;

import com.wjd.practice.leetcode.TestCase;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * @author weijiaduo
 * @since 2022/9/28
 */
public class NumIslands {

    /**
     * 思路：深度遍历，把属于同一个岛屿的都遍历过一遍
     * <p>
     * 复杂度：时间 O(mn) 空间 O(m + n)
     * <p>
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:50.1 MB,击败了18.11% 的Java用户
     */
    @TestCase(input = {"[['1','1','1','1','0'],['1','1','0','1','0'],['1','1','0','0','0'],['0','0','0','0','0']]"
            , "[['1','1','0','0','0'],['1','1','0','0','0'],['0','0','1','0','0'],['0','0','0','1','1']]"},
            output = {"1", "3"})
    public int dfsNumIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    /**
     * 深度优先遍历
     */
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        // 更新值
        grid[i][j] = 2;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 思路：并查集，不同岛屿属于不同集合
     * <p>
     * 执行耗时:8 ms,击败了6.58% 的Java用户
     * 内存消耗:49.9 MB,击败了41.08% 的Java用户
     */
    @TestCase(input = {"[['1','1','1','1','0'],['1','1','0','1','0'],['1','1','0','0','0'],['0','0','0','0','0']]"
            , "[['1','1','0','0','0'],['1','1','0','0','0'],['0','0','1','0','0'],['0','0','0','1','1']]"},
            output = {"1", "3"})
    public int unionFind(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int count = m * n + 1;
        // 哨兵子集，用于合并 0 的元素
        int dummy = count - 1;

        // 初始化并查集
        ArrayUnionFind unionFind = new ArrayUnionFind(count);

        // 合并子集合
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (grid[i][j] == '0') {
                    unionFind.union(idx, dummy);
                    continue;
                }

                grid[i][j] = '0';
                if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                    unionFind.union(idx, (i - 1) * n + j);
                }
                if (i + 1 < m && grid[i + 1][j] == '1') {
                    unionFind.union(idx, (i + 1) * n + j);
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    unionFind.union(idx, i * n + j - 1);
                }
                if (j + 1 < n && grid[i][j + 1] == '1') {
                    unionFind.union(idx, i * n + j + 1);
                }
            }
        }

        // 减去哨兵子集合
        return unionFind.getCount() - 1;
    }

    /**
     * 并查集
     */
    static class ArrayUnionFind {

        /**
         * 父节点存储
         */
        private int[] parent;
        /**
         * 节点深度
         */
        private int[] rank;

        /**
         * 不同子集数量
         */
        int count;

        public ArrayUnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            init(n);
        }

        /**
         * 初始化并查集
         */
        private void init(int n) {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            count = n;
        }

        /**
         * 查找元素
         */
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                // 路径压缩，会导致 rank 有误差
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        /**
         * 合并元素子集合
         */
        public void union(int x1, int x2) {
            int root1 = find(x1);
            int root2 = find(x2);
            if (root1 == root2) {
                return;
            }

            // 按秩合并
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                // 深度一样的时候，合并起来会加深一层
                parent[root2] = root1;
                rank[root1]++;
            }
            count--;
        }

        /**
         * 不同子集数量
         */
        public int getCount() {
            return count;
        }

    }

}
