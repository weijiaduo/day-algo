package com.wjd.practice.leetcode.tree.transform;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * <p>
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；如果找到了，删除它。
 * <p>
 * 示例 1:
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * <p>
 * 示例 3:
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * 提示:
 * <p>
 * 节点数的范围 [0, 10⁴].
 * -10⁵ <= Node.val <= 10⁵
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -10⁵ <= key <= 10⁵
 *
 * @since 2022/6/2
 */
public class DeleteNode {

    /**
     * 思路：递归搜索和删除节点，返回删除节点后的根节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.1 MB,击败了24.85% 的Java用户
     *
     * @param root 当前节点
     * @param key  指定删除 key
     * @return 新的当前节点
     */
    @TestCase(input = {"[5,3,6,2,4,null,7]", "3",
            "[5,3,6,2,4,null,7]", "0",
            "[]", "0"},
            output = {"[5,4,6,2,null,null,7]",
                    "[5,3,6,2,4,null,7]",
                    "[]"})
    public TreeNode dfs(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = dfs(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = dfs(root.right, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }

            // 寻找替代的节点
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }

            // 替换根节点，并删除替代节点
            root.right = dfs(root.right, successor.val);
            successor.left = root.left;
            successor.right = root.right;
            return successor;
        }
    }

}
