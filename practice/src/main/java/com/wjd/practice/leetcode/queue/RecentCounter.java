package com.wjd.practice.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 * <p>
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * <p>
 * 请你实现 RecentCounter 类：
 * <p>
 * RecentCounter() 初始化计数器，请求数为 0 。
 * <p>
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，
 * <p>
 * 并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。
 * <p>
 * 确切地说，返回在 [t-3000, t] 内发生的请求数。
 * <p>
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 * <p>
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回3
 * <p>
 * 提示：
 * <p>
 * 1 <= t <= 10⁹
 * 保证每次对 ping 调用所使用的 t 值都 严格递增
 * 至多调用 ping 方法 10⁴ 次
 *
 * @author weijiaduo
 * @since 2023/10/9
 */
public class RecentCounter {

    /**
     * 时间队列
     */
    private final Queue<Integer> queue;
    /**
     * 时间限制
     */
    private int limit = 3000;

    /**
     * 思路：队列，将时间入队，如果队首队尾相差超过时间限制，就出队
     * <p>
     * 复杂度：时间 O(1) 空间 O(n)
     * <p>
     * 执行耗时:19 ms,击败了84.40% 的Java用户
     * 内存消耗:49.1 MB,击败了96.73% 的Java用户
     */
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > limit) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }

}
