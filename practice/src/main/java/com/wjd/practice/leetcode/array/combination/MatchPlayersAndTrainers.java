package com.wjd.practice.leetcode.array.combination;

import java.util.Arrays;

/**
 * 6185. 运动员和训练师的最大匹配数
 *
 * @author weijiaduo
 * @since 2022/9/17
 */
public class MatchPlayersAndTrainers {

    /**
     * 思路：贪心 + 双指针，排序后，运动员尽量匹配满足条件的最小训练师
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     *
     * @param players  远动员
     * @param trainers 训练员
     * @return 最大匹配数
     */
    private int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length;
        int ans = 0;
        for (int i = 0, j = 0; i < m && j < n; i++) {
            for (; j < n; j++) {
                if (trainers[j] >= players[i]) {
                    ans++;
                    j++;
                    break;
                }
            }
        }
        return ans;
    }

}
