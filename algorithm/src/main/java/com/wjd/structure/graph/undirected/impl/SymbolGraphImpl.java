package com.wjd.structure.graph.undirected.impl;

import com.wjd.structure.graph.undirected.Graph;
import com.wjd.structure.graph.undirected.SymbolGraph;

import java.util.*;

/**
 * 无向符号图实现
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class SymbolGraphImpl implements SymbolGraph {

    /**
     * 名称->索引
     */
    private final Map<String, Integer> keyMap;
    /**
     * 索引->名称
     */
    private final String[] keys;
    /**
     * 无向图
     */
    private final Graph graph;

    public SymbolGraphImpl(Set<String> keySet) {
        int n = keySet.size();
        keyMap = new HashMap<>();
        this.keys = new String[n];
        int k = 0;
        for (String name : keySet) {
            keyMap.put(name, k);
            this.keys[k++] = name;
        }
        graph = new ListGraph(n);
    }

    @Override
    public boolean contains(String key) {
        return keyMap.containsKey(key);
    }

    @Override
    public int index(String key) {
        return keyMap.getOrDefault(key, -1);
    }

    @Override
    public String key(int index) {
        if (index < 0 || index > keys.length) {
            return null;
        }
        return keys[index];
    }

    @Override
    public Graph graph() {
        return graph;
    }

    @Override
    public void addEdge(String v, String w) {
        graph.addEdge(keyMap.get(v), keyMap.get(w));
    }

    @Override
    public boolean hasEdge(String v, String w) {
        return graph.hasEdge(keyMap.get(v), keyMap.get(w));
    }

    @Override
    public Iterable<String> adj(String v) {
        Iterable<Integer> it = graph().adj(keyMap.get(v));
        List<String> list = new ArrayList<>();
        for (Integer index : it) {
            list.add(keys[index]);
        }
        return list;
    }

}
