package com.wjd.practice.leetcode.math;

import com.wjd.practice.leetcode.Solution;

import java.util.*;

/**
 * 710. 黑名单中的随机数
 *
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。
 *
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单blacklist 的整数。
 *
 * 任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 *
 * @author weijiaduo
 * @since 2022/6/26
 */
public class RandomBlackList implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        return null;
    }

    Map<Integer, Integer> b2w;
    Random random;
    int bound;

    /**
     * 思路：把黑名单限制在[0,m]内，并把黑名单映射到[n-m,n]范围内
     *
     * 执行耗时:39 ms,击败了99.57% 的Java用户
     * 内存消耗:52.8 MB,击败了12.28% 的Java用户
     */
    public void solution(int n, int[] blacklist) {
        b2w = new HashMap<>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;
        Set<Integer> black = new HashSet<>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }

        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (black.contains(w)) {
                    ++w;
                }
                b2w.put(b, w);
                ++w;
            }
        }
    }

    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }

}
