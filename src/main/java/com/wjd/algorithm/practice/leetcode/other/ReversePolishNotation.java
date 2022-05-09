package com.wjd.algorithm.practice.leetcode.other;

import java.util.LinkedList;

/**
 * 反向波兰语表示法
 * 算出算术表达式的结果
 */
public class ReversePolishNotation {

    private static boolean isValid = true;

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            isValid = false;
            return 0;
        }

        LinkedList<String> stack = new LinkedList<>();
        int i = 0;
        do {
            if (!tokens[i].equals("+") && !tokens[i].equals("-")
                    && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(tokens[i]);
            } else {
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                if (tokens[i].equals("+")) {
                    stack.push(String.valueOf(val2 + val1));
                } else if (tokens[i].equals("-")) {
                    stack.push(String.valueOf(val2 - val1));
                } else if (tokens[i].equals("*")) {
                    stack.push(String.valueOf(val2 * val1));
                } else if (tokens[i].equals("/")) {
                    stack.push(String.valueOf(val2 / val1));
                }
            }
            i++;
        } while (i < tokens.length);

        int result = 0;
        if (stack.size() == 1) {
            result = Integer.parseInt(stack.pop());
        } else {
            isValid = false;
        }

        return result;
    }
}
