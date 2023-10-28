package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.TestCase;

/**
 * 875. 爱吃香蕉的珂珂
 * <p>
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
 * <p>
 * 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * <p>
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 10⁴
 * piles.length <= h <= 10⁹
 * 1 <= piles[i] <= 10⁹
 *
 * @since 2022/6/7
 */
public class MinEatingSpeed {

    /**
     * 思路：吃最慢是1，最快是max(piles[i])，用二分法查找中间可以刚好吃完的值
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了99.66% 的Java用户
     * 内存消耗:42.3 MB,击败了38.60% 的Java用户
     */
    @TestCase(input = {"[3,6,7,11]", "8", "[30,11,23,4,20]", "5", "[30,11,23,4,20]", "6"},
            output = {"4", "30", "23"})
    public int binary(int[] piles, int h) {
        int min = 1, max = 1;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canFinish(piles, h, mid)) {
                // max 始终指向可以吃完的值
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    private boolean canFinish(int[] piles, int h, int s) {
        int count = 0;
        for (int pile : piles) {
            if (pile <= 0) {
                continue;
            }
            count += (pile + s - 1) / s;
            if (count > h) {
                return false;
            }
        }
        return true;
    }

}
