package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 面试题 04.05. 合法二叉搜索树
 * <p>
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * 输出: false
 * <p>
 * 解释: 输入为: [5,1,4,null,null,3,6]。 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author weijiaduo
 * @since 2023/12/21
 */
public class IsValidBST {

    // 上一个遍历节点
    TreeNode prev;

    /**
     * 思路：中序遍历
     * <p>
     * 二叉搜索树的中序遍历是有序的，只要验证这个就行
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了100.00% 的Java用户
     */
    @TestCase(input = {"[2,1,3]", "[5,1,4,null,null,3,6]", "[1,1]"},
            output = {"true", "false", "false"})
    public boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValid(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return isValid(root.right);
    }

    /**
     * 思路：二分递归，把根节点的值作为左右子树的边界，只要左右子树不满足要求，就是非法的
     * <p>
     * 特别需要注意边界值的判断 Integer.MAX_VALUE 和 Integer.MIN_VALUE
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.2 MB,击败了5.47% 的Java用户
     */
    @TestCase(input = {"[2,1,3]", "[5,1,4,null,null,3,6]"},
            output = {"true", "false"})
    public boolean dfs(TreeNode root) {
        return dfs(root, null, null);
    }

    /**
     * 验证树的阈值是否满足条件
     *
     * @param root 当前节点
     * @param low  [low, high]
     * @param high [low, high]
     * @return true/false
     */
    private boolean dfs(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if (low != null && root.val <= low || high != null && root.val >= high) {
            return false;
        }
        return dfs(root.left, low, root.val)
               && dfs(root.right, root.val, high);
    }

}
