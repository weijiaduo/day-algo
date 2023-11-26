package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 32.1 从上往下打印二叉树
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class PrintTreeFromTopToBottom {

    @TestCase(input = {"[8,6,10,5,7,9,11]", "[8,8,7,9,2,#,#,#,#,4,7]"},
            output = {"[8,6,10,5,7,9,11]", "[8,8,7,9,2,4,7]"})
    public List<Integer> printFromTopToBottom(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            result.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return result;
    }

}
