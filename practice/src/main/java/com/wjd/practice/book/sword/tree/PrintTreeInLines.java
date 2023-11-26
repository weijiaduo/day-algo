package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 32.2 分行从上往下打印二叉树
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印，每一层打印到一行。
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class PrintTreeInLines {

    /**
     * 思路：层序遍历
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"[8,6,10,5,7,9,11]"},
            output = "[[8], [6, 10], [5, 7, 9, 11]]")
    public List<List<Integer>> print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}
