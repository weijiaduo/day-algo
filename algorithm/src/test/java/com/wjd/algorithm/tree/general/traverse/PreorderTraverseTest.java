package com.wjd.algorithm.tree.general.traverse;

import com.wjd.structure.tree.general.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PreorderTraverseTest {

    @Test
    void testRecursiveTraverse() {
        Integer[] values = {1, null, 3, 2, 4, null, 5, 6};
        Integer[] expectArr = {1, 3, 5, 6, 2, 4};
        String expect = Arrays.toString(expectArr);

        Node tree = Node.build(values);
        List<Node> list = new PreorderTraverse().traverse(tree);
        String actual = String.valueOf(list);

        assertEquals(expect, actual);
    }

    @Test
    void testIterate() {
        Integer[] values = {1, null, 3, 2, 4, null, 5, 6};
        Integer[] expectArr = {1, 3, 5, 6, 2, 4};
        String expect = Arrays.toString(expectArr);

        PreorderTraverse traverse = new PreorderTraverse();
        traverse.setType(2);
        Node tree = Node.build(values);
        List<Node> list = traverse.traverse(tree);
        String actual = String.valueOf(list);

        assertEquals(expect, actual);
    }

}