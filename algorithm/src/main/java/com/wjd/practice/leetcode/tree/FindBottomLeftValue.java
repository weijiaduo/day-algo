package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * <p>
 * @author weijiaduo
 * @since 2022/6/22
 */
public class FindBottomLeftValue implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        Integer[] values = {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        int result = findBottomLeftValue(root);
        System.out.println(result);
        return result;
    }

    private int findBottomLeftValue(TreeNode root) {
        return reverseBfs(root);
    }

    /**
     * 思路：广度优先，按照层级遍历，每层第一个节点就是最左值
     *
     * 执行耗时:1 ms,击败了65.43% 的Java用户
     * 内存消耗:41.1 MB,击败了34.37% 的Java用户
     */
    private int bfs(TreeNode root) {
        int leftVal = 0;
        if (root == null) {
            return leftVal;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            leftVal = queue.peek().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return leftVal;
    }

    /**
     * 思路：按层次从右往左遍历所有节点，最后一个节点就是最左节点
     *
     * 这个反向遍历有点意思
     *
     * 执行耗时:1 ms,击败了65.43% 的Java用户
     * 内存消耗:41.2 MB,击败了14.28% 的Java用户
     */
    private int reverseBfs(TreeNode root) {
        int leftVal = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 先右后左
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            leftVal = node.val;
        }
        return leftVal;
    }

}
