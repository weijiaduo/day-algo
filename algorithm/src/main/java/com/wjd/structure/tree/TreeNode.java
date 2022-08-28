package com.wjd.structure.tree;

import com.wjd.algorithm.tree.build.LevelTreeBuilder;
import com.wjd.algorithm.tree.traverse.BuildLevelTraverse;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树节点
 */
public class TreeNode {

    /**
     * 节点值
     */
    public int val;
    /**
     * 左子节点
     */
    public TreeNode left;
    /**
     * 右子节点
     */
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 根据层序遍历序列（空节点为null）生成树
     */
    public static TreeNode build(Integer[] values) {
        return new LevelTreeBuilder().build(values);
    }

    /**
     * 根据层序遍历序列（空节点为null）生成树
     */
    public static TreeNode build(List<Integer> list) {
        Integer[] values = list.toArray(new Integer[0]);
        return new LevelTreeBuilder().build(values);
    }

    /**
     * 构建形态的层序遍历
     */
    public static List<Integer> traverse(TreeNode tree) {
        List<TreeNode> nodes = new BuildLevelTraverse().traverse(tree);
        List<Integer> list = new ArrayList<>(nodes.size());
        for (TreeNode node : nodes) {
            list.add(node != null ? node.val : null);
        }
        return list;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
