package com.wjd.practice.leetcode.graph;

import com.wjd.practice.TestCase;

import java.util.*;

/**
 * 210. 课程表2
 * <p>
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * <p>
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * <p>
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是'[0,1,2,3] 。另一个正确的排序是'[0,2,1,3] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 *
 * @author weijiaduo
 * @since 2022/7/15
 */
public class FindCoursesOrder {

    /**
     * 思路：bfs 拓扑，使用拓扑排序遍历所有节点
     * <p>
     * 复杂度：时间 O(n+e) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了68.43% 的Java用户
     * 内存消耗:43.7 MB,击败了59.98% 的Java用户
     */
    @TestCase(input = {"2", "[[1,0]]", "4", "[[1,0],[2,0],[3,1],[3,2]]", "2", "[[1,0],[0,1]]"},
            output = {"[0,1]", "[0,2,1,3]", "[]"})
    public int[] bfs(int numCourses, int[][] prerequisites) {
        // 入度
        int[] indegrees = new int[numCourses];
        // 邻接表
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adjList.get(p[1]).add(p[0]);
            indegrees[p[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int c = queue.poll();
            order[visited++] = c;
            for (int a : adjList.get(c)) {
                if (--indegrees[a] == 0) {
                    queue.offer(a);
                }
            }
        }
        return visited == numCourses ? order : new int[0];
    }

    /**
     * 思路：bfs 拓扑，使用拓扑排序遍历所有节点
     * <p>
     * 复杂度：时间 O(n+e) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了95.77% 的Java用户
     * 内存消耗:44.1 MB,击败了10.93% 的Java用户
     */
    @TestCase(input = {"2", "[[1,0]]", "4", "[[1,0],[2,0],[3,1],[3,2]]", "2", "[[1,0],[0,1]]"},
            output = {"[0,1]", "[0,2,1,3]", "[]"})
    public int[] dfs(int numCourses, int[][] prerequisites) {
        // 邻接表
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adjList.get(p[1]).add(p[0]);
        }

        // DFS 拓扑
        // 0未访问，1访问中，-1已访问
        int[] flags = new int[numCourses];
        Deque<Integer> order = new ArrayDeque<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjList, flags, order)) {
                return new int[0];
            }
        }

        // 逆后序才是真正的拓扑排序结果
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = order.pop();
        }
        return ans;
    }

    /**
     * 基于深度优先的后序遍历
     *
     * @param i       当前节点
     * @param adjList 邻接表
     * @param flags   访问标记
     * @param order   后序遍历
     * @return true 无环/false 有环
     */
    private boolean dfs(int i, List<List<Integer>> adjList, int[] flags, Deque<Integer> order) {
        // 出现环
        if (flags[i] == 1) {
            return false;
        }
        // 已访问
        if (flags[i] == -1) {
            return true;
        }

        // 访问中
        flags[i] = 1;
        for (int a : adjList.get(i)) {
            if (!dfs(a, adjList, flags, order)) {
                return false;
            }
        }
        // 已访问
        flags[i] = -1;
        order.push(i);
        return true;
    }

}
