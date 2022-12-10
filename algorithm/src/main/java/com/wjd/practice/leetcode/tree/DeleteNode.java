package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * <p>
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * <p>
 * @since 2022/6/2
 */
public class DeleteNode implements Solution<TreeNode> {

    @Override
    public TreeNode solve(Object... args) {
        Integer[] values = {5,3,6,2,4,null,7};
        int key = 7;
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.traverse(root));
        TreeNode result = deleteNode(root, key);
        System.out.println(TreeNode.traverse(result));
        return result;
    }

    /**
     * 思路：找到右子树的最小值，或左子树的最大值，替换删除节点即可
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了33.98% 的Java用户
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // 寻找要删除的节点
        TreeNode parent = null, node = root;
        while (node != null && node.val != key) {
            parent = node;
            if (node.val > key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // 删除节点不存在
        if (node == null) {
            return root;
        }

        // 寻找可替代的节点
        TreeNode replace = null, replaceParent = null;
        if (node.right != null) {
            // 从右子树找最小值
            replaceParent = node;
            replace = replaceParent.right;
            while (replace.left != null) {
                replaceParent = replace;
                replace = replace.left;
            }
        } else if (node.left != null) {
            // 从左子树找最大值
            replaceParent = node;
            replace = replaceParent.left;
            while (replace.right != null) {
                replaceParent = replace;
                replace = replace.right;
            }
        }

        // 交换删除节点
        if (replace != null) {
            // FIXME: 暂时先简单地换个值
            node.val = replace.val;
            node = replace;
            parent = replaceParent;
        }

        // 删除节点
        if (parent == null) {
            // 只有一个根节点，而且被删除了
            root = null;
        } else {
            if (parent.left == node) {
                parent.left = node.right == null ? node.left : node.right;
            } else {
                parent.right = node.left == null ? node.right : node.left;
            }
            node.left = node.right = null;
        }

        return root;
    }

}
