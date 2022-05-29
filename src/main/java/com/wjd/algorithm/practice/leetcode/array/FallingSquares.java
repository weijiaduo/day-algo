package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/**
 * 699. 掉落的方块
 *
 * @since 2022/5/27
 */
public class FallingSquares implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object ...args) {
        int[][] positions = {{2,1},{2,9},{1,8}};
        List<Integer> result = fallingSquares(positions);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：记录每一方块的最后高度，即叠起来的高度。
     * 当有新方块掉落时，遍历之前所有方块的高度，算出新方块的高度
     *
     * 执行耗时:43 ms,击败了12.47% 的Java用户
     * 内存消耗:42.2 MB,击败了42.35% 的Java用户
     */
    public List<Integer> fallingSquares(int[][] positions) {
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
