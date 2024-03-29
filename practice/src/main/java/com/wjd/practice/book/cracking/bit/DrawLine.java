package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 05.08. 绘制直线
 * <p>
 * 已知一个由像素点组成的单色屏幕，每行均有 w 个像素点，所有像素点初始为 0，左上角位置为 (0,0)。
 * <p>
 * 现将每行的像素点按照「每 32 个像素点」为一组存放在一个 int 中，再依次存入长度为 length 的一维数组中。
 * <p>
 * 我们将在屏幕上绘制一条从点 (x1,y) 到点 (x2,y) 的直线（即像素点修改为 1），请返回绘制过后的数组。
 * <p>
 * 注意：
 * <p>
 * 用例保证屏幕宽度 w 可被 32 整除（即一个 int 不会分布在两行上）
 * <p>
 * 示例1:
 * <p>
 * 输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
 * 输出：[3]
 * 解释：在第 0 行的第 30 位到第 31 位画一条直线，屏幕二进制形式表示为 [00000000000000000000000000000011]，因此
 * 返回 [3]
 * <p>
 * 示例2:
 * <p>
 * 输入：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
 * 输出：[-1, -1, -1]
 * 解释：由于二进制 11111111111111111111111111111111 的 int 类型代表 -1，因此返回 [-1,-1,-1]
 * <p>
 * 提示：
 * <p>
 * 1 <= length <= 10^5
 * 1 <= w <= 3 * 10^5
 * 0 <= x1 <= x2 < w
 * 0 <= y <= 10
 *
 * @author weijiaduo
 * @since 2023/12/27
 */
public class DrawLine {

    /**
     * 思路：线所在区域的情况可分为 2 种：
     * <p>
     * 在 1 个 int 内；跨越 2 个 int
     * <p>
     * 只要根据范围判断就行
     * <p>
     * 复杂度：时间 O(C) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.6 MB,击败了5.94% 的Java用户
     */
    @TestCase(input = {"1", "32", "30", "31", "0",
            "3", "96", "0", "95", "0",
            "24", "96", "2", "19", "5"},
            output = {"[3]",
                    "[-1,-1,-1]",
                    "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1073737728,0,0,0,0,0,0,0,0]"})
    public int[] draw(int length, int w, int x1, int x2, int y) {
        int[] ans = new int[length];
        int cnt = w / 32;
        int offset = y * cnt;
        for (int i = 0; i < cnt; i++) {
            int l = i * 32, r = (i + 1) * 32 - 1;
            if (r <= x1 || l >= x2) {
                continue;
            }
            int s = 0;
            if (l <= x1 && x2 <= r) {
                // 包含关系
                int c = x2 - x1 + 1;
                s = c == 32 ? -1 : (1 << c) - 1;
                s <<= r - x2;
            } else if (l <= x1) {
                // 右边重合
                int c = Math.min(r - x1 + 1, 32);
                s = c == 32 ? -1 : (1 << c) - 1;
            } else {
                // 左边重合
                int c = Math.min(x2 - l + 1, 32);
                s = c == 32 ? -1 : (1 << c) - 1;
                s <<= 32 - c;
            }
            ans[offset + i] = s;
        }
        return ans;
    }

}
