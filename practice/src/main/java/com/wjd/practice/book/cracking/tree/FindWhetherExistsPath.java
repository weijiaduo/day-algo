package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.01. 节点间通路
 * <p>
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * <p>
 * 示例2:
 * <p>
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
 * 1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * <p>
 * 提示：
 * <p>
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 *
 * @author weijiaduo
 * @since 2023/12/20
 */
public class FindWhetherExistsPath {

    // 邻接表
    List<List<Integer>> adj;
    // 访问情况
    boolean[] visited;

    /**
     * 思路：深度优先搜索，看能不能找到目标节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:14 ms,击败了56.20% 的Java用户
     * 内存消耗:81.1 MB,击败了100.00% 的Java用户
     */
    @TestCase(input = {"3", "[[0, 1], [0, 2], [1, 2], [1, 2]]", "0", "2",
            "5", "[[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]]", "0", "4"},
            output = {"true", "true"})
    public boolean find(int n, int[][] graph, int start, int target) {
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : graph) {
            adj.get(edge[0]).add(edge[1]);
        }
        visited = new boolean[n];
        return dfs(start, target);
    }

    /**
     * 深度优先搜索
     *
     * @param i      当前节点
     * @param target 目标节点
     * @return true/false
     */
    private boolean dfs(int i, int target) {
        if (i == target) {
            return true;
        }
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        for (int j : adj.get(i)) {
            if (dfs(j, target)) {
                return true;
            }
        }
        return false;
    }

}
