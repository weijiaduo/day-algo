package com.wjd.practice.leetcode.graph;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
     * 思路：bfs 拓扑，构建有向图，判断是否存在环
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了64.51% 的Java用户
     * 内存消耗:42.7 MB,击败了50.64% 的Java用户
     */
    @TestCase(input = {"2", "[[1,0]]", "2", "[[1,0],[0,1]]"},
            output = {"true", "false"})
    public boolean bfs(int numCourses, int[][] prerequisites) {
        // 入度
        int[] indegrees = new int[numCourses];
        // 邻接表
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adjList.get(p[1]).add(p[0]);
            indegrees[p[0]]++;
        }

        // BFS 拓扑
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            for (int a : adjList.get(queue.poll())) {
                if (--indegrees[a] == 0) {
                    queue.offer(a);
                }
            }
        }
        return visited == numCourses;
    }

    /**
     * 思路：dfs 拓扑，构建有向图，判断是否存在环
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了64.51% 的Java用户
     * 内存消耗:43.1 MB,击败了19.19% 的Java用户
     */
    @TestCase(input = {"2", "[[1,0]]", "2", "[[1,0],[0,1]]"},
            output = {"true", "false"})
    public boolean dfs(int numCourses, int[][] prerequisites) {
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
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjList, flags)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归
     *
     * @param i       当前节点
     * @param adjList 邻接表
     * @param flags   访问标记
     * @return true 无环/false 有环
     */
    private boolean dfs(int i, List<List<Integer>> adjList, int[] flags) {
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
            if (!dfs(a, adjList, flags)) {
                return false;
            }
        }
        // 已访问
        flags[i] = -1;
        return true;
    }

}
