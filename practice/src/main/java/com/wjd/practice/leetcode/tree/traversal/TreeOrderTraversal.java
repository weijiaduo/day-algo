package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 树的遍历
 */
public class TreeOrderTraversal {

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                result.add(cur.val);

                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
            Collections.reverse(result);
        }
        return result;
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            ArrayList<TreeNode> visited = new ArrayList<>();
            visited.add(null);
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                result.add(cur.val);
                visited.add(cur);

                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }
}
