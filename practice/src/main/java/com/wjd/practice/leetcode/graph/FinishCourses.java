package com.wjd.practice.leetcode.graph;

import com.wjd.practice.leetcode.TestCase;

import java.util.*;

/**
 * 207. 课程表
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。
 * <p>
 * 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * <p>
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 *
 * @author weijiaduo
 * @since 2022/7/14
 */
public class FinishCourses {

    /**
     * 思路：构建有向图，判断是否存在环
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:6 ms,击败了28.25% 的Java用户
     * 内存消耗:41.8 MB,击败了28.96% 的Java用户
     */
    @TestCase(input = {"2", "[[1,0]]", "2", "[[1,0],[0,1]]"},
            output = {"true", "false"})
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int[] p : prerequisites) {
            // 依赖自己
            if (p[0] == p[1]) {
                return false;
            }
            Node src = nodes.get(p[1]);
            if (src == null) {
                src = new Node();
                src.val = p[1];
                nodes.put(src.val, src);
            }
            Node tar = nodes.get(p[0]);
            if (tar == null) {
                tar = new Node();
                tar.val = p[0];
                nodes.put(tar.val, tar);
            }
            src.links.add(tar);
            tar.inDegree++;
        }
        return !hasCircle(nodes);
    }

    /**
     * 是否有环
     *
     * @param nodes 有向图节点
     */
    private boolean hasCircle(Map<Integer, Node> nodes) {
        Queue<Node> queue = new ArrayDeque<>();
        // 初始化入度为0的节点
        for (Node node : nodes.values()) {
            if (node.inDegree == 0) {
                queue.offer(node);
            }
        }
        // 遍历所有入度为0的节点
        int visited = 0;
        while (queue.size() > 0) {
            visited++;
            Node node = queue.poll();
            for (Node link : node.links) {
                if (--link.inDegree == 0) {
                    queue.offer(link);
                }
            }
        }
        // 剩余节点的入度不为0，表示有循环
        return visited != nodes.size();
    }

    static class Node {
        int val;
        int inDegree = 0;
        List<Node> links = new ArrayList<>();
    }

}
