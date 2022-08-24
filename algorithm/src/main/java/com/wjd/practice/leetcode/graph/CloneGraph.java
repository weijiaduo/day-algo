package com.wjd.practice.leetcode.graph;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 133. 克隆图
 * <p>
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * @author weijiaduo
 * @since 2022/6/24
 */
public class CloneGraph implements Solution<Node> {

    @Override
    public Node solve(Object... args) {
        return null;
    }

    private Node cloneGraph(Node node) {
        return dfsCloneGraph(node, new HashMap<>());
    }

    /**
     * 思路：深度优先遍历 + 哈希记忆存储
     * <p>
     * 执行耗时:24 ms,击败了67.91% 的Java用户
     * 内存消耗:41.3 MB,击败了72.52% 的Java用户
     */
    private Node dfsCloneGraph(Node node, Map<Integer, Node> nodes) {
        if (node == null) {
            return null;
        }
        Node newNode = nodes.get(node.val);
        if (newNode != null) {
            return newNode;
        }
        newNode = new Node(node.val);
        nodes.put(newNode.val, newNode);
        for (Node n : node.neighbors) {
            newNode.neighbors.add(dfsCloneGraph(n, nodes));
        }
        return newNode;
    }

}
