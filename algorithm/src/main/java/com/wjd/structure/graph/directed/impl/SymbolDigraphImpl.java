package com.wjd.structure.graph.directed.impl;

import com.wjd.structure.graph.directed.Digraph;
import com.wjd.structure.graph.directed.SymbolDigraph;

import java.util.*;

/**
 * 符号有向图实现
 *
 * @author weijiaduo
 * @since 2023/3/16
 */
public class SymbolDigraphImpl implements SymbolDigraph {

    /**
     * 名称->索引
     */
    private final Map<String, Integer> keyMap;
    /**
     * 索引->名称
     */
    private final String[] keys;
    /**
     * 有向图
     */
    private final Digraph graph;

    public SymbolDigraphImpl(Set<String> keySet) {
        int n = keySet.size();
        keyMap = new HashMap<>();
        this.keys = new String[n];
        int k = 0;
        for (String name : keySet) {
            keyMap.put(name, k);
            this.keys[k++] = name;
        }
        graph = new ListDigraph(n);
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
        return keys[index];
    }

    @Override
    public Digraph graph() {
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
