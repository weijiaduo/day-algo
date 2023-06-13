package com.wjd.practice.leetcode.tree.path;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * <p>
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 10⁵] 内。
 * -10⁹ <= Node.val <= 10⁹
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * @author weijiaduo
 * @since 2023/6/14
 */
public class LowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return path(root, p, q);
        return dfs(root, p, q);
    }

    /**
     * 思路：深度优先遍历，如果 p，q 刚好位于不同子树中，说明根节点就是最近公共祖先
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:6 ms,击败了99.90% 的Java用户
     * 内存消耗:42.5 MB,击败了58.84% 的Java用户
     */
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 找到了对应的节点
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // 递归左右子树，寻找节点
        TreeNode l = dfs(root.left, p, q);
        TreeNode r = dfs(root.right, p, q);

        if (l != null && r != null) {
            // p,q 位于不同子树中，说明 root 就是最近公共祖先
            return root;
        } else {
            // p,q 位于同一棵子树中
            return l != null ? l : r;
        }
    }

    /**
     * 思路：先找出两个节点的从根节点出发的路径，然后再判断相同节点即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:9 ms,击败了15.08% 的Java用户
     * 内存消耗:44.4 MB,击败了5.01% 的Java用户
     */
    private TreeNode path(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = path(root, p);
        List<TreeNode> path2 = path(root, q);
        TreeNode ancestor = root;
        Iterator<TreeNode> it1 = path1.iterator();
        Iterator<TreeNode> it2 = path2.iterator();
        int n = Math.min(path1.size(), path2.size());
        for (int i = 0; i < n; i++) {
            TreeNode pt = it1.next();
            TreeNode qt = it2.next();
            if (pt.val == qt.val) {
                ancestor = pt;
            }
        }
        return ancestor;
    }

    /**
     * 查找从根节点到指定节点的路径
     */
    private List<TreeNode> path(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            List<TreeNode> ret = new LinkedList<>();
            ret.add(root);
            return ret;
        }
        List<TreeNode> lp = path(root.left, p);
        if (lp != null) {
            lp.add(0, root);
            return lp;
        }
        List<TreeNode> rp = path(root.right, p);
        if (rp != null) {
            rp.add(0, root);
            return rp;
        }
        return null;
    }

}
