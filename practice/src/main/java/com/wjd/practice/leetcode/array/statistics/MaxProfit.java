package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.leetcode.TestCase;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁴
 *
 * @since 2021-05-29
 */
public class MaxProfit {

    /**
     * 思路：优先用最小值，然后找它后面的更大值，两者差就是利润
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:57.4 MB,击败了73.57% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[7,6,4,3,1]"},
            output = {"5", "0"})
    private int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                // 找到更小值，那后面的最大差值就和之前的最小值没关系了
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // 找到更大值，更新最新的差值
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

}
