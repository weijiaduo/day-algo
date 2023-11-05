package com.wjd.practice.leetcode.tree.transform;

import com.wjd.practice.leetcode.structure.Node;

/**
 * 117. 填充每个节点的下一个右侧节点指针2
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
 * next 指针连接，'#' 标志着每一层的结束。
 * <p>
 * 示例 2:
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在
 * [0, 2¹² - 1] 范围内
 * -1000 <= node.val <= 1000
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @since 2022/6/19
 */
public class ConnectLevelNext2 {

    /**
     * 思路：广度优先遍历，第一个非空子节点就是下一层的起始节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了12.71% 的Java用户
     */
    public Node bfs(Node root) {
        // 始终指向每一层的起始节点
        Node levelStart = root;
        while (levelStart != null) {
            Node p = levelStart, q = null;
            levelStart = null;
            // 遍历上层节点，给下层节点设置连接关系
            while (p != null) {
                if (p.left != null) {
                    if (q != null) {
                        q.next = p.left;
                    }
                    q = p.left;
                    if (levelStart == null) {
                        levelStart = q;
                    }
                }
                if (p.right != null) {
                    if (q != null) {
                        q.next = p.right;
                    }
                    q = p.right;
                    if (levelStart == null) {
                        levelStart = q;
                    }
                }
                p = p.next;
            }
        }
        return root;
    }

}
