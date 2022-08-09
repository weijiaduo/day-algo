package com.wjd.practice.leetcode.tree;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.Node;

/**
 * 558. 四叉树交集
 *
 * 描述太恶心了
 *
 * @author weijiaduo
 * @since 2022/7/15
 */
public class IntersectFour implements Solution<Node> {

    @Override
    public Node solve(Object... args) {
        return null;
    }

    private Node intersect(Node quadTree1, Node quadTree2) {
        return dfs(quadTree1, quadTree2);
    }

    /**
     * 思路：深度优先遍历，先执行子树的交集运算，再计算根节点的结果
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了28.57% 的Java用户
     */
    private Node dfs(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null || quadTree2 == null) {
            return null;
        }

        Node node = new Node();
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            node.val = quadTree1.val | quadTree2.val;
            node.isLeaf = true;
        } else {
            Node tl1, tr1, bl1, br1;
            Node tl2, tr2, bl2, br2;
            if (!quadTree1.isLeaf) {
                tl1 = quadTree1.topLeft;
                tr1 = quadTree1.topRight;
                bl1 = quadTree1.bottomLeft;
                br1 = quadTree1.bottomRight;
            } else {
                tl1 = copyNode(quadTree1);
                tr1 = copyNode(quadTree1);
                bl1 = copyNode(quadTree1);
                br1 = copyNode(quadTree1);
            }
            if (!quadTree2.isLeaf) {
                tl2 = quadTree2.topLeft;
                tr2 = quadTree2.topRight;
                bl2 = quadTree2.bottomLeft;
                br2 = quadTree2.bottomRight;
            } else {
                tl2 = copyNode(quadTree2);
                tr2 = copyNode(quadTree2);
                bl2 = copyNode(quadTree2);
                br2 = copyNode(quadTree2);
            }
            Node topLeft = dfs(tl1, tl2);
            Node topRight = dfs(tr1, tr2);
            Node bottomLeft = dfs(bl1, bl2);
            Node bottomRight = dfs(br1, br2);
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
                node.isLeaf = true;
                node.val = topLeft.val;
            } else {
                node.topLeft = topLeft;
                node.topRight = topRight;
                node.bottomLeft = bottomLeft;
                node.bottomRight = bottomRight;
            }
        }
        return node;
    }

    private Node copyNode(Node node) {
        Node copy = new Node();
        copy.val = node.val;
        copy.isLeaf = node.isLeaf;
        return copy;
    }

    // 官解：分治
    //
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    // 内存消耗:41.4 MB,击败了53.25% 的Java用户
    /**
     * 官解：分治
     *
     * 复杂度：时间 O(n^2) 空间 O(logn)
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了53.25% 的Java用户
     */
    // public Node intersect(Node quadTree1, Node quadTree2) {
    //     if (quadTree1.isLeaf) {
    //         if (quadTree1.val) {
    //             return new Node(true, true);
    //         }
    //         return new Node(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
    //     }
    //     if (quadTree2.isLeaf) {
    //         return intersect(quadTree2, quadTree1);
    //     }
    //     Node o1 = intersect(quadTree1.topLeft, quadTree2.topLeft);
    //     Node o2 = intersect(quadTree1.topRight, quadTree2.topRight);
    //     Node o3 = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
    //     Node o4 = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
    //     if (o1.isLeaf && o2.isLeaf && o3.isLeaf && o4.isLeaf && o1.val == o2.val && o1.val == o3.val && o1.val == o4.val) {
    //         return new Node(o1.val, true);
    //     }
    //     return new Node(false, false, o1, o2, o3, o4);
    // }

}
