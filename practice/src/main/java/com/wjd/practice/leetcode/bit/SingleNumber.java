package com.wjd.practice.leetcode.bit;

import com.wjd.practice.TestCase;

/**
 * 136. 只出现一次的数字
 * <p>
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * <p>
 * 找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：nums = [2,2,1]
 * 输出：1
 * <p>
 * 示例 2 ：
 * <p>
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * <p>
 * 示例 3 ：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * -3 * 10⁴ <= nums[i] <= 3 * 10⁴
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 *
 * @since 2021-06-28
 */
public class SingleNumber {

    /**
     * 思路：异或，将所有数字异或起来，就会只剩下只出现一次的数字
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.7 MB,击败了5.01% 的Java用户
     */
    @TestCase(input = {"[2,2,1]", "[4,1,2,1,2]", "[1]"},
            output = {"1", "4", "1"})
    public int xor(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
