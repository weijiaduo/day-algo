package com.wjd.practice.recruit.deeproute;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 最少步数
 * <p>
 * 给定一个 N 和 K。从 N 出发，最终抵达 K。
 * <p>
 * N 每步可以这样子走：
 * <p>
 * 1. N-1
 * <p>
 * 2. N+1
 * <p>
 * 3. N*2
 * <p>
 * 求从 N 到 K 的最小步数。
 * <p>
 * 0 <= N <= 100000
 * 0 <= K <= 100000
 *
 * @author weijiaduo
 * @since 2024/1/18
 */
public class MinSteps {

    /**
     * 思路：递归，K 只有有 3 种情况可以抵达
     * <p>
     * 分别就这 3 种情况进行遍历
     * <p>
     * 复杂度：时间 O(n) 空间 O(N)
     */
    @TestCase(input = {"2", "5", "2", "4", "4", "2"},
            output = {"2", "1", "2"})
    public int bfs(int n, int k) {
        int min = 0, max = 100000;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        for (int level = 0; !queue.isEmpty(); level++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int t = queue.poll();
                if (t == n) {
                    return level;
                }
                if (t < min || t > max) {
                    continue;
                }
                if (t > min) {
                    queue.offer(t - 1);
                }
                if (t < max) {
                    queue.offer(t + 1);
                }
                if (t > 0 && t % 2 == 0) {
                    queue.offer(t / 2);
                }
            }
        }
        return -1;
    }

}
