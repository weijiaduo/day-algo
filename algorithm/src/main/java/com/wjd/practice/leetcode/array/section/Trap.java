package com.wjd.practice.leetcode.array.section;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 *
 * @since 2022/5/22
 */
public class Trap {

    /**
     * 收缩双指针法
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了22.59% 的Java用户
     */
    public int trap(int[] height) {
        int area = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                // 左峰值比右峰值低，移动左指针
                int p = left + 1;
                while (p < right && height[p] <= height[left]) {
                    // 寻找更高峰，或者抵达右峰值
                    p++;
                }
                area += calcArea(height, left, p);
                left = p;
            } else {
                // 右峰值比左峰值低，移动右指针
                int q = right - 1;
                while (left < q && height[q] <= height[right]) {
                    // 寻找更高峰，或者抵达左峰值
                    q--;
                }
                area += calcArea(height, q, right);
                right = q;
            }
        }
        return area;
    }

    /**
     * 计算面积
     */
    private int calcArea(int[] height, int left, int right) {
        int area = 0;
        int h = Math.min(height[left], height[right]);
        while (++left < right) {
            area += h - height[left];
        }
        return area;
    }
}
