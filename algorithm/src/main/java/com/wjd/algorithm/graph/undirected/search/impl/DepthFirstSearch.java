package com.wjd.algorithm.graph.undirected.search.impl;

import com.wjd.algorithm.graph.undirected.search.Search;
import com.wjd.structure.graph.undirected.Graph;

import java.util.Arrays;

/**
 * 深度优先搜索
 *
 * @author weijiaduo
 * @since 2023/3/5
 */
public class DepthFirstSearch implements Search {

    /**
     * 搜索的无向图
     */
    private final Graph g;

    /**
     * 搜索起始顶点
     */
    private final int s;
    /**
     * 标记数组
     */
    private final boolean[] marked;
    /**
     * 遍历到的顶点数量
     */
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        this.g = g;
        this.s = s;
        marked = new boolean[g.vs()];
        Arrays.fill(marked, false);
        dfs(s);
    }

    /**
     * 深度搜索
     *
     * @param v 当前顶点
     */
    private void dfs(int v) {
        if (marked[v]) {
            return;
        }

        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            dfs(w);
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }

}
