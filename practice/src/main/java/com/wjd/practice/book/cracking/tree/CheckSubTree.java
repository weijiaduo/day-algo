package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 面试题 04.10. 检查子树
 * <p>
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。
 * <p>
 * 设计一个算法，判断 T2 是否为 T1 的子树。
 * <p>
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，
 * <p>
 * 也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * <p>
 * 注意：此题相对书上原题略有改动。
 * <p>
 * 示例1:
 * <p>
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 * <p>
 * 示例2:
 * <p>
 * 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 树的节点数目范围为[0, 20000]。
 *
 * @author weijiaduo
 * @since 2023/12/21
 */
public class CheckSubTree {

    /**
     * 思路：递归
     * <p>
     * 在 t1 树中不断递归判断 t2 是否是相同子树
     * <p>
     * 复杂度：时间 O(mn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.1 MB,击败了13.61% 的Java用户
     *
     * @param t1 大树
     * @param t2 小树
     * @return true/false
     */
    @TestCase(input = {"[1,2,3]", "[2]", "[1,null,2,4]", "[3,2]"},
            output = {"true", "false"})
    public boolean check(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val && equals(t1, t2)) {
            return true;
        }
        return check(t1.left, t2) || check(t1.right, t2);
    }

    /**
     * 检查两棵树是否相同
     *
     * @param t1 树1
     * @param t2 树2
     * @return true/false
     */
    private boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }

}
