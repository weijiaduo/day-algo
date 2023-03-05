package com.wjd.algorithm.graph.undirected.cycle.impl;

import com.wjd.algorithm.graph.undirected.build.impl.FileGraphBuilder;
import com.wjd.algorithm.graph.undirected.cycle.Cycle;
import com.wjd.structure.graph.undirected.Graph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CycleImplTest {

    @Test
    void hasCycle() {
        Graph g = new FileGraphBuilder("tinyG.txt").build();
        Cycle cycle = new CycleImpl(g);
        assertTrue(cycle.hasCycle());
    }

    @Test
    void cycle() {
        Graph g = new FileGraphBuilder("tinyG.txt").build();
        Cycle cycle = new CycleImpl(g);

        List<Integer> actual = new ArrayList<>();
        for (int v : cycle.cycle()) {
            actual.add(v);
        }
        assertEquals("[5, 4, 3]", actual.toString());
    }

}