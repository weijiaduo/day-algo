package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * <p>
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * <p>
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴ 。
 * <p>
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * @author weijiaduo
 * @since 2022/7/1
 */
public class DiffWaysToCompute implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object... args) {
        String expression = "2*3-4*5";
        List<Integer> result = diffWaysToCompute(expression);
        System.out.println(result);
        return result;
    }

    private List<Integer> diffWaysToCompute(String expression) {
        return merge(expression, 0, expression.length() - 1);
    }

    /**
     * 思路：二分法，以操作符为分割点，将字符串分割成左右2边，分别计算值
     * <p>
     * 执行耗时:1 ms,击败了99.54% 的Java用户
     * 内存消耗:41.1 MB,击败了59.05% 的Java用户
     */
    private List<Integer> merge(String expression, int left, int right) {
        if (left > right) {
            return new ArrayList<>(0);
        }

        List<Integer> values = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            char op = expression.charAt(i);
            if ('0' <= op && op <= '9') {
                continue;
            }

            // 按照操作符，分成左右2条表达式
            // 加记忆缓存可以提速，懒得加了，简洁点
            List<Integer> leftValues = merge(expression, left, i - 1);
            List<Integer> rightValues = merge(expression, i + 1, right);
            for (int l : leftValues) {
                for (int r : rightValues) {
                    values.add(compute(op, l, r));
                }
            }
        }
        if (values.isEmpty()) {
            // 纯数字的情况
            int num = 0;
            for (int i = left; i <= right; i++) {
                num = num * 10 + (expression.charAt(i) - '0');
            }
            values.add(num);
        }
        return values;
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
