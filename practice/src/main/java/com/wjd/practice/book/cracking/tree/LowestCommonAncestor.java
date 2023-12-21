package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 面试题 04.08. 首个共同祖先
 * <p>
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 * <p>
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * //     3
 * //    / \
 * //   5   1
 * //  / \ / \
 * // 6  2 0  8
 * //   / \
 * //  7   4
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * @author weijiaduo
 * @since 2023/12/21
 */
public class LowestCommonAncestor {

    /**
     * 思路：递归
     * <p>
     * 如果两个节点分别位于左右子树，说明当前节点就是首个公共祖先
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:7 ms,击败了32.89% 的Java用户
     * 内存消耗:43.5 MB,击败了5.65% 的Java用户
     */
    @TestCase(input = {"[3,5,1,6,2,0,8,null,null,7,4]", "5", "1",
            "[3,5,1,6,2,0,8,null,null,7,4]", "5", "4"},
            output = {"3", "5"})
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else {
            return l != null ? l : r;
        }
    }

}
