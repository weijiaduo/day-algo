package com.wjd.practice.leetcode.array.section;

import com.wjd.practice.TestCase;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 10⁴
 * 0 <= height[i] <= 10⁵
 *
 * @since 2022/5/22
 */
public class Trap {

    /**
     * 官方解答
     * <p>
     * 思路：动态规划
     * <p>
     * 每根柱子可接的水 = min(左边最高柱子, 右边最高柱子) - 当前柱子高度
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了79.41% 的Java用户
     * 内存消耗:43 MB,击败了24.83% 的Java用户
     */
    @TestCase(input = {"[0,1,0,2,1,0,1,3,2,1,2,1]", "[4,2,0,3,2,5]"},
            output = {"6", "9"})
    public int dynamic(int[] height) {
        int n = height.length;

        // leftMax[i] 表示 i 左边柱子的最大高度
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // rightMax[i] 表示 i 右边柱子的最大高度
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 统计每根柱子可接的水
        int area = 0;
        for (int i = 0; i < n; i++) {
            area += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return area;
    }

    /**
     * 官方解答
     * <p>
     * 思路：单调栈
     * <p>
     * 递减的单调栈，遇到较大值时，一直出栈直到当前值比栈顶值小为止
     * <p>
     * 每次出栈，都统计一下出栈柱子与左右两边柱子之间的差异容量
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了41.27% 的Java用户
     * 内存消耗:44.1 MB,击败了5.00% 的Java用户
     */
    @TestCase(input = {"[0,1,0,2,1,0,1,3,2,1,2,1]", "[4,2,0,3,2,5]"},
            output = {"6", "9"})
    public int singleStack(int[] height) {
        int area = 0;
        Deque<Integer> minStack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!minStack.isEmpty() && height[minStack.peek()] < height[i]) {
                int t = minStack.pop();
                if (minStack.isEmpty()) {
                    break;
                }
                // 计算差异容量
                int j = minStack.peek();
                int w = i - j - 1;
                int h = Math.min(height[j], height[i]) - height[t];
                area += w * h;
            }
            minStack.push(i);
        }
        return area;
    }

    /**
     * 官方解答
     * <p>
     * 思路：双指针法
     * <p>
     * 动态规划用了 2 个数组 leftMax 和 rightMax，分别记录柱子左右两边的最大高度
     * <p>
     * 柱子 i 的水量等于 area[i] = min(leftMax[i], rightMax[i]) - height[i]
     * <p>
     * 假如不用数组，而是用从左右两端出发的双指针
     * <p>
     * - leftMax: 记录从左往右遍历过程中的最大值
     * <p>
     * - rightMax: 记录从右往左遍历过程中的最大值
     * <p>
     * 对于左边的指针 l 而言，如果发现 leftMax < rightMax，那么必然满足以下条件：
     * <p>
     * - leftMax[l] = leftMax
     * <p>
     * - rightMax[l] >= rightMax
     * <p>
     * 从而能得到：
     * <p>
     * area[l] = min(leftMax[l], rightMax[l]) - height[l] = leftMax - height[l]
     * <p>
     * 同理，对于右边的指针 r 而言，如果发现 rightMax < leftMax，那么就能得到：
     * <p>
     * area[r] = min(leftMax[r], rightMax[r]) - height[r] = rightMax - height[r]
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.4 MB,击败了12.91% 的Java用户
     */
    @TestCase(input = {"[0,1,0,2,1,0,1,3,2,1,2,1]", "[4,2,0,3,2,5]"},
            output = {"6", "9"})
    public int doublePoint(int[] height) {
        int area = 0;
        int n = height.length;
        int leftMax = 0, rightMax = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            leftMax = Math.max(height[l], leftMax);
            rightMax = Math.max(height[r], rightMax);
            if (leftMax < rightMax) {
                // 隐含条件：leftMax[l] = leftMax, rightMax[l] >= rightMax
                // 因此就可以知道 min(leftMax[l], rightMax[l]) = leftMax
                area += leftMax - height[l];
                l++;
            } else {
                // 隐含条件：rightMax[r] = rightMax, leftMax[r] >= leftMax
                // 因此就可以知道 min(leftMax[r], rightMax[r]) = leftMax
                area += rightMax - height[r];
                r--;
            }
        }
        return area;
    }

    /**
     * 思路：收缩双指针法
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了22.59% 的Java用户
     */
    @TestCase(input = {"[0,1,0,2,1,0,1,3,2,1,2,1]", "[4,2,0,3,2,5]"},
            output = {"6", "9"})
    public int doublePoint1(int[] height) {
        int area = 0;
        int lp = 0, rp = height.length - 1;
        while (lp < rp) {
            if (height[lp] < height[rp]) {
                // 左峰值比右峰值低，移动左指针
                int p = lp + 1;
                while (p < rp && height[p] <= height[lp]) {
                    // 寻找更高峰，或者抵达右峰值
                    p++;
                }
                area += calcArea(height, lp, p);
                lp = p;
            } else {
                // 右峰值比左峰值低，移动右指针
                int p = rp - 1;
                while (lp < p && height[p] <= height[rp]) {
                    // 寻找更高峰，或者抵达左峰值
                    p--;
                }
                area += calcArea(height, p, rp);
                rp = p;
            }
        }
        return area;
    }

    /**
     * 计算面积
     */
    private int calcArea(int[] height, int lp, int rp) {
        int area = 0;
        int h = Math.min(height[lp], height[rp]);
        while (++lp < rp) {
            area += h - height[lp];
        }
        return area;
    }

}
