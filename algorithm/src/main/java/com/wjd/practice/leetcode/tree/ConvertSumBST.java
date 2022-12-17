package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * <p>
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * <p>
 * 节点的右子树仅包含键 大于 节点键的节点。
 * <p>
 * 左右子树也必须是二叉搜索树。
 * <p>
 * <p>
 * 注意：本题和 1038: https:leetcode-cn.com/problems/binary-search-tree-to-greater-
 * sum-tree/ 相同
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * @author weijiaduo
 * @since 2022/12/17
 */
public class ConvertSumBST {

    /**
     * 思路：倒着使用中序遍历，按右-中-左遍历，递归返回后面的累加值
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了10.11% 的Java用户
     *
     * @param root 根节点
     * @return 根节点
     */
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root, 0);
        return root;
    }

    /**
     * 倒序的中序遍历
     *
     * @param root    根节点
     * @param nextSum 后面节点的总和
     */
    private int reverseInorder(TreeNode root, int nextSum) {
        if (root == null) {
            return nextSum;
        }

        root.val += reverseInorder(root.right, nextSum);
        return reverseInorder(root.left, root.val);
    }

}
