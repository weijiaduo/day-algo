package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * <p>
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 向树中插入一个值为 Node.val == val的新节点 TreeNode。
 * 使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 * <p>
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 * <p>
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 *
 * @author weijiaduo
 * @since 2022/7/25
 */
public class CBTInserter implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        Integer[] values = {1, 2};
        TreeNode root = TreeNode.build(values);
        CBTInserter cbtInserter = new CBTInserter(root);
        System.out.println(cbtInserter.insert(3));
        System.out.println(cbtInserter.insert(4));
        System.out.println(TreeNode.bfs(cbtInserter.getRoot()));
        return null;
    }

    List<TreeNode> nodes = new ArrayList<>();
    TreeNode root;

    /**
     * 思路：使用数组刚好用作完全二叉树的实现，直接计算父索引
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行耗时:13 ms,击败了99.57% 的Java用户
     * 内存消耗:42.1 MB,击败了39.23% 的Java用户
     *
     * @param root 根节点
     */
    public CBTInserter(TreeNode root) {
        this.root = root;
        this.bfs();
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        nodes.add(newNode);
        TreeNode parent = nodes.get(nodes.size() / 2 - 1);
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return parent.val;
    }

    public TreeNode getRoot() {
        return root;
    }

    private void bfs() {
        TreeNode node = root;
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                nodes.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

}
