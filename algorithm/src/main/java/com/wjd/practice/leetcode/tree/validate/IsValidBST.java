package com.wjd.practice.leetcode.tree.validate;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * <p>
 * 节点的右子树只包含 大于 当前节点的数。
 * <p>
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * <p>
 *
 * @since 2022/6/11
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    /**
     * 二分递归
     * <p>
     * 思路：把根节点的值作为左右子树的边界，只要左右子树不满足要求，就是非法的
     * <p>
     * 特别需要注意边界值的判断 Integer.MAX_VALUE 和 Integer.MIN_VALUE
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了6.16% 的Java用户
     */
    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min || max != null && root.val >= max) {
            return false;
        }
        return isValid(root.left, min, root.val)
                && isValid(root.right, root.val, max);
    }

    TreeNode pre = null;

    /**
     * 思路：使用中序遍历验证，中序遍历结果是从小打大，则表示是有效的二叉搜索树
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：40.8 MB, 在所有 Java 提交中击败了 89.53% 的用户
     *
     * @param root 根节点
     * @return 是否是二叉搜索树
     */
    private boolean inorderValid(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!inorderValid(root.left)) {
            return false;
        }

        if (pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;
        if (!inorderValid(root.right)) {
            return false;
        }

        return true;
    }

}
