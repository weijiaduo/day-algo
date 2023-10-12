package com.wjd.practice.leetcode.stack;

import com.wjd.practice.leetcode.TestCase;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * <p>
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * <p>
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 * <p>
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 * <p>
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 10⁵
 * 30 <= temperatures[i] <= 100
 *
 * @author weijiaduo
 * @since 2023/6/30
 */
public class DailyTemperatures {

    /**
     * 思路：正向遍历，非递增单调栈，一直出栈直到栈顶不比当前值小为止
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:23 ms,击败了89.72% 的Java用户
     * 内存消耗:54.7 MB,击败了55.16% 的Java用户
     */
    @TestCase(input = {"[73,74,75,71,69,72,76,73]", "[30,40,50,60]", "[30,60,90]"},
            output = {"[1,1,4,2,1,1,0,0]", "[1,1,1,0]", "[1,1,0]"})
    public int[] forward(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < t) {
                int j = stack.pop();
                ans[j] = i - j;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 逆向遍历，递减单调栈，一直出栈直到栈顶比当前值大为止
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:27 ms,击败了58.98% 的Java用户
     * 内存消耗:57.2 MB,击败了5.53% 的Java用户
     */
    @TestCase(input = {"[73,74,75,71,69,72,76,73]", "[30,40,50,60]", "[30,60,90]"},
            output = {"[1,1,4,2,1,1,0,0]", "[1,1,1,0]", "[1,1,0]"})
    public int[] backward(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            int t = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= t) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }

}
