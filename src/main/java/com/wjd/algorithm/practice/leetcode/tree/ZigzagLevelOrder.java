package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.structure.TreeNode2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Z字形打印树
 *
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        String[] s = {"3","9","20","#","#","15","7"};
        TreeNode2 tree = TreeNode2.buildTree(s);

        ArrayList<ArrayList<Integer>> ls = zigzagLevelOrder(tree);
        for (ArrayList<Integer> l: ls){
            System.out.println(l.toString());
        }
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode2 root) {
        ArrayList<ArrayList<Integer>> zOrder = new ArrayList<>();

        if (root != null) {
            int depth = 0;
            LinkedList<TreeNode2> stack1 = new LinkedList<>();
            LinkedList<TreeNode2> stack2 = new LinkedList<>();
            stack1.add(root);
            ArrayList<Integer> curList = new ArrayList<>();
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                TreeNode2 curNode;
                if (depth % 2 == 0) {
                    curNode = stack1.pop();
                    curList.add(Integer.parseInt(curNode.val.toString()));
                    //curList.add(curNode.val);

                    if (curNode.left != null) {
                        stack2.push(curNode.left);
                    }
                    if (curNode.right != null) {
                        stack2.push(curNode.right);
                    }

                    if (stack1.isEmpty()) {
                        depth++;
                        zOrder.add(curList);
                        curList = new ArrayList<>();
                    }
                } else {
                    curNode = stack2.pop();
                    curList.add(Integer.parseInt(curNode.val.toString()));
                    //curList.add(curNode.val);

                    if (curNode.right != null) {
                        stack1.push(curNode.right);
                    }
                    if (curNode.left != null) {
                        stack1.push(curNode.left);
                    }

                    if (stack2.isEmpty()) {
                        depth++;
                        zOrder.add(curList);
                        curList = new ArrayList<>();
                    }
                }
            }
        }

        return zOrder;
    }
}
