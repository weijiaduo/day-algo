package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 875. 爱吃香蕉的珂珂
 * <p>
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。
 * <p>
 * 每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * @since 2022/6/7
 */
public class MinEatingSpeed implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        int result = minEatingSpeed(piles, h);
        System.out.println(result);
        return result;
    }

    /**
     * 二分法
     *
     * 思路：吃最慢是1，最快是max(piles[i])，用二分法查找中间可以刚好吃完的值
     *
     * 执行耗时:6 ms,击败了99.66% 的Java用户
     * 内存消耗:42.3 MB,击败了38.60% 的Java用户
     */
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 1;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (eatFinish(piles, h, mid)) {
                // max 始终指向可以吃完的值
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    private boolean eatFinish(int[] piles, int h, int s) {
        int count = 0;
        for (int pile : piles) {
            if (pile <= 0) {
                continue;
            }
            count += (pile + s - 1 ) / s;
            if (count > h) {
                return false;
            }
        }
        return true;
    }
}
