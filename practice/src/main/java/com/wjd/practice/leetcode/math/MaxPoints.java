package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10⁴ <= xi, yi <= 10⁴
 * points 中的所有点 互不相同
 *
 * @author weijiaduo
 * @since 2022/6/29
 */
public class MaxPoints {

    /**
     * 思路：暴力+哈希。统计所有点的斜率，斜率用分子分母表示（double精度会丢失）
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:29 ms,击败了38.77% 的Java用户
     * 内存消耗:42.3 MB,击败了42.15% 的Java用户
     */
    @TestCase(input = {"[[1,1],[2,2],[3,3]]", "[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]"},
            output = {"3", "4"})
    public int hash(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> countMap = new HashMap<>(n - i);
            for (int j = i + 1; j < n; j++) {
                // 计算斜率
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int g = gcd(dx, dy);
                String key = (dy / g) + "_" + (dx / g);

                // 统计相同斜率数量
                int cnt = countMap.getOrDefault(key, 1) + 1;
                countMap.put(key, cnt);
                ans = Math.max(cnt, ans);
            }
            // 快速剪枝，后面再怎么算也不会超过最大值了
            if (ans >= n - i - 1 || ans > n / 2) {
                break;
            }
        }
        return ans;
    }

    /**
     * 最大公约数
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
