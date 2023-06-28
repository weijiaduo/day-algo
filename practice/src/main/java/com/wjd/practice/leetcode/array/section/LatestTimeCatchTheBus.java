package com.wjd.practice.leetcode.array.section;

import java.util.Arrays;

/**
 * 双周赛 82
 * <p>
 * 6117. 坐上公交的最晚时间
 * <p>
 * 给你一个下标从 0开始长度为 n的整数数组buses，其中buses[i]表示第 i辆公交车的出发时间。
 * <p>
 * 同时给你一个下标从 0开始长度为 m的整数数组passengers，其中passengers[j]表示第j位乘客的到达时间。
 * <p>
 * 所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同。
 * <p>
 * 给你一个整数capacity，表示每辆公交车最多能容纳的乘客数目。
 * <p>
 * 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y时刻到达，公交在x时刻出发，满足y <= x且公交没有满，那么你可以搭乘这一辆公交。最早到达的乘客优先上车。
 * <p>
 * 返回你可以搭乘公交车的最晚到达公交站时间。你 不能跟别的乘客同时刻到达。
 * <p>
 * 注意：数组buses 和passengers不一定是有序的。
 * <p>
 * 输入：buses = [10,20], passengers = [2,17,18,19], capacity = 2
 * 输出：16
 * 解释：
 * 第 1 辆公交车载着第 1 位乘客。
 * 第 2 辆公交车载着你和第 2 位乘客。
 * 注意你不能跟其他乘客同一时间到达，所以你必须在第二位乘客之前到达。
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class LatestTimeCatchTheBus {

    /**
     * 思路：计算每辆车的乘客，插在最后一个乘客之前，或者有剩余空位时最后再上车
     */
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int m = buses.length, n = passengers.length;
        int ans = passengers[n - 1] + 1;
        int prev = 0;
        for (int i = 0, j = 0; i < m; i++) {
            int count = capacity;
            for (; j < n && count > 0 && passengers[j] <= buses[i]; j++) {
                // 插在下一个乘客之前，但不能和前一个乘客同时到达
                if (prev < passengers[j] - 1) {
                    ans = passengers[j] - 1;
                }
                count--;
                prev = passengers[j];
            }
            // 有剩余空位时最后再上
            if (count > 0) {
                // 不能和前一个乘客同时到达
                if (prev < buses[i]) {
                    ans = buses[i];
                }
            }
        }
        return ans;
    }

}
