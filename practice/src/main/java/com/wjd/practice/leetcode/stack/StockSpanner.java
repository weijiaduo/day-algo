package com.wjd.practice.leetcode.stack;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayDeque;

/**
 * 901. 股票价格的跨度
 * <p>
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * <p>
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * <p>
 * 提示：
 * <p>
 * 1 <= price <= 10⁵
 * 最多调用 next 方法 10⁴ 次
 *
 * @author weijiaduo
 * @since 2022/10/21
 */
public class StockSpanner {

    ArrayDeque<int[]> stack;
    int size;

    /**
     * 思路：递减单调栈，正向遍历，记录每个阶段的大值，当出现更大值时，栈顶出栈直至比当前值大为止
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:21 ms,击败了82.02% 的Java用户
     * 内存消耗:52.13MB,击败了25.64% 的Java用户
     */
    public StockSpanner() {
        stack = new ArrayDeque<>();
        size = 0;
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }
        int index = stack.isEmpty() ? -1 : stack.peek()[0];
        stack.push(new int[]{size++, price});
        return size - index - 1;
    }

    @TestCase(input = {"[100,80,60,70,60,75,85]"})
    public void test(int[] data) {
        StockSpanner stockSpanner = new StockSpanner();
        for (int d : data) {
            System.out.print(stockSpanner.next(d) + ", ");
        }
        System.out.println();
    }

}
