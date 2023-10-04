package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1:
 * <p>
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1,3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入:[1,null,3]
 * 输出:[1,3]
 * <p>
 * 示例 3:
 * <p>
 * 输入:[]
 * 输出:[]
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * <p>
 * -100 <= Node.val <= 100
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class RightSideView {

    /**
     * 思路：右视图，实际就是每层的最右边节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(h)
     * <p>
     * 执行耗时:1 ms,击败了81.47% 的Java用户
     * 内存消耗:39.9 MB,击败了74.27% 的Java用户
     */
    @TestCase(input = {"[1,2,3,null,5,null,4]", "[1,null,3]", "[]"},
            output = {"[1,3,4]", "[1,3]", "[]"})
    public List<Integer> bfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // 每层的最后一个节点
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

}
