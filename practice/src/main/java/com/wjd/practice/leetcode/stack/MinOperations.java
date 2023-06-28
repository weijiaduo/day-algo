package com.wjd.practice.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1598. 文件夹操作日志收集器
 * <p>
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 * <p>
 * 下面给出对变更操作的说明：
 * <p>
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * <p>
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 iᵗʰ 步执行的操作。
 * <p>
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * <p>
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 * <p>
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 *
 * @author weijiaduo
 * @since 2022/9/9
 */
public class MinOperations {

    /**
     * 思路：栈，如果是../则出栈，./则丢弃，x/则入栈，最后判断栈大小
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了99.68% 的Java用户
     * 内存消耗:40.9 MB,击败了54.14% 的Java用户
     *
     * @param logs 日志数组
     * @return 返回主目录的最小步数
     */
    private int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();
        for (String log : logs) {
            if ("../".equals(log)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            if ("./".equals(log)) {
                continue;
            }
            stack.push(log);
        }
        return stack.size();
    }

    /**
     * 思路：优化方法一中的空间复杂度，不需要栈
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.68% 的Java用户
     * 内存消耗:40.6 MB,击败了92.36% 的Java用户
     *
     * @param logs 日志数组
     * @return 返回主目录的最小步数
     */
    private int minOperations2(String[] logs) {
        int step = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                if (step > 0) {
                    step--;
                }
                continue;
            }
            if ("./".equals(log)) {
                continue;
            }
            step++;
        }
        return step;
    }

}
