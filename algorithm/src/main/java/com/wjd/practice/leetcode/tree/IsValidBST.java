package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
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
 * @since 2022/6/11
 */
public class IsValidBST implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        Integer[] values = {-2147483648,-2147483648};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.traverse(root));
        boolean result = isValidBST(root);
        System.out.println(result);
        return result;
    }

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

}
