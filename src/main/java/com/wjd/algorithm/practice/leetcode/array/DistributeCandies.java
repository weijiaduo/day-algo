package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @since 2021-06-30
 *
 * 575. 分糖果
 *
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 *
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 */
public class DistributeCandies implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] candyType = {1,1,2,3};
        int result = distributeCandies(candyType);
        System.out.println(result);
        return result;
    }

    /**
     * 分糖果
     * @param candyType 糖果类型数组
     * @return 最大种类
     */
    private int distributeCandies(int[] candyType) {
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
