package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.structure.tree.segment.MaxLinkSegmentTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/**
 * 699. 掉落的方块
 * <p>
 * 在二维平面上的 x 轴上，放置着一些方块。
 * <p>
 * 给你一个二维整数数组 positions ，其中 positions[i] = [lefti, sideLengthi] 表示：
 * <p>
 * 第 i 个方块边长为 sideLengthi ，其左侧边与 x 轴上坐标点 lefti 对齐。
 * <p>
 * 每个方块都从一个比目前所有的落地方块更高的高度掉落而下。
 * <p>
 * 方块沿 y 轴负方向下落，直到着陆到 另一个正方形的顶边 或者是 x 轴上 。
 * <p>
 * 一个方块仅仅是擦过另一个方块的左侧边或右侧边不算着陆。
 * <p>
 * 一旦着陆，它就会固定在原地，无法移动。
 * <p>
 * 在每个方块掉落后，你必须记录目前所有已经落稳的 方块堆叠的最高高度 。
 * <p>
 * 返回一个整数数组 ans ，其中 ans[i] 表示在第 i 块方块掉落后堆叠的最高高度。
 * <p>
 * 输入：positions = [[1,2],[2,3],[6,1]]
 * 输出：[2,5,5]
 * 解释：
 * 第 1 个方块掉落后，最高的堆叠由方块 1 组成，堆叠的最高高度为 2 。
 * 第 2 个方块掉落后，最高的堆叠由方块 1 和 2 组成，堆叠的最高高度为 5 。
 * 第 3 个方块掉落后，最高的堆叠仍然由方块 1 和 2 组成，堆叠的最高高度为 5 。
 * 因此，返回 [2, 5, 5] 作为答案。
 *
 * @since 2022/5/27
 */
public class FallingSquares implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object... args) {
        int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
        List<Integer> result = fallingSquares(positions);
        System.out.println(result);
        return result;
    }

    public List<Integer> fallingSquares(int[][] positions) {
        return segmentTreeFallingSquares(positions);
    }

    /**
     * 思路：线段树，节点保存区间的最大值
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:18 ms,击败了39.96% 的Java用户
     * 内存消耗:49 MB,击败了38.94% 的Java用户
     *
     * @param positions 位置数组
     * @return 高度列表
     */
    private List<Integer> segmentTreeFallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>(positions.length);
        int low = 1, high = (int) 1e8;
        MaxLinkSegmentTree segmentTree = new MaxLinkSegmentTree(low, high);
        for (int[] position : positions) {
            int x = position[0];
            int w = position[1];
            int maxH = segmentTree.query(x, x + w - 1);
            segmentTree.update(x, x + w - 1, maxH + w);
            ans.add(segmentTree.query(low, high));
        }
        return ans;
    }

    /**
     * 思路：记录每一方块的最后高度，即叠起来的高度。
     * 当有新方块掉落时，遍历之前所有方块的高度，算出新方块的高度
     * <p>
     * 执行耗时:43 ms,击败了12.47% 的Java用户
     * 内存消耗:42.2 MB,击败了42.35% 的Java用户
     */
    private List<Integer> mapFallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>(positions.length);
        TreeMap<Position, Integer> heights = new TreeMap<>();
        int maxHeight = 0;
        for (int[] pos : positions) {
            int left = pos[0], length = pos[1];
            int height = length;
            for (Position p : heights.keySet()) {
                if (left >= p.left + p.length) {
                    // 没有交集，继续找下一个
                    continue;
                }
                if (left + length <= p.left) {
                    // 超出范围外，后面的不用再找了
                    break;
                }
                // 可能和多块重叠，取最高的重叠区域
                height = Math.max(length + heights.get(p), height);
            }
            heights.put(new Position(left, length), height);
            maxHeight = Math.max(height, maxHeight);
            ans.add(maxHeight);
        }
        return ans;
    }

    static class Position implements Comparable<Position> {
        int left;
        int length;

        public Position(int left, int length) {
            this.left = left;
            this.length = length;
        }

        @Override
        public boolean equals(Object o) {
            return this == o;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, length);
        }

        @Override
        public int compareTo(Position o) {
            if (o == null) {
                return 1;
            }
            if (this == o) {
                return 0;
            }
            if (left == o.left) {
                return (left + length - o.left - o.length);
            } else {
                return left - o.left;
            }
        }
    }
}
