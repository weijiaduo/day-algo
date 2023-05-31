package com.wjd.practice.leetcode.greedy;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *
 * @since 2022/5/31
 */
public class CanJumpToEnd {

    /**
     * 贪心法
     * <p>
     * 思路：每次都走最远的距离，一直到目标点，或者无法再移动为止
     * <p>
     * 执行耗时:2 ms,击败了94.32% 的Java用户
     * 内存消耗:41.7 MB,击败了63.39% 的Java用户
     */
    public boolean canJump(int[] nums) {
        int nowEnd = 0, nextEnd = 0;
        int target = nums.length - 1;
        for (int i = 0; i < target; i++) {
            // 下次可达的最远距离
            nextEnd = Math.max(i + nums[i], nextEnd);
            if (nextEnd >= target) {
                // 已经可以跳到最后位置了，直接跳
                return true;
            }

            // 这一轮还没有遍历完
            if (i < nowEnd) {
                continue;
            }

            if (nowEnd == nextEnd) {
                // 无法继续移动，到不了最后的位置
                return false;
            } else {
                // 抵达当前的边界，更新到下个边界
                nowEnd = nextEnd;
            }
        }
        return true;
    }

}
