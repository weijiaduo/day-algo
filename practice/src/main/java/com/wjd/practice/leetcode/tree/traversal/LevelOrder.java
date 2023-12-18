package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 * @since 2020-06-13
 */
public class LevelOrder {

    /**
     * 思路：广度优先遍历，使用队列来实现
     * <p>
     * 复杂度：时间 O(n) 最坏空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了92.61% 的Java用户
     * 内存消耗:43.2 MB,击败了7.43% 的Java用户
     */
    @TestCase(input = {"[3,9,20,null,null,15,7]", "[1]"},
            output = {"[[3],[9,20],[15,7]]", "[[1]]"})
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> level = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }

    /**
     * 思路：深度优先遍历
     * <p>
     * 复杂度：时间 O(n) 最坏空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100% 的Java用户
     * 内存消耗:42.54 MB,击败了92.23% 的Java用户
     */
    @TestCase(input = {"[3,9,20,null,null,15,7]", "[1]"},
            output = {"[[3],[9,20],[15,7]]", "[[1]]"})
    public List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    /**
     * 深度优先遍历
     *
     * @param root   当前节点
     * @param level  当前层级
     * @param levels 层级列表
     */
    private void dfs(TreeNode root, int level, List<List<Integer>> levels) {
        if (root == null) {
            return;
        }
        if (level >= levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root.val);
        dfs(root.left, level + 1, levels);
        dfs(root.right, level + 1, levels);
    }

}
