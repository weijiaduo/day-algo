package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 * <p>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * <p>
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 * <p>
 * 若最底层为第 h 层，则该层包含 1~ 2ʰ 个节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是[0, 5 * 10⁴]
 * 0 <= Node.val <= 5 * 10⁴
 * 题目数据保证输入的树是 完全二叉树
 * <p>
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 *
 * @author weijiaduo
 * @since 2023/11/7
 */
public class CountNodes {

    /**
     * 思路：深度遍历，返回每棵子树的节点数量
     * <p>
     * 复杂度：时间 O(n) 空间 O(h)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.7 MB,击败了55.18% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5,6]", "[1]"},
            output = {"6", "1"})
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root.left) + dfs(root.right) + 1;
    }

    /**
     * 思路：排除法，计算左右子树的最大高度
     * <p>
     * 若左子树高度 == 右子树高度，则左子树是满二叉树
     * <p>
     * 若左子树高度 != 右子树高度，则右子树是满二叉树
     * <p>
     * 每一轮可以排除一半的节点数量，总轮数是 O(logn)
     * <p>
     * 但是每一轮都需要计算高度，高度统计需要 O(logn)，所以总复杂度是 O(log^2n)
     * <p>
     * 复杂度：时间 O(log^2n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.8 MB,击败了32.44% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5,6]", "[1]"},
            output = {"6", "1"})
    public int exclude(TreeNode root) {
        int sum = 0;
        TreeNode h = root;
        while (h != null) {
            TreeNode l = h.left, r = h.right;
            int lh = 0, rh = 0;
            while (l != null) {
                lh++;
                l = l.left;
            }
            while (r != null) {
                rh++;
                r = r.left;
            }
            if (lh == rh) {
                // 左子树是满二叉树
                // 排除节点数量 = 左子树节点数 + 根节点
                sum += 1 << lh;
                // 接下来计算右子树节点数量
                h = h.right;
            } else {
                // 右子树是满二叉树
                // 排除节点数量 = 右子树节点数 + 根节点
                sum += 1 << rh;
                // 接下来计算左子树节点数量
                h = h.left;
            }
        }
        return sum;
    }

    /**
     * 思路：排除法，减少遍历次数，左子树的高度不需要每一轮都计算
     * <p>
     * 复杂度：时间 O(log^2n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.8 MB,击败了26.85% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5,6]", "[1]"},
            output = {"6", "1"})
    public int exclude2(TreeNode root) {
        int sum = 0;
        int lh = 0, rh = 0;
        boolean first = true;
        TreeNode h = root;
        while (h != null) {
            TreeNode l = h.left, r = h.right;
            // lh 不用每一轮都遍历，可以通过上一轮算出
            while (first && l != null) {
                lh++;
                l = l.left;
            }
            while (r != null) {
                rh++;
                r = r.left;
            }
            if (lh == rh) {
                // 左子树是满二叉树
                // 排除节点数量 = 左子树节点数 + 根节点
                sum += 1 << lh;
                // 接下来计算右子树节点数量
                lh = rh - 1;
                rh = 0;
                h = h.right;
            } else {
                // 右子树是满二叉树
                // 排除节点数量 = 右子树节点数 + 根节点
                sum += 1 << rh;
                // 接下来计算左子树节点数量
                lh--;
                rh = 0;
                h = h.left;
            }
            first = false;
        }
        return sum;
    }

}
