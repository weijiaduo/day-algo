package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 54. 二叉搜索树的第 k 个结点
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * <p>
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class KthNodeInBST {

    /**
     * 思路：中序遍历，第 k 个结点就是第 k 小的结点
     * <p>
     * 使用栈保存遍历过程中的结点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"[5, 3, 7, 2, 4, 6, 8]", "1",
            "[5, 3, 7, 2, 4, 6, 8]", "7",
            "[5, 3, 7, 2, 4, 6, 8]", "3"},
            output = {"2", "8", "4"})
    public TreeNode kthNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 保存现场，先遍历左节点
                stack.push(cur);
                cur = cur.left;
            } else {
                // 遍历父节点
                cur = stack.pop();
                if (--k == 0) {
                    return cur;
                }
                // 遍历右节点
                cur = cur.right;
            }
        }
        return null;
    }

}
