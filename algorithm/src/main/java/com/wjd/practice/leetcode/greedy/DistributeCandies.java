package com.wjd.practice.leetcode.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * <p>
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * <p>
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * @since 2021-06-30
 */
public class DistributeCandies {

    /**
     * 分糖果
     *
     * @param candyType 糖果类型数组
     * @return 最大种类
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>(candyType.length);
        int half = candyType.length >> 1;
        for (int type : candyType) {
            types.add(type);
            if (types.size() >= half) {
                break;
            }
        }
        return Math.min(types.size(), half);
    }

}
