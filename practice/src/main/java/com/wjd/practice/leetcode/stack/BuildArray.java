package com.wjd.practice.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 * <p>
 * 给你一个数组 target 和一个整数 n。每次迭代，需要从 list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * "Push"：从 list 中读取一个新元素， 并将其推入数组中。
 * <p>
 * "Pop"：删除数组中的最后一个元素。
 * <p>
 * 如果目标数组构建完成，就停止读取更多元素。
 * <p>
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。
 * <p>
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 *
 * @author weijiaduo
 * @since 2022/10/15
 */
public class BuildArray {

    /**
     * 思路：直接模拟栈的入栈和出栈
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了38.17% 的Java用户
     */
    public List<String> solve(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int length = target.length;
        for (int i = 0, j = 1; i < length; i++) {
            int num = target[i];
            while (j <= n) {
                ans.add("Push");
                if (j++ == num) {
                    break;
                }
                ans.add("Pop");
            }
        }
        return ans;
    }

}
