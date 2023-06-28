package com.wjd.practice.leetcode.other;

/**
 * 1041. 困于环中的机器人
 * <p>
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
 * <p>
 * 北方向 是y轴的正方向。
 * 南方向 是y轴的负方向。
 * 东方向 是x轴的正方向。
 * 西方向 是x轴的负方向。
 * <p>
 * 机器人可以接受下列三条指令之一：
 * <p>
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * <p>
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 * <p>
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：instructions = "GGLLGG"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * “L”:逆时针旋转90度。位置:(0,2).方向:西。
 * “L”:逆时针旋转90度。位置:(0,2)方向:南。
 * “G”:移动一步。位置:(0,1)方向:南。
 * “G”:移动一步。位置:(0,0)方向:南。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(0,2)——>(0,1)——>(0,0)。
 * 在此基础上，我们返回true。
 * <p>
 * 提示：
 * <p>
 * 1 <= instructions.length <= 100
 * instructions[i] 仅包含 'G', 'L', 'R'
 *
 * @author weijiaduo
 * @since 2023/4/11
 */
public class RobotBounded {

    /**
     * 思路：
     * <p>
     * 1. 一轮指令以后，回到原点的话，就会永远陷入循环
     * <p>
     * 2. 一轮指令以后，不在原点，其方向可分为 4 种情况：
     * <p>
     * - 2.1 向北，也就是每轮指令后，一直是正向偏移，这样就永远不会回到原点循环
     * <p>
     * - 2.2 向南，每轮指令过后，是反向偏移，相邻 2 轮总是相反的，第 2 轮会回到原点循环
     * <p>
     * - 2.3 向东，每轮转折 90 度，4 轮过后，就会回到原点进行循环
     * <p>
     * - 2.4 向西，和向东一样
     * <p>
     * 所以，一轮指令过后，如果回到原点，或者方向不向北，就会进入循环
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了83.46% 的Java用户
     *
     * @param instructions 指令
     * @return true/false
     */
    public boolean isRobotBounded(String instructions) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int idx = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'L') {
                idx = (idx + 3) % 4;
            } else if (ch == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }
        return (x == 0 && y == 0) || idx != 0;
    }

}
