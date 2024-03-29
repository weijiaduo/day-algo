package com.wjd.practice.leetcode.tree.search;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 10⁴
 * 0 <= Node.val <= 10⁴
 *
 * @author weijiaduo
 * @since 2023/6/13
 */
public class KthSmallest {

    // 第 k 个结果值
    int ans = -1;
    // 计数
    int cnt = 0;

    /**
     * 中序遍历，找到第 k 个节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.2 MB,击败了9.26% 的Java用户
     */
    @TestCase(input = {"[3,1,4,null,2]", "1", "[5,3,6,2,4,null,null,1]", "3"},
            output = {"1", "3"})
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (--cnt == 0) {
            ans = root.val;
        }
        inorder(root.right);
    }

    Map<TreeNode, Integer> countMap;

    /**
     * 思路：二分法
     * <p>
     * 记录每个子树的节点数量，和 k 对比
     * <p>
     * 若 n < k，则 k 在右子树
     * <p>
     * 若 n > k，则 k 在左子树
     * <p>
     * 否则，当前节点就是 k
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了9.52% 的Java用户
     * 内存消耗:42.6 MB,击败了96.31% 的Java用户
     */
    @TestCase(input = {"[3,1,4,null,2]", "1", "[5,3,6,2,4,null,null,1]", "3"},
            output = {"1", "3"})
    public int binary(TreeNode root, int k) {
        countMap = new HashMap<>();
        count(root);
        TreeNode h = root;
        while (h != null) {
            int l = countMap.getOrDefault(h.left, 0);
            if (l == k - 1) {
                return h.val;
            }
            if (l >= k) {
                // 在左子树内
                h = h.left;
            } else {
                // 在右子树内
                h = h.right;
                k -= l + 1;
            }
        }
        return -1;
    }

    /**
     * 统计每棵子树的节点数量
     *
     * @param root 当前节点
     * @return 节点数量
     */
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num = 1 + count(root.left) + count(root.right);
        countMap.put(root, num);
        return num;
    }

}
