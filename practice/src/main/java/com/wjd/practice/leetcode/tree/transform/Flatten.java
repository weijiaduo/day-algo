package com.wjd.practice.leetcode.tree.transform;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * <p>
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 * @since 2022/6/19
 */
public class Flatten {

    /**
     * 思路：递归构造链表，先把左子树构成链表，返回链头，再把右子树构造成链表，也是返回链头，然后把根-左链表-右链表连接起来即可
     * <p>
     * 连接左链表-右链表时，需要知道左链表的链尾，遍历一次也可以，但是为了提高速度，直接用 root.left 保存链尾，快速指向
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了33.04% 的Java用户
     */
    @TestCase(input = {"[1,2,5,3,4,null,6]", "[]", "[0]"},
            output = {"[1,null,2,null,3,null,4,null,5,null,6]", "[]", "[0]"})
    public void dfs(TreeNode root) {
        dfs0(root);
    }

    /**
     * 将二叉树转成链表，并返回链尾节点
     *
     * @param root 根节点
     * @return 链尾节点
     */
    private TreeNode dfs0(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode leftTail = dfs0(root.left);
        TreeNode rightTail = dfs0(root.right);
        if (leftTail != null) {
            // 左链表插入到根节点和右链表之间
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        // 返回链尾节点
        if (rightTail != null) {
            return rightTail;
        } else {
            return leftTail;
        }
    }

    /**
     * 官方题解
     * <p>
     * 思路：将右子树迁移到左子树最后访问的位置，然后将左子树替代右子树的位置
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了77.62% 的Java用户
     */
    @TestCase(input = {"[1,2,5,3,4,null,6]", "[]", "[0]"},
            output = {"[1,null,2,null,3,null,4,null,5,null,6]", "[]", "[0]"})
    public void iterate(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
                continue;
            }
            // 把右子树移到左子树最后遍历的位置
            TreeNode pre = cur.left;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = cur.right;
            // 用左子树移替换右子树的位置
            cur.right = cur.left;
            cur.left = null;
        }
    }

}
