package com.wjd.algorithm.tree.general.build;

import com.wjd.algorithm.tree.general.traverse.BuildLevelGeneralTraverse;
import com.wjd.structure.tree.general.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelGeneralBuilderTest {

    @Test
    void testBuild() {
        Integer[] values = {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};
        String expect = Arrays.toString(values);

        LevelGeneralBuilder builder = new LevelGeneralBuilder();
        Node tree = builder.build(values);
        List<Node> list = new BuildLevelGeneralTraverse().traverse(tree);
        String actual = String.valueOf(list);

        System.out.println(actual);
        assertEquals(expect, actual);
    }
}