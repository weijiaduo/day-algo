package com.wjd.algorithm.graph.directed.build.impl;

import com.wjd.algorithm.graph.directed.build.DigraphBuilder;
import com.wjd.structure.graph.directed.Digraph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileDigraphBuilderTest {

    @Test
    void build() {
        DigraphBuilder builder = new FileDigraphBuilder("tinyG.txt");
        Digraph dg = builder.build();

        assertEquals(13, dg.vs());
        assertEquals(13, dg.es());

        Iterable<Integer> it = dg.adj(0);
        List<Integer> actual = new ArrayList<>();
        for (int i : it) {
            actual.add(i);
        }
        Collections.sort(actual);
        assertEquals("[1, 2, 5, 6]", actual.toString());

        it = dg.adj(4);
        actual = new ArrayList<>();
        for (int i : it) {
            actual.add(i);
        }
        Collections.sort(actual);
        assertEquals("[3]", actual.toString());

        it = dg.adj(9);
        actual = new ArrayList<>();
        for (int i : it) {
            actual.add(i);
        }
        Collections.sort(actual);
        assertEquals("[10, 11, 12]", actual.toString());

        it = dg.adj(7);
        actual = new ArrayList<>();
        for (int i : it) {
            actual.add(i);
        }
        Collections.sort(actual);
        assertEquals("[8]", actual.toString());
    }
}