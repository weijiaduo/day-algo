package com.wjd.practice.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 735. 行星碰撞
 * <p>
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
 * <p>
 * 每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。
 * <p>
 * 碰撞规则：
 * <p>
 * 两个行星相互碰撞，较小的行星会爆炸。
 * 如果两颗行星大小相同，则两颗行星都会爆炸。
 * 两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 * @author weijiaduo
 * @since 2022/7/13
 */
public class AsteroidCollision {

    /**
     * 思路：用栈保存当前遍历到的右移行星，不断和左移行星比较
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了96.89% 的Java用户
     * 内存消耗:42.6 MB,击败了19.46% 的Java用户
     */
    private int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
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
        }

        int k = stack.size();
        int[] ans = new int[k];
        while (!stack.isEmpty()) {
            ans[--k] = stack.pop();
        }
        return ans;
    }

}
