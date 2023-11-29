package com.wjd.practice.book.sword.greedy;

import com.wjd.practice.TestCase;

/**
 * 63. 股票的最大利润
 * <p>
 * 假设把某股票的价格按照时间先后顺序存储在数组中，
 * <p>
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 例如，一只股票在某些时间节点的价格为 {9, 11, 8, 5, 7, 12, 16, 14}。
 * <p>
 * 如果我们能在价格为 5 的时候买入并在价格为 16 时卖出，则能收获最大的利润 11。
 *
 * @author weijiaduo
 * @since 2023/11/30
 */
public class MaximalProfit {

    /**
     * 思路：贪心
     * <p>
     * 从前往后遍历，记录当前最小值，然后计算当前值和最小值的差值，取最大的差值即可。
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[9,11,8,5,7,12,16,14]"}, output = {"11"})
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int min = prices[0], max = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

}
