package com.wjd.practice.other.stack;

import com.wjd.practice.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算表达式结果
 *
 * @author weijiaduo
 * @since 2022/8/24
 */
public class ComputeExpression implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s = "34+13*9+44-12/3";
        int result = computeExpression(s);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：使用一个操作数栈+操作符栈。遇到优先级高的操作符，直接入栈；反之出栈计算表达式的值
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     *
     * @param s 表达式
     * @return 表达式的值
     */
    private int computeExpression(String s) {
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        Deque<Integer> operandStack = new ArrayDeque<>();
        Deque<Character> opStack = new ArrayDeque<>();
        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = s.charAt(i);

            // 解析操作数
            boolean isDigit = Character.isDigit(ch);
            if (isDigit) {
                int j = i + 1;
                while (j < n && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                operandStack.push(num);
                i = j - 1;
                if (j < n) {
                    continue;
                }
            }

            // 计算表达式，表达式最后是数字，优先级设为0
            int p = priority.getOrDefault(ch, 0);
            while (!opStack.isEmpty() && priority.get(opStack.peek()) >= p) {
                int num2 = operandStack.pop();
                int num1 = operandStack.pop();
                char operator = opStack.pop();
                int ret = compute(operator, num1, num2);
                operandStack.push(ret);
            }
            if (!isDigit) {
                opStack.push(ch);
            }
        }
        return operandStack.isEmpty() ? 0 : operandStack.pop();
    }

    private int compute(char operator, int num1, int num2) {
        int num = 0;
        switch (operator) {
            case '+':
                num = num1 + num2;
                break;
            case '-':
                num = num1 - num2;
                break;
            case '*':
                num = num1 * num2;
                break;
            case '/':
                num = num1 / num2;
                break;
            default:
                break;
        }
        return num;
    }

}
