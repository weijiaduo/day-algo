package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉树2
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * <p>
 * @since 2022/6/11
 */
public class GenerateTrees implements Solution<List<TreeNode>> {

    @Override
    public List<TreeNode> solve(Object... args) {
        int n = 2;
        List<TreeNode> result = generateTrees(n);
        for (TreeNode treeNode : result) {
            System.out.println(TreeNode.traverse(treeNode));
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n + 1);
    }

    /**
     * 二分法
     *
     * 思路：遍历不同根节点，二分构造不同左右子树，再遍历左右子树构造不同树
     *
     * 执行耗时:1 ms,击败了97.80% 的Java用户
     * 内存消耗:41.7 MB,击败了73.60% 的Java用户
     */
    private List<TreeNode> dfs(int from, int to) {
        List<TreeNode> roots = new ArrayList<>();
        if (from >= to) {
            roots.add(null);
            return roots;
        }
        for (int i = from; i < to; i++) {
            List<TreeNode> lefts = dfs(from, i);
            List<TreeNode> rights = dfs(i + 1, to);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    roots.add(root);
                }
            }
        }
        return roots;
    }

}
