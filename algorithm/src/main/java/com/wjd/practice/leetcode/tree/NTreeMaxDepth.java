package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.general.Node;

/**
 * 559. N 叉树的最大深度
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 *
 * @author weijiaduo
 * @since 2022/12/10
 */
public class NTreeMaxDepth {

    public int solve(Node root) {
        return dfs(root);
    }

    /**
     * 思路：递归返回最大深度即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了5.20% 的Java用户
     *
     * @param root 树根节点
     * @return 最大深度
     */
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;
        if (root.children != null) {
            for (Node child : root.children) {
                depth = Math.max(dfs(child) + 1, depth);
            }
        }
        return depth;
    }

}
