package com.wjd.algorithm.tree.traverse;

import com.wjd.algorithm.tree.build.LevelTreeBuilder;
import com.wjd.algorithm.tree.build.TreeBuilder;
import com.wjd.structure.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildLevelTraverseTest {

    @Test
    void traverse() {
        Traverse traverse = new BuildLevelTraverse();

        Integer[] values = {1, 3, 2, 5, 3, null, 9};
        String expect = Arrays.toString(values);

        TreeNode root = TreeNode.build(values);
        List<TreeNode> list = traverse.traverse(root);
        String actual = String.valueOf(list);

        assertEquals(expect, actual);
    }
}