package com.wjd.practice.leetcode.graph;

import com.wjd.practice.leetcode.TestCase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 841. 钥匙和房间
 * <p>
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * <p>
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。
 * <p>
 * 你可以拿上所有钥匙去解锁其他房间。
 * <p>
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。
 * <p>
 * 如果能进入 所有 房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rooms = [[1],[2],[3],[]]
 * 输出：true
 * 解释：
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入：rooms = [[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * <p>
 * 提示：
 * <p>
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * 所有 rooms[i] 的值 互不相同
 *
 * @author weijiaduo
 * @since 2023/10/12
 */
public class CanVisitAllRooms {

    /**
     * 思路：深度优先遍历，遍历所有可入的房间
     * <p>
     * 如果遍历完成后，还有房间未遍历到，则返回 false
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了59.38% 的Java用户
     * 内存消耗:41.4 MB,击败了99.36% 的Java用户
     */
    @TestCase(input = {"[[1],[2],[3],[]]", "[[1,3],[3,0,1],[2],[0]]"},
            output = {"true", "false"})
    public boolean dfs(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);
        return visited.size() == n;
    }

    /**
     * 深度优先遍历
     *
     * @param i       当前房间编号
     * @param rooms   房间编号集合
     * @param visited 已访问房间
     */
    private void dfs(int i, List<List<Integer>> rooms, Set<Integer> visited) {
        if (!visited.add(i)) {
            return;
        }
        List<Integer> keys = rooms.get(i);
        for (int key : keys) {
            dfs(key, rooms, visited);
        }
    }

}
