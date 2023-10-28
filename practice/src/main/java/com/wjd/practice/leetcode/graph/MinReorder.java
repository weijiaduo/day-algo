package com.wjd.practice.leetcode.graph;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 1466. 重新规划路线
 * <p>
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。
 * <p>
 * 因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。
 * <p>
 * 去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * <p>
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * <p>
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * <p>
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * <p>
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 *
 * @author weijiaduo
 * @since 2023/10/14
 */
public class MinReorder {

    /**
     * 思路：图的深度优先遍历
     * <p>
     * 因为只有 n-1 条边，所以必定是一棵树，不会出现环的问题
     * <p>
     * 先将边构建成邻接表（不能用邻接矩阵，会超出内存限制），然后再去遍历图
     * <p>
     * 从 0 出发，遍历所有边，把所有不指向 0 这边方向的边全都转向
     * <p>
     * 复杂度：时间 O(n) 空间 最坏O(n^2)
     * <p>
     * 执行耗时:39 ms,击败了60.88% 的Java用户
     * 内存消耗:69.4 MB,击败了34.40% 的Java用户
     */
    @TestCase(input = {"6", "[[0,1],[1,3],[2,3],[4,0],[4,5]]",
            "5", "[[1,0],[1,2],[3,2],[3,4]]",
            "3", "[[1,0],[2,0]]"},
            output = {"3", "2", "0"})
    public int dfs(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<int[]>> edges = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] c : connections) {
            edges.get(c[0]).add(new int[]{c[1], 1});
            edges.get(c[1]).add(new int[]{c[0], -1});
        }
        return dfs(0, edges, visited);
    }

    /**
     * 深度优先遍历，返回需修改方向的边数
     *
     * @param i       当前城市
     * @param edges   边
     * @param visited 已访问城市
     * @return 需改变方向的边数
     */
    private int dfs(int i, List<List<int[]>> edges, boolean[] visited) {
        if (visited[i]) {
            return 0;
        }
        int ret = 0;
        visited[i] = true;
        for (int[] edge : edges.get(i)) {
            int j = edge[0];
            int dir = edge[1];
            if (visited[j]) {
                continue;
            }
            if (dir == 1) {
                // 需要更改路线方向
                ret += 1 + dfs(j, edges, visited);
            } else if (dir == -1) {
                // 方向正好
                ret += dfs(j, edges, visited);
            }
        }
        return ret;
    }

}
