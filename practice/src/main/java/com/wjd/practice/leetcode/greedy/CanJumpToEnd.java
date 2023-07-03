package com.wjd.practice.leetcode.greedy;

import com.wjd.practice.leetcode.TestCase;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * 0 <= nums[i] <= 10⁵
 *
 * @since 2022/5/31
 */
public class CanJumpToEnd {

    /**
     * 思路：贪心法，每次都走最远的距离，一直到目标点，或者无法再移动为止
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.80% 的Java用户
     * 内存消耗:42.7 MB,击败了38.31% 的Java用户
     */
    @TestCase(input = {"[2,3,1,1,4]", "[3,2,1,0,4]"},
            output = {"true", "false"})
    public boolean canJump(int[] nums) {
        int n = nums.length, dist = 0;
        for (int i = 0; i < n && dist < n; i++) {
            if (i > dist) {
                return false;
            }
            dist = Math.max(i + nums[i], dist);
        }
        return true;
    }

}
