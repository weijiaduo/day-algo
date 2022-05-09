package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.structure.TreeNode2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 层次遍历树
 *
 */
public class LevelOrder {

    public static void main(String[] args) {
        String[] s = {"3","9","20","#","#","15","7"};
        TreeNode2 tree = TreeNode2.buildTree(s);

        ArrayList<ArrayList<Integer>> ls = levelOrder(tree);
        System.out.println(ls.size());
        for (ArrayList<Integer> l: ls){
            System.out.println(l.toString());
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode2 root) {
        ArrayList<ArrayList<Integer>> lOrder = new ArrayList<>();

        if (root != null) {
            int uCount = 0, dCount = 0;
            LinkedList<TreeNode2> queue = new LinkedList<>();
            queue.add(root);
            uCount++;

            ArrayList<Integer> curList = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode2 curNode = queue.poll();
                uCount--;
                curList.add(Integer.parseInt(curNode.val.toString()));
                //curList.add(curNode.val);

                if (curNode.left != null){
                    queue.add(curNode.left);
                    dCount++;
                }

                if (curNode.right != null){
                    queue.add(curNode.right);
                    dCount++;
                }

                if (uCount == 0){
                    uCount = dCount;
                    dCount = 0;
                    lOrder.add(curList);
                    curList = new ArrayList<>();
                }
            }
        }

        return lOrder;
    }
}
