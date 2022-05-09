package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-06-06
 * <p>
 * 746. 使用最小花费爬楼梯
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */
public class MinCostClimbingStairs implements Solution<Integer> {

    @Override
    public Integer solve(Object args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result = minCostClimbingStairs(cost);
        System.out.println(result);
        return result;
    }

    /**
     * 使用最小花费爬楼梯
     *
     * @param cost 数组
     * @return 最花费
     */
    private int minCostClimbingStairs(int[] cost) {
        int minCost = 0, minCost1 = 0, minCost2 = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            minCost = Math.min(minCost1 + cost[i - 1], minCost2 + cost[i - 2]);
            minCost2 = minCost1;
            minCost1 = minCost;
        }
        return minCost;
    }
}
