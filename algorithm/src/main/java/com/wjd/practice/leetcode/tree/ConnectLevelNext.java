package com.wjd.practice.leetcode.tree;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * <p>
 * @since 2022/6/19
 */
public class ConnectLevelNext implements Solution<Node> {

    @Override
    public Node solve(Object... args) {
        // 懒得构建树了，直接提交~~~~~~
        Integer[] values = {};
        return null;
    }

    private Node connect(Node root) {
        return bfs(root);
    }

    /**
     * 思路：广度优先遍历即可
     *
     * 执行耗时:2 ms,击败了69.86% 的Java用户
     * 内存消耗:41.8 MB,击败了12.11% 的Java用户
     */
    private Node bfs(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node prev = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 思路：广度优先，逐层连接
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了55.49% 的Java用户
     */
    private void bfs2(Node root) {
        if (root == null) {
            return;
        }

        // 始终指向每一层的起始节点
        Node levelStart = root;
        while (levelStart != null) {
            Node p = levelStart;
            levelStart = levelStart.left;

            while (p != null && p.left != null) {
                // 直接子树连接
                p.left.next = p.right;
                // 跨子树连接
                if (p.next != null) {
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
        }
    }

    /**
     * 思路：深度优先，自底向上设置层级连接，左右子树的连接方式就是，左子树的右侧-右子树的左侧
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了8.94% 的Java用户
     */
    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);

        // 连接左子树和右子树
        Node p = root.left, q = root.right;
        while (p != null && q != null) {
            p.next = q;
            p = p.right;
            q = q.left;
        }
    }

    /**
     * 思路：深度优先遍历，自顶向下设置层级连接
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42 MB,击败了5.14% 的Java用户
     */
    private void dfs2(Node root) {
        if (root == null) {
            return;
        }

        // 先连接下一层的左右子树，然后才能遍历左右子树
        if (root.left != null) {
            // 直接子树连接
            root.left.next = root.right;
            if (root.next != null) {
                // 跨子树连接
                root.right.next = root.next.left;
            }
        }

        // 遍历子层
        dfs2(root.left);
        dfs2(root.right);
    }

}
