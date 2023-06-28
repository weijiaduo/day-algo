package com.wjd.practice.leetcode.array.transform;

/**
 * 1470. 重新排列数组
 * <p>
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 *
 * @author weijiaduo
 * @since 2022/8/29
 */
public class Shuffle {

    /**
     * 思路：双指针分别指向x和y序列，然后按照重排列格式放进新数组即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了67.25% 的Java用户
     *
     * @param nums 数组
     * @param n    数组长度/2
     * @return 新数组
     */
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] newNums = new int[len];
        int xp = 0, yp = n;
        for (int i = 0; i < len; i += 2) {
            newNums[i] = nums[xp++];
            newNums[i + 1] = nums[yp++];
        }
        return newNums;
    }

}
