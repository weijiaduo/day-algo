package com.wjd.practice.leetcode.tree;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

/**
 * 100. 相同的树
 * <p>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * @since 2022/6/11
 */
public class IsSameTree implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        Integer[] values1 = {1,2,1};
        Integer[] values2 = {1,1,2};
        TreeNode p = TreeNode.build(values1);
        TreeNode q = TreeNode.build(values2);
        System.out.println(TreeNode.bfs(p));
        System.out.println(TreeNode.bfs(q));
        boolean result = isSameTree(p, q);
        System.out.println(result);
        return result;
    }

    /**
     * 深度遍历
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.9 MB,击败了50.76% 的Java用户
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
