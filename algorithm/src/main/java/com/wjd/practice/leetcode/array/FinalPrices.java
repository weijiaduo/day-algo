package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1475. 商品折扣后的最终价格
 * <p>
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
 * <p>
 * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * <p>
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 *
 * @author weijiaduo
 * @since 2022/9/1
 */
public class FinalPrices implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int[] prices = {8, 4, 6, 2, 3};
        int[] result = finalPrices(prices);
        System.out.println(Arrays.toString(result));
        return result;
    }

    private int[] finalPrices(int[] prices) {
        // return bfFindPrices(prices);
        return singleStackFinalPrices(prices);
    }

    /**
     * 思路：暴力法，直接按照要求，寻找i之后的j，满足prices[j] <= prices[i]
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了98.71% 的Java用户
     * 内存消耗:41.6 MB,击败了53.99% 的Java用户
     *
     * @param prices 数组
     * @return 新数组
     */
    private int[] bfFindPrices(int[] prices) {
        int n = prices.length;
        int[] finalPrices = new int[n];
        for (int i = 0; i < n; i++) {
            finalPrices[i] = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    finalPrices[i] -= prices[j];
                    break;
                }
            }
        }
        return finalPrices;
    }

    /**
     * 思路：单调栈，小于等于栈顶时出栈，大于栈顶时入栈，同时更新数据
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了56.04% 的Java用户
     * 内存消耗:41.9 MB,击败了11.06% 的Java用户
     *
     * @param prices 数组
     * @return 新数组
     */
    private int[] singleStackFinalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = prices.length;
        int[] finalPrices = new int[n];
        for (int i = 0; i < n; i++) {
            finalPrices[i] = prices[i];
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                finalPrices[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        return finalPrices;
    }

}
