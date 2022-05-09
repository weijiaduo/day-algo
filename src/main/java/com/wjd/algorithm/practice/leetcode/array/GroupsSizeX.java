package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.*;

/**
 * @since 2021-06-24
 *
 * 914. 卡牌分组
 *
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有X张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回true。
 *
 */
public class GroupsSizeX implements Solution<Boolean> {

    @Override
    public Boolean solve(Object args) {
        int[] deck = {18,18,18,18,19,19,19,19};
        boolean result = hasGroupsSizeX(deck);
        System.out.println(result);
        return result;
    }

    /**
     * 卡牌分组
     * @param deck 卡牌数组
     * @return 是否能够分组
     */
    private boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }

        Map<Integer, Integer> counts = new HashMap<>(deck.length);
        for (int num : deck) {
            Integer count = counts.get(num);
            if (count == null) {
                counts.put(num, 1);
                continue;
            }
            counts.put(num, ++count);
        }
        if (counts.size() == 1) {
            return true;
        }

        int r = -1;
        for (int val : counts.values()) {
            if (r == -1) {
                r = val;
            } else {
                r = gcd(r, val);
            }
            if (r < 2) {
                return false;
            }
        }
        return r > 1;
    }

    /**
     * 最大公约数
     * @param a 数1
     * @param b 数2
     * @return 最大公约数
     */
    private int gcd(int a, int b) {
        return b == 0 ? a: gcd(b, a % b);
    }
}
