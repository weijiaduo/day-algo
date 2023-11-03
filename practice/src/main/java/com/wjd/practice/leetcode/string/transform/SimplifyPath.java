package com.wjd.practice.leetcode.string.transform;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * <p>
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * <p>
 * 两者都可以是复杂相对路径的组成部分。
 * <p>
 * 任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * <p>
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * <p>
 * 返回简化后得到的 规范路径 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * <p>
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * <p>
 * 示例 3：
 * <p>
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例 4：
 * <p>
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 * <p>
 * 提示：
 * <p>
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 *
 * @since 2022/6/3
 */
public class SimplifyPath {

    /**
     * 思路：栈，
     * <p>
     * 遇到 .. 就出栈；
     * <p>
     * 遇到 . 就跳过；
     * <p>
     * 遇到 / 就去掉重复的 /
     * <p>
     * 其他情况正常入栈
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了99.24% 的Java用户
     * 内存消耗:41.7 MB,击败了15.51% 的Java用户
     */
    @TestCase(input = {"/home/", "/../", "/home//foo/", "/a/./b/../../c/"},
            output = {"/home", "/", "/home/foo", "/c"})
    public String stack(String path) {
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
                        if (!stack.isEmpty()) {
                            sb.setLength(stack.peek());
                        }
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
     * 思路：栈，官解不讲武德，竟然直接拆分字符串
     * <p>
     * 遇到 .. 出栈；遇到 . 不做处理；其他情况入栈
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了91.60% 的Java用户
     * 内存消耗:41.5 MB,击败了43.67% 的Java用户
     */
    @TestCase(input = {"/home/", "/../", "/home//foo/", "/a/./b/../../c/"},
            output = {"/home", "/", "/home/foo", "/c"})
    public String stack2(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
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
