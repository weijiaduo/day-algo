package com.wjd.practice.leetcode.array.section;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * <p>
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * <p>
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 *
 * @since 2021-05-29
 */
public class MaxArea {

    /**
     * 双指针
     *
     * @param height 数组
     * @return 最大值
     */
    public int doublePoint(int[] height) {
        int lp = 0, rp = height.length - 1;
        int maxArea = 0;
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

    /**
     * 动态规划（超时）
     *
     * @param height 数组
     * @return 最大值
     */
    private int dynamic(int[] height) {
        int[] areas = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            // 最大值不包括i在内
            areas[i] = areas[i - 1];
            // 最大值包括i在内
            for (int j = 0; j < i; j++) {
                areas[i] = Math.max(calcArea(height, j, i), areas[i]);
            }
        }
        return areas[height.length - 1];
    }

    /**
     * 计算区域面积
     *
     * @param height 数组
     * @param i      索引i
     * @param j      索引j
     * @return 区域面积
     */
    private int calcArea(int[] height, int i, int j) {
        int width = Math.abs(i - j);
        int minHeight = Math.min(height[i], height[j]);
        return width * minHeight;
    }

}
