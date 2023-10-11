package com.wjd.practice.leetcode.tree.search;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * <p>
 * 示例 2:
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 数中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 10⁷
 * root 是二叉搜索树
 * 1 <= val <= 10⁷
 *
 * @author weijiaduo
 * @since 2022/12/14
 */
public class SearchBST {

    /**
     * 思路：迭代二叉搜索
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了12.87% 的Java用户
     *
     * @param root 根节点
     * @param val  指定值
     * @return val对应的节点/null
     */
    @TestCase(input = {"[4,2,7,1,3]", "2", "[4,2,7,1,3]", "5"},
            output = {"[2,1,3]", "[]"})
    public TreeNode iterate(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    /**
     * 思路：递归二叉搜索
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43 MB,击败了66.49% 的Java用户
     *
     * @param root 根节点
     * @param val  指定值
     * @return val对应的节点/null
     */
    @TestCase(input = {"[4,2,7,1,3]", "2", "[4,2,7,1,3]", "5"},
            output = {"[2,1,3]", "[]"})
    public TreeNode dfs(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return dfs(root.left, val);
        } else if (val > root.val) {
            return dfs(root.right, val);
        } else {
            return root;
        }
    }

}
