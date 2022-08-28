package com.wjd.structure.tree;

import com.wjd.algorithm.tree.build.LevelTreeBuilder;
import com.wjd.algorithm.tree.traverse.BuildLevelTraverse;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 根据广度优先遍历序列（空节点为null）生成树
     */
    public static TreeNode build(Integer[] values) {
        return new LevelTreeBuilder().build(values);
    }

    /**
     * 构建形态的层序遍历
     */
    public static List<Integer> bfs(TreeNode tree) {
        List<TreeNode> nodes = new BuildLevelTraverse().traverse(tree);
        List<Integer> list = new ArrayList<>(nodes.size());
        for (TreeNode node : nodes) {
            if (node == null) {
                list.add(null);
            } else {
                list.add(node.val);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
