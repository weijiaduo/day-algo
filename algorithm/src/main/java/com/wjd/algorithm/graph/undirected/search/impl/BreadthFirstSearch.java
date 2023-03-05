package com.wjd.algorithm.graph.undirected.search.impl;

import com.wjd.algorithm.graph.undirected.search.Search;
import com.wjd.structure.graph.undirected.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索
 *
 * @author weijiaduo
 * @since 2023/3/5
 */
public class BreadthFirstSearch implements Search {

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

    public BreadthFirstSearch(Graph g, int s) {
        this.g = g;
        this.s = s;
        marked = new boolean[g.vs()];
        Arrays.fill(marked, false);
        bfs(s);
    }

    /**
     * 广度搜索
     *
     * @param v 当前顶点
     */
    private void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()) {
            int w = queue.poll();
            if (marked[w]) {
                continue;
            }
            
            marked[w] = true;
            count++;
            for (int i : g.adj(w)) {
                if (!marked[i]) {
                    queue.offer(i);
                }
            }
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
