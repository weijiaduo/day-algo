package com.wjd.practice.recruit.bytedance;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * <p>
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * <p>
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * @author weijiaduo
 * @since 2024/1/20
 */
public class FindPathInTree {

    /**
     * 思路：递归遍历二叉树，遍历到叶子节点时，判断路径上的节点和是否等于目标值
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"[10,5,12,4,7]", "22"},
            output = "[[10,5,7], [10,12]]")
    public List<List<Integer>> findPath(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findPath(root, target, new ArrayList<>(), res);
        return res;
    }

    /**
     * 查找等于指定值的路径
     *
     * @param root   当前节点
     * @param target 目标值
     * @param path   当前路径
     * @param res    结果集
     */
    private void findPath(TreeNode root, int target, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        target -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            // 叶子节点，且路径和等于目标值
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
        } else {
            // 递归遍历左右子树
            findPath(root.left, target, path, res);
            findPath(root.right, target, path, res);
        }
        path.remove(path.size() - 1);
    }

}
