package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-06-03
 * <p>
 * 605. 种花问题
 * <p>
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 */
public class PlaceFlowers implements Solution<Boolean> {

    @Override
    public Boolean solve(Object args) {
        int[] flowerbed = {0};
        int n = 1;
        boolean result = canPlaceFlowers(flowerbed, n);
        System.out.println(result);
        return result;
    }

    /**
     * 种花问题
     *
     * @param flowerbed 数组
     * @param n         数量
     * @return true/false
     */
    private boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) {
            return true;
        }
        if (flowerbed.length < 2 * n - 1) {
            return false;
        }
        int k = n;
        for (int i = 0; k > 0 && i < flowerbed.length; i++) {
            // 当前不为空
            if (flowerbed[i] != 0) {
                continue;
            }
            // 左边不为空
            if (i - 1 >= 0 && flowerbed[i - 1] != 0) {
                continue;
            }
            // 右边不为空
            if (i + 1 < flowerbed.length && flowerbed[i + 1] != 0) {
                continue;
            }
            // 两边都为空，可以种花
            k--;
            i++;
        }
        return k <= 0;
    }
}
