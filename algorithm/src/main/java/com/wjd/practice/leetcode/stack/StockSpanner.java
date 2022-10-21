package com.wjd.practice.leetcode.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 901. 股票价格的跨度
 * <p>
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * <p>
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * <p>
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[10
 * 0],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 *
 * @author weijiaduo
 * @since 2022/10/21
 */
public class StockSpanner {

    List<Integer> data;
    ArrayDeque<Integer> stack;

    /**
     * 思路：单调栈，记录每个阶段的大值，当出现更大值时，栈顶出栈直至比当前值大为止
     * <p>
     * 执行耗时:23 ms,击败了87.34% 的Java用户
     * 内存消耗:49.4 MB,击败了71.27% 的Java用户
     */
    public StockSpanner() {
        data = new ArrayList<>();
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && data.get(stack.peek()) <= price) {
            stack.pop();
        }
        int index = stack.isEmpty() ? -1 : stack.peek();
        data.add(price);
        stack.push(data.size() - 1);
        return data.size() - 1 - index;
    }

    public void solve(int n) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(31));
        System.out.println(stockSpanner.next(41));
        System.out.println(stockSpanner.next(48));
        System.out.println(stockSpanner.next(59));
        System.out.println(stockSpanner.next(79));
    }

}
