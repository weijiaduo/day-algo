package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * <p>
 *
 * @since 2022/6/11
 */
public class RecoverTree implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        Integer[] values = {1, 3, null, null, 2};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.traverse(root));
        recoveryTree(root);
        System.out.println(TreeNode.traverse(root));
        return null;
    }

    public void recoveryTree(TreeNode root) {
        iterator2(root);
    }

    /**
     * 中序遍历法
     * <p>
     * 思路：按照中序遍历，拿到所有节点后再判断哪2个节点出现了交换
     * <p>
     * 执行耗时:2 ms,击败了44.54% 的Java用户
     * 内存消耗:41.6 MB,击败了20.55% 的Java用户
     */
    private void iterator(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                // 访问左节点
                stack.push(node);
                node = node.left;
                continue;
            }

            // 访问根节点
            node = stack.pop();
            nodes.add(node);

            // 访问右节点
            node = node.right;
        }

        List<TreeNode> swap = new ArrayList<>(2);
        long prev = Long.MIN_VALUE, next;
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode n = nodes.get(i);
            if (i < nodes.size() - 1) {
                next = nodes.get(i + 1).val;
            } else {
                next = Long.MAX_VALUE;
            }
            if (prev < n.val && n.val > next
                    || prev > n.val && n.val < next) {
                swap.add(n);
            }
            prev = n.val;
        }

        if (swap.size() >= 2) {
            TreeNode n1 = swap.get(0);
            TreeNode n2 = swap.get(swap.size() - 1);
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }
    }

    /**
     * 中序遍历
     * <p>
     * 思路：只需保留前后2个节点即可，判断它们的大小
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了53.21% 的Java用户
     */
    private void iterator2(TreeNode root) {
        TreeNode n1 = null, n2 = null;
        TreeNode s1 = null, s2 = null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                // 访问左节点
                stack.push(node);
                node = node.left;
                continue;
            }

            // 访问根节点
            node = stack.pop();
            n1 = n2;
            n2 = node;

            if (n1 != null && n1.val > n2.val) {
                if (s1 == null) {
                    // 后面的值换到了前面
                    // 取第一个出现的值
                    s1 = n1;
                }
                // 前面的值换到了后面
                // 取最后一个出现的值
                s2 = n2;
            }

            // 访问右节点
            node = node.right;
        }

        if (s1 != null) {
            int temp = s1.val;
            s1.val = s2.val;
            s2.val = temp;
        }
    }

}
