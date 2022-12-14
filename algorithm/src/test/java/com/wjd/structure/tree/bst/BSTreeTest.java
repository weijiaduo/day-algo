package com.wjd.structure.tree.bst;

import com.wjd.algorithm.tree.binary.traverse.InorderTraverse;
import com.wjd.structure.tree.binary.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BSTreeTest {

    @Test
    void testInit() {
        int caseSize = 1000;
        Random random = new Random();
        for (int i = 0; i < caseSize; i++) {
            Set<Integer> existSet = new HashSet<>();
            int size = 50 + random.nextInt(150);
            int[] values = new int[size];
            for (int j = 0; j < size; j++) {
                values[j] = random.nextInt(1000);
                existSet.add(values[j]);
            }
            BSTreeImpl bsTree = new BSTreeImpl(values);

            // 中序遍历整棵树，看是否是有序的
            InorderTraverse traverse = new InorderTraverse();
            List<TreeNode> inorder = traverse.traverse(bsTree.getRoot());
            int prev = inorder.get(0).val;
            for (int k = 1; k < inorder.size(); k++) {
                int cur = inorder.get(k).val;
                assertTrue(cur > prev);
                assertTrue(existSet.contains(cur));
                prev = cur;
            }

            // 验证元素值是否完整
            Set<Integer> valueSet = new HashSet<>();
            for (TreeNode node : inorder) {
                valueSet.add(node.val);
            }
            assertEquals(valueSet.size(), existSet.size());
            assertTrue(valueSet.containsAll(existSet));
        }
    }

    @Test
    void testQuery() {
        int caseSize = 1000;
        Random random = new Random();
        for (int i = 0; i < caseSize; i++) {
            Set<Integer> existSet = new HashSet<>();
            int size = 50 + random.nextInt(150);
            int[] values = new int[size];
            for (int j = 0; j < size; j++) {
                values[j] = random.nextInt(1000);
                existSet.add(values[j]);
            }
            BSTreeImpl bsTree = new BSTreeImpl(values);

            // 随机验证节点是否存在
            int testSize = 50 + random.nextInt(50);
            for (int j = 0; j < testSize; j++) {
                int val = random.nextInt(1000);
                TreeNode node = bsTree.query(val);
                assertEquals(existSet.contains(val), node != null);
                if (node != null) {
                    assertEquals(val, node.val);
                }
            }
        }
    }

    @Test
    void testDelete() {
        int caseSize = 1000;
        Random random = new Random();
        for (int i = 0; i < caseSize; i++) {
            Set<Integer> existSet = new HashSet<>();
            int size = 50 + random.nextInt(150);
            int[] values = new int[size];
            for (int j = 0; j < size; j++) {
                values[j] = random.nextInt(1000);
                existSet.add(values[j]);
            }
            BSTreeImpl bsTree = new BSTreeImpl(values);

            // 随机验证节点是否删除成功
            int testSize = 50 + random.nextInt(50);
            for (int j = 0; j < testSize; j++) {
                int val = random.nextInt(1000);
                TreeNode node = bsTree.delete(val);
                assertEquals(existSet.contains(val), node != null);
                assertNull(bsTree.query(val));
                existSet.remove(val);
            }
        }
    }

    @Test
    void testInsert() {
        int caseSize = 1000;
        Random random = new Random();
        for (int i = 0; i < caseSize; i++) {
            Set<Integer> existSet = new HashSet<>();
            int size = 50 + random.nextInt(150);
            int[] values = new int[size];
            for (int j = 0; j < size; j++) {
                values[j] = random.nextInt(1000);
                existSet.add(values[j]);
            }
            BSTreeImpl bsTree = new BSTreeImpl(values);

            // 随机验证节点是否插入成功
            int testSize = 50 + random.nextInt(50);
            for (int j = 0; j < testSize; j++) {
                int val = random.nextInt(1000);
                TreeNode node = bsTree.insert(val);
                assertEquals(existSet.contains(val), node == null);
                if (node != null) {
                    existSet.add(val);
                    assertEquals(val, node.val);
                }
            }

            // 中序遍历整棵树，看是否是有序的
            InorderTraverse traverse = new InorderTraverse();
            List<TreeNode> preorder = traverse.traverse(bsTree.getRoot());
            int prev = preorder.get(0).val;
            for (int k = 1; k < preorder.size(); k++) {
                int cur = preorder.get(k).val;
                assertTrue(cur > prev);
                prev = cur;
            }
        }
    }
}