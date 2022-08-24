package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.Node;

/**
 * 117. 填充每个节点的下一个右侧节点指针2
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * @since 2022/6/19
 */
public class ConnectLevelNext2 implements Solution<Node> {

    @Override
    public Node solve(Object... args) {
        Integer[] values = {1,2,3,4,5,null,7};
        Node root = Node.buildTree(values);
        System.out.println(Node.bfsString(root));
        Node result = connect(root);
        System.out.println(Node.bfsString(result));
        return result;
    }

    private Node connect(Node root) {
        bfs(root);
        return root;
    }

    /**
     * 思路：广度优先遍历，第一个非空子节点就是下一层的起始节点
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了12.71% 的Java用户
     */
    private void bfs(Node root) {
        if (root == null) {
            return;
        }

        // 始终指向每一层的起始节点
        Node levelStart = root;
        while (levelStart != null) {
            Node p = levelStart, q = null;
            levelStart = null;
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
    }

}
