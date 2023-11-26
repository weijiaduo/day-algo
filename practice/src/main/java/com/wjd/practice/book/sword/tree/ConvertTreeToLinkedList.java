package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 36. 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * <p>
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class ConvertTreeToLinkedList {

    /**
     * 链表头节点
     */
    private TreeNode head = null;
    /**
     * 上一个遍历的节点
     */
    private TreeNode prev = null;

    /**
     * 思路：中序遍历的结果就是有序的
     * <p>
     * 在中序遍历过程中，将上一个遍历的节点的右指针指向当前节点，当前节点的左指针指向上一个节点
     * <p>
     * 从而将二叉搜索树转换成一个排序的双向链表
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     */
    public TreeNode convert(TreeNode root) {
        convertTo(root);
        return head;
    }

    private void convertTo(TreeNode root) {
        if (root == null) {
            return;
        }

        convertTo(root.left);
        // 当前节点的左指针指向上一个节点
        root.left = prev;
        if (prev != null) {
            // 上一个节点的右指针指向当前节点
            prev.right = root;
        } else {
            // 第一个节点
            head = root;
        }
        prev = root;
        convertTo(root.right);
    }

    @TestCase(input = "[10,6,14,4,8,12,16]",
            output = "[4,6,8,10,12,14,16]")
    public List<Integer> test(TreeNode root) {
        TreeNode head = convert(root);
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.right;
        }
        return res;
    }

}
