package com.wjd.algorithm.tree.btree.build;

import com.wjd.algorithm.tree.btree.traverse.BTreeLevelTraverse;
import com.wjd.structure.tree.btree.BTNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BTreeLevelBuilderTest {

    @Test
    void testBuild() {
        List<List<Integer>> expect = Arrays.asList(
                Arrays.asList(21, 22),
                Arrays.asList(11, 12),
                null,
                Arrays.asList(31, 32, 33),
                Arrays.asList(1, 2)
        );

        BTNode<Integer, Integer> root = new BTreeLevelBuilder().build(expect);
        List<List<Integer>> actual = new BTreeLevelTraverse<Integer, Integer>().traverse(root);
        System.out.println(actual);

        assertEquals(expect.toString(), actual.toString());
    }

}