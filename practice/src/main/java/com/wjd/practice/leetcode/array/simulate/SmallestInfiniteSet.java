package com.wjd.practice.leetcode.array.simulate;

import java.util.HashSet;
import java.util.Set;

/**
 * 周赛 301
 * <p>
 * 2336. 无限集中的最小数字
 * <p>
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
 * <p>
 * 实现 SmallestInfiniteSet 类：
 * <p>
 * SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 * int popSmallest() 移除 并返回该无限集中的最小整数。
 * void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
 *
 * @author weijiaduo
 * @since 2022/7/10
 */
public class SmallestInfiniteSet {

    Set<Integer> removed = new HashSet<>();
    int min = 1;

    public SmallestInfiniteSet() {
        min = 1;
    }

    public int popSmallest() {
        int ret = min;
        removed.add(min);
        min++;
        while (removed.contains(min)) {
            min++;
        }
        return ret;
    }

    public void addBack(int num) {
        removed.remove(num);
        min = Math.min(num, min);
    }

}
