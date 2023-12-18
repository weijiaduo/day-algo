package com.wjd.practice.leetcode.tree.validate;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在[1, 10⁴] 内
 * -2³¹ <= Node.val <= 2³¹ - 1
 *
 * @since 2022/6/11
 */
public class IsValidBST {

    /**
     * 思路：二分递归，把根节点的值作为左右子树的边界，只要左右子树不满足要求，就是非法的
     * <p>
     * 特别需要注意边界值的判断 Integer.MAX_VALUE 和 Integer.MIN_VALUE
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了6.16% 的Java用户
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
     * @param low [low, high]
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

    // 上一个遍历节点
    TreeNode pre = null;

    /**
     * 思路：使用中序遍历验证，中序遍历结果是从小打大，则表示是有效的二叉搜索树
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：40.8 MB, 在所有 Java 提交中击败了 89.53% 的用户
     */
    @TestCase(input = {"[2,1,3]", "[5,1,4,null,null,3,6]"},
            output = {"true", "false"})
    public boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!inorder(root.left)) {
            return false;
        }

        if (pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;
        return inorder(root.right);
    }

}
