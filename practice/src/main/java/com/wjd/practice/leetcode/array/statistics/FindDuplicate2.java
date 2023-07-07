package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.leetcode.TestCase;

/**
 * 287. 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10⁵
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * <p>
 * 进阶：
 * <p>
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 *
 * @author weijiaduo
 * @since 2023/7/7
 */
public class FindDuplicate2 {

    /**
     * 官方题解
     * <p>
     * 思路：二分法，定义 cnt[i] 表示小于等于 i 的数量
     * <p>
     * 如果没有重复数字，那么始终有 cnt[i] = i
     * <p>
     * 如果有重复数字，那么 cnt[i] != i
     * <p>
     * 若 cnt[i] > i，表明重复数字小于 i
     * <p>
     * 若 cnt[i] <= i，表明重复数字大于等于 i
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:25 ms,击败了33.30% 的Java用户
     * 内存消耗:55.2 MB,击败了65.40% 的Java用户
     */
    @TestCase(input = {"[1,3,4,2,2]", "[3,1,3,4,2]", "[2,2,2,2,2]", "[1,1]"},
            output = {"2", "3", "2", "1"})
    public int binary(int[] nums) {
        int ans = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：位计数，统计数字在每个 bit 的数量，比如 x
     * <p>
     * 然后再根据每个 bit 在实际 n 中有多少个，比如 y
     * <p>
     * 如果 x > y，则说明这个位是重复数字的
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:47 ms,击败了5.49% 的Java用户
     * 内存消耗:55 MB,击败了78.61% 的Java用户
     */
    @TestCase(input = {"[1,3,4,2,2]", "[3,1,3,4,2]", "[2,2,2,2,2]", "[1,1]"},
            output = {"2", "3", "2", "1"})
    public int bitCount(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int bits = 32, mask = 1 << 31;
        while ((n & mask) == 0) {
            mask >>>= 1;
            bits--;
        }
        for (int i = 0; i < bits; i++) {
            int x = 0, y = 0;
            mask = 1 << i;
            for (int j = 0; j < n; j++) {
                if ((nums[j] & mask) != 0) {
                    x++;
                }
                if (j > 0 && (j & mask) != 0) {
                    y++;
                }
            }
            if (x > y) {
                ans |= mask;
            }
        }
        return ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：Floyd 判圈算法
     * <p>
     * 对 nums 数组建图，边是 i -> nums[i]
     * <p>
     * 如果存在重复数字，那么就会有多条边指向重复数字
     * <p>
     * 因此整个图肯定存在环，并且重复数字就在环的入口位置
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了92.94% 的Java用户
     * 内存消耗:55 MB,击败了85.28% 的Java用户
     */
    @TestCase(input = {"[1,3,4,2,2]", "[3,1,3,4,2]", "[2,2,2,2,2]", "[1,1]"},
            output = {"2", "3", "2", "1"})
    public int cycle(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
