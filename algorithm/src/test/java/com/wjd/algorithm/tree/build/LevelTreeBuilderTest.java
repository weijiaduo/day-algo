package com.wjd.algorithm.tree.build;

import com.wjd.algorithm.tree.traverse.BuildLevelTraverse;
import com.wjd.structure.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelTreeBuilderTest {

    @Test
    void build() {
        Integer[] values = {1, 3, 2, 5, null, null, 9, 6, null, 7};
        String expect = Arrays.toString(values);

        TreeBuilder<Integer[]> builder = new LevelTreeBuilder();
        TreeNode root = builder.build(values);
        List<Integer> list = TreeNode.bfs(root);
        String actual = String.valueOf(list);

        assertEquals(expect, actual);
    }
}