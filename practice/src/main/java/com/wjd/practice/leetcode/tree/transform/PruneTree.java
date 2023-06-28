package com.wjd.practice.leetcode.tree.transform;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 814. 二叉树剪枝
 * <p>
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 *
 * @author weijiaduo
 * @since 2022/7/21
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    /**
     * 思路：深度优先遍历，先判断子树是否有1
     * <p>
     * 复杂度：时间 O(n) 空间 O(h)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了20.56% 的Java用户
     *
     * @param root 根节点
     * @return 根节点，或null表示删除该节点
     */
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

}
