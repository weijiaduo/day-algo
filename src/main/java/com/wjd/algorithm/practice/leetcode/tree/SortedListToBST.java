package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.ListNode;
import com.wjd.algorithm.practice.leetcode.structure.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 * <p>
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * <p>
 * @since 2022/6/18
 */
public class SortedListToBST implements Solution<TreeNode> {

    @Override
    public TreeNode solve(Object... args) {
        int[] values = {-10,-3,0,5,9};
        ListNode head = ListNode.build(values);
        System.out.println(ListNode.listString(head));
        TreeNode result = inorderSortedListToBST(head);
        System.out.println(TreeNode.bfs(result));
        return result;
    }

    /**
     * 思路：没什么好办法，先把链表转成数组，再用二分递归构建树
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.9 MB,击败了11.68% 的Java用户
     */
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        int[] nums = new int[n];
        n = 0;
        p = head;
        while (p != null) {
            nums[n++] = p.val;
            p = p.next;
        }

        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int from, int to) {
        if (from > to) {
            return null;
        }
        int mid = from + (to - from) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, from, mid - 1);
        root.right = buildTree(nums, mid + 1, to);
        return root;
    }

    ListNode node;

    /**
     * 思路：升序数组就是中序遍历，按照中序遍历顺序构建树即可
     *
     * 这个做法很有意思，之前数组转二叉搜搜树应该也有这个方案，当时没注意
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.5 MB,击败了51.61% 的Java用户
     */
    public TreeNode inorderSortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        node = head;
        return buildTree(0, n - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(0);

        // 构建左子树
        root.left = buildTree(left, mid - 1);

        // 构建根节点
        root.val = node.val;
        // 遍历下一个值
        node = node.next;

        // 构建右子树
        root.right = buildTree(mid + 1, right);
        return root;
    }

}
