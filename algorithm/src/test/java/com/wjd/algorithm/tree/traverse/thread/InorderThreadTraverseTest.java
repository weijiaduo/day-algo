package com.wjd.algorithm.tree.traverse.thread;

import com.wjd.algorithm.tree.traverse.InorderTraverse;
import com.wjd.structure.tree.TreeNode;
import com.wjd.structure.tree.thread.ThreadTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InorderThreadTraverseTest {

    @Test
    public void testThreadTree() {
        Integer[] values = {1, null, 2, 3};
        TreeNode root = TreeNode.build(values);
        List<TreeNode> list = new InorderTraverse().traverse(root);
        String expect = String.valueOf(list);

        List<ThreadTreeNode> list2 = new ArrayList<>();
        ThreadTraverse traverse = new InorderThreadTraverse(root);
        for (ThreadTreeNode p = traverse.first(); p != null; p = traverse.next()) {
            list2.add(p);
        }
        String actual = String.valueOf(list2);
        System.out.println(actual);

        assertEquals(expect, actual);
    }

}