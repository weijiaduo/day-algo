package com.wjd.practice.leetcode.tree.build;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * <p>
 * 请你构造并返回这颗 二叉树 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * <p>
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * 提示:
 * <p>
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 * @since 2022/6/16
 */
public class BuildTreeFromPostorderAndInorder {

    @TestCase(input = {"[9,3,15,20,7]", "[9,15,7,20,3]",
            "[-1]", "[-1]"},
            output = {"[3,9,20,null,null,15,7]", "[-1]"})
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length, inorder, 0, inorder.length);
    }

    /**
     * 思路：递归构造二叉树
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了59.03% 的Java用户
     * 内存消耗:41.4 MB,击败了14.21% 的Java用户
     * <p>
     * 比想象中要慢啊
     */
    private TreeNode build(int[] postorder, int f1, int t1, int[] inorder, int f2, int t2) {
        if (f1 >= t1) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[t1 - 1]);
        int index = f2;
        while (inorder[index] != postorder[t1 - 1]) {
            index++;
        }
        int leftNum = index - f2;
        root.left = build(postorder, f1, f1 + leftNum, inorder, f2, index);
        root.right = build(postorder, f1 + leftNum, t1 - 1, inorder, index + 1, t2);
        return root;
    }

}
