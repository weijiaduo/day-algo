package com.wjd.practice.leetcode.stack;

import com.wjd.practice.TestCase;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 735. 行星碰撞
 * <p>
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
 * <p>
 * 每一颗小行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有小行星。碰撞规则：
 * <p>
 * 两个小行星相互碰撞，较小的小行星会爆炸。
 * <p>
 * 如果两颗小行星大小相同，则两颗小行星都会爆炸。
 * <p>
 * 两颗移动方向相同的小行星，永远不会发生碰撞。
 * <p>
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * <p>
 * 示例 2：
 * <p>
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * <p>
 * 示例 3：
 * <p>
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * <p>
 * 提示：
 * <p>
 * 2 <= asteroids.length <= 10⁴
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 * @author weijiaduo
 * @since 2022/7/13
 */
public class AsteroidCollision {

    /**
     * 思路：栈，遇到右移行星入栈，遇到左移行星出栈
     * <p>
     * 注意，栈顶可能是左移行星，因为右移行星有可能爆炸完了
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了96.89% 的Java用户
     * 内存消耗:42.6 MB,击败了19.46% 的Java用户
     */
    @TestCase(input = {"[5,10,-5]", "[8,-8]", "[10,2,-5]"},
            output = {"[5,10]", "[]", "[10]"})
    public int[] stack(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            // 右移行星
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }

            // 左移行星
            int top = 0, num = -asteroid;
            while (!stack.isEmpty()) {
                top = stack.peek();
                if (top < 0) {
                    // 之前的左移行星
                    break;
                }
                if (top > num) {
                    // 左行星爆炸
                    break;
                } else if (top < num) {
                    // 右行星爆炸
                    stack.pop();
                } else {
                    // 同时爆炸
                    stack.pop();
                    break;
                }
            }
            if (top < num) {
                // 左行星没爆炸
                stack.push(asteroid);
            }
        }

        int k = stack.size();
        int[] ans = new int[k];
        while (!stack.isEmpty()) {
            ans[--k] = stack.pop();
        }
        return ans;
    }

}
