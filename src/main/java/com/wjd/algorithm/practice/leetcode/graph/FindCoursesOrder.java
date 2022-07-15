package com.wjd.algorithm.practice.leetcode.graph;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.*;

/**
 * 210. 课程表2
 * <p>
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * <p>
 * 给你一个数组 prerequisites ，其中prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * <p>
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 *
 * @author weijiaduo
 * @since 2022/7/15
 */
public class FindCoursesOrder implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
        return result;
    }

    static class Node {
        int val;
        int inDegree = 0;
        List<Node> links = new ArrayList<>();
    }

    /**
     * 思路：构建有向图，使用拓扑排序遍历所有节点
     * <p>
     * 复杂度：时间O(n) 孔家 O(n)
     * <p>
     * 执行耗时:3 ms,击败了93.88% 的Java用户
     * 内存消耗:43 MB,击败了5.82% 的Java用户
     */
    private int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构建有向图
        Node[] nodes = buildGraph(numCourses, prerequisites);
        // 拓扑排序
        Queue<Node> queue = new ArrayDeque<>();
        for (Node node : nodes) {
            // 初始化入度为0的节点
            if (node.inDegree == 0) {
                queue.offer(node);
            }
        }
        int[] orders = new int[numCourses];
        int visited = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            orders[visited++] = node.val;
            for (Node link : node.links) {
                // 入度变为了0
                if (--link.inDegree == 0) {
                    queue.offer(link);
                }
            }
        }
        if (visited != numCourses) {
            return new int[0];
        } else {
            return orders;
        }
    }

    /**
     * 构建有向图
     *
     * @param numCourses    节点数量
     * @param prerequisites 有向边
     * @return 节点
     */
    private Node[] buildGraph(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node();
            nodes[i].val = i;
        }
        for (int[] p : prerequisites) {
            Node src = nodes[p[1]];
            Node tar = nodes[p[0]];
            src.links.add(tar);
            tar.inDegree++;
        }
        return nodes;
    }

}
