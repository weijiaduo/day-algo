package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * <p>
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 始终以斜杠 '/' 开头。
 * <p>
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * <p>
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * <p>
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * <p>
 * @since 2022/6/3
 */
public class SimplifyPath implements Solution<String> {

    @Override
    public String solve(Object... args) {
        String path = "/a//b////c/d//././/..";
        String result = simplifyPath(path);
        System.out.println(result);
        return result;
    }

    /**
     * 执行耗时:2 ms,击败了99.24% 的Java用户
     * 内存消耗:41.7 MB,击败了15.51% 的Java用户
     */
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> stack = new LinkedList<>();
        int n = path.length();
        for (int i = 0; i < n; i++) {
            char ch = path.charAt(i);
            if (ch == '/') {
                // 忽略连续的 / 斜杠
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '/') {
                    // 添加新的 / 斜杠
                    sb.append(ch);
                    stack.push(sb.length());
                }
            } else {
                // 普通字符
                int num = 0, dot = 0;
                for (; i < n; i++) {
                    ch = path.charAt(i);
                    if (path.charAt(i) == '/') {
                        i--;
                        break;
                    }
                    if (ch == '.') {
                        dot++;
                    }
                    num++;
                    sb.append(ch);
                }

                if (num == dot && stack.size() > 0) {
                    // 如果是 . 或者 .. 时，回退到上一条 / 斜杠
                    if (1 <= dot && dot <= 2) {
                        if (dot == 2 && stack.size() > 1) {
                            stack.pop();
                        }
                        sb.setLength(stack.peek());
                    }
                }
            }
        }
        // 最后一个目录后面没有 / 斜杠
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 官解不讲武德，竟然直接拆分字符串
     *
     * 执行耗时:3 ms,击败了91.60% 的Java用户
     * 内存消耗:41.5 MB,击败了43.67% 的Java用户
     */
    public String simplifyPath2(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

}
