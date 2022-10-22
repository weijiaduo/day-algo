package com.wjd.practice.leetcode.array;

import java.util.Arrays;

/**
 * 1235. 规划兼职工作
 * <p>
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * <p>
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 * <p>
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
 * <p>
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * <p>
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 * <p>
 * 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
 *
 * @author weijiaduo
 * @since 2022/10/22
 */
public class JobScheduling {

    public int solve(int[] startTime, int[] endTime, int[] profit) {
        return dynamic(startTime, endTime, profit);
    }

    /**
     * 思路：动态规划，按时间升序、利润降序排序，动态推导出前i个任务的最大利润
     * <p>
     * 状态转移公式 dp[i] = max(dp[i-1], dp[j] + profit[i])
     * <p>
     * 其中，j < i && endTime[j] <= startTime[i]
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:24 ms,击败了31.08% 的Java用户
     * 内存消耗:48.8 MB,击败了95.97% 的Java用户
     */
    private int dynamic(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        // 结束时间升序，利润降序
        Arrays.sort(jobs, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return b[2] - a[2];
            }
        });

        // 初始化状态
        // dp[i] 表示前i个任务的最大利润
        int[] dp = new int[n + 1];
        dp[0] = 0;

        // 状态转移
        for (int i = 1; i < n + 1; i++) {
            // 找到满足 endTime[k] <= startTime[i] 的最大索引
            int k = lastNotGreatThan(jobs, i - 1, jobs[i - 1][0]);
            // 分2种情况：不做当前任务，做当前任务
            dp[i] = Math.max(dp[i - 1], dp[k + 1] + jobs[i - 1][2]);
        }

        return dp[n];
    }

    /**
     * 最后一个不大于指定值的元素索引
     */
    private int lastNotGreatThan(int[][] jobs, int high, int upper) {
        int left = 0, right = high;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= upper) {
                if (mid == high || jobs[mid + 1][1] > upper) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
