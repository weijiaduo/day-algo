package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;

/**
 * 1679. K 和数对的最大数目
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * <p>
 * 返回你可以对数组执行的最大操作数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁹
 * 1 <= k <= 10⁹
 *
 * @author weijiaduo
 * @since 2023/10/5
 */
public class MaxOperations {

    /**
     * 思路：先排序，再用左右指针来寻找两数之和等于 k 的数对
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:18 ms,击败了97.07% 的Java用户
     * 内存消耗:52.36MB,击败了69.25% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4]", "5", "[3,1,3,4,3]", "6"},
            output = {"2", "1"})
    public int doublePoint(int[] nums, int k) {
        Arrays.sort(nums);

        int cnt = 0;
        int n = nums.length;
        int lp = 0, rp = n - 1;
        while (lp < rp) {
            int num = nums[lp] + nums[rp];
            if (num == k) {
                lp++;
                rp--;
                cnt++;
            } else if (num > k) {
                rp--;
            } else {
                lp++;
            }
        }
        return cnt;
    }

}
