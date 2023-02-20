package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.generic.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 * <p>
 * 给定一个 n 叉树的根节点
 * root ，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 *
 * @author weijiaduo
 * @since 2022/12/11
 */
public class NTreePostorder {

    List<Integer> list;

    public List<Integer> solve(Node root) {
        list = new ArrayList<>();
        recursive(root);
        return list;
    }

    /**
     * 思路：递归实现
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.3 MB,击败了35.77% 的Java用户
     *
     * @param root 根节点
     */
    private void recursive(Node root) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (Node child : root.children) {
                recursive(child);
            }
        }
        list.add(root.val);
    }

}
