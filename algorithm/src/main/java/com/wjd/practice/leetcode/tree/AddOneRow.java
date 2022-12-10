package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * <p>
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点 root 位于深度 1 。
 * <p>
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 *
 * @author weijiaduo
 * @since 2022/8/5
 */
public class AddOneRow implements Solution<TreeNode> {

    @Override
    public TreeNode solve(Object... args) {
        int val = 1;
        int depth = 3;
        Integer[] values = {4, 2, null, 3, 1};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.traverse(root));
        TreeNode result = addOneRow(root, val, depth);
        System.out.println(TreeNode.traverse(result));
        return result;
    }

    private TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth <= 0 || root == null) {
            return root;
        }
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        // return dfsAddOneRow(root, depth - 1, 1, val);
        return bfsAddOneRow(root, depth - 1, val);
    }

    /**
     * 思路：深度优先搜索，在指定的层次添加子节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(h)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了19.26% 的Java用户
     *
     * @param root  根节点
     * @param depth 目标深度
     * @param d     当前深度
     * @param val   节点值
     * @return 根节点
     */
    private TreeNode dfsAddOneRow(TreeNode root, int depth, int d, int val) {
        if (root == null || d > depth) {
            return root;
        }
        if (d < depth) {
            dfsAddOneRow(root.left, depth, d + 1, val);
            dfsAddOneRow(root.right, depth, d + 1, val);
        } else {
            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);
            leftNode.left = root.left;
            rightNode.right = root.right;
            root.left = leftNode;
            root.right = rightNode;
        }
        return root;
    }

    /**
     * 思路：广度优先搜索，找到depth的上一层后，就可以直接添加节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(w)
     * <p>
     * 执行耗时:1 ms,击败了24.49% 的Java用户
     * 内存消耗:40.8 MB,击败了83.40% 的Java用户
     *
     * @param root  根节点
     * @param depth 深度
     * @param val   节点值
     * @return 根节点
     */
    private TreeNode bfsAddOneRow(TreeNode root, int depth, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int d = 1; !queue.isEmpty(); d++) {
            int size = queue.size();
            if (d < depth) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    TreeNode leftNode = new TreeNode(val);
                    TreeNode rightNode = new TreeNode(val);
                    leftNode.left = node.left;
                    rightNode.right = node.right;
                    node.left = leftNode;
                    node.right = rightNode;
                }
            }
        }
        return root;
    }

}
