package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.LinkedList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthTreeNode {

    @TestCase(input = {"[5, 3, 7, 2, 4, 6, 8]", "3"},
            output = "4")
    public TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot != null && k > 0) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode cur = pRoot;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    if (--k == 0) {
                        return cur;
                    }
                    cur = cur.right;
                }
            }
        }
        return null;
    }

}
