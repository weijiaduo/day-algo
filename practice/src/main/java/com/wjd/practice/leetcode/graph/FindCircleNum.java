package com.wjd.practice.leetcode.graph;

import com.wjd.practice.TestCase;

/**
 * 547. 省份数量
 * <p>
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。
 * <p>
 * 如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * <p>
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 * @author weijiaduo
 * @since 2023/10/12
 */
public class FindCircleNum {

    /**
     * 思路：深度优先遍历，
     * <p>
     * 一次遍历到的城市都属于同一个省份
     * <p>
     * 不同次遍历的城市则是不同省份
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.27% 的Java用户
     * 内存消耗:44.7 MB,击败了78.87% 的Java用户
     */
    @TestCase(input = {"[[1,1,0],[1,1,0],[0,0,1]]",
            "[[1,0,0],[0,1,0],[0,0,1]]",
            "[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]"},
            output = {"2", "3", "1"})
    public int dfs(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                ans++;
            }
        }
        return ans;
    }

    /**
     * 深度优先遍历
     *
     * @param i           城市 i
     * @param isConnected 连接关系
     * @param visited     是否已访问
     */
    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        int n = isConnected.length;
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, isConnected, visited);
            }
        }
    }

}
