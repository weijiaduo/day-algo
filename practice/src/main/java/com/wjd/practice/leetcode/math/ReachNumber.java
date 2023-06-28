package com.wjd.practice.leetcode.math;

/**
 * 754. 到达终点数字
 * <p>
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 你可以做一些数量的移动 numMoves :
 * <p>
 * 每次你可以选择向左或向右移动。
 * <p>
 * 第 i 次移动（从 i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * <p>
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 *
 * @author weijiaduo
 * @since 2022/11/4
 */
public class ReachNumber {

    /**
     * 思路：不会，没思路，抄官解
     * <p>
     * 复杂度：时间 O(target的次方根) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了25.27% 的Java用户
     * 内存消耗:38.1 MB,击败了78.34% 的Java用户
     */
    public int solve(int target) {
        target = Math.abs(target);
        int s = 0, n = 0;
        while (s < target || (s - target) % 2 == 1) // 没有到达（越过）终点，或者相距奇数
            s += ++n;
        return n;
    }

}
