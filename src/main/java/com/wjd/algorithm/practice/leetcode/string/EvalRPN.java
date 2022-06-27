package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 注意 两个整数之间的除法只保留整数部分。
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * @author weijiaduo
 * @since 2022/6/27
 */
public class EvalRPN implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result = evalRPN(tokens);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接用栈从左至右计算即可
     * <p>
     * 复杂度：时间 O(n)，空间 O(n)
     * <p>
     * 执行耗时:5 ms,击败了93.66% 的Java用户
     * 内存消耗:41 MB,击败了65.60% 的Java用户
     */
    private int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                }
                case "-": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                }
                case "*": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                }
                case "/": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

}
