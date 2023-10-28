package com.wjd.practice.leetcode.array.section;

import com.wjd.practice.TestCase;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组 height 。
 * <p>
 * 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * <p>
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * <p>
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 2 <= n <= 10⁵
 * 0 <= height[i] <= 10⁴
 *
 * @since 2021-05-29
 */
public class MaxArea {

    /**
     * 思路：双指针
     * <p>
     * 双指针分别指向两端，他们构成的容器容量 = (r - l) * Min(height[l], height[r])
     * <p>
     * 容器容量与两边界的短板有关，移动边界时，不论是移动哪一边，容器宽度 r-l 总会减一
     * <p>
     * 1、若移动短板，容器的高度 Min(h[l], h[r]) 可能会变大或变小，容量可能增大或减少
     * <p>
     * 2、若移动长板，容器的高度 Min(h[l], h[r]) 会保持不变或变小，容量肯定减少
     * <p>
     * 所以，移动长板容量肯定是不会增大的，但是移动短板就有可能增大，因此每次移动都应该移动短板
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了90.80% 的Java用户
     * 内存消耗:54.5 MB,击败了5.79% 的Java用户
     *
     * @param height 数组
     * @return 最大值
     */
    @TestCase(input = {"[1,8,6,2,5,4,8,3,7]", "[1,1]"},
            output = {"49", "1"})
    public int doublePoint(int[] height) {
        int maxArea = 0;
        int lp = 0, rp = height.length - 1;
        while (lp < rp) {
            int area;
            if (height[lp] < height[rp]) {
                area = (rp - lp) * height[lp];
                lp++;
            } else {
                area = (rp - lp) * height[rp];
                rp--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}
