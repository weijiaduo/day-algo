package com.wjd.practice.leetcode.array.sliding;

import com.wjd.practice.leetcode.TestCase;

/**
 * 1004. 最大连续1的个数 III
 * <p>
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 *
 * @author weijiaduo
 * @since 2023/10/6
 */
public class LongestOnes {

    /**
     * 思路：滑动窗口，滑动窗口内的0数量不能大于k个
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了99.16% 的Java用户
     * 内存消耗:43.82MB,击败了81.47% 的Java用户
     */
    @TestCase(input = {"[1,1,1,0,0,0,1,1,1,1,0]", "2",
            "[0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]", "3",
            "[0,0,0,1]", "4"},
            output = {"6", "10", "4"})
    public int sliding(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        // 窗口定义 [l ,r)
        int l = 0, r = 0;
        while (r < n) {
            // 扩张窗口
            if (nums[r++] == 0) {
                k--;
            }
            // 收缩窗口
            while (k < 0) {
                if (nums[l++] == 0) {
                    k++;
                }
            }
            ans = Math.max(r - l, ans);
        }
        return ans;
    }

    /**
     * 思路：滑动窗口，窗口一直增长，不会缩小
     * <p>
     * 不过这种方式本质上不算是窗口
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了99.16% 的Java用户
     * 内存消耗:44.09MB,击败了25.78% 的Java用户
     */
    @TestCase(input = {"[1,1,1,0,0,0,1,1,1,1,0]", "2",
            "[0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]", "3",
            "[0,0,0,1]", "4"},
            output = {"6", "10", "4"})
    public int sliding2(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n) {
            if (nums[r++] == 0) {
                k--;
            }
            if (k < 0 && nums[l++] == 0) {
                k++;
            }
        }
        return r - l;
    }

    /**
     * 思路：前缀和，p[i] 表示 [0,i] 区间内的 0 的数量
     * <p>
     * 当固定右边界 p[i] 时，只要找到左边界 p[j]，满足 p[i] - p[j] <= k 即可
     * <p>
     * 寻找 j 的过程可以采用二分查找
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:32 ms,击败了8.11% 的Java用户
     * 内存消耗:43.87MB,击败了72.66% 的Java用户
     */
    @TestCase(input = {"[1,1,1,0,0,0,1,1,1,1,0]", "2",
            "[0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]", "3",
            "[0,0,0,1]", "4"},
            output = {"6", "10", "4"})
    public int prefix(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (1 - nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 窗口区间 (j - 1, i]
            int j = firstGreatEqual(prefix, 0, i + 1, prefix[i + 1] - k);
            ans = Math.max(i - j + 1, ans);
        }
        return ans;
    }

    /**
     * 第一个大于等于指定值的位置
     *
     * @param arr   数组
     * @param start 数组范围 [start, end]
     * @param end   数组范围 [start, end]
     * @param x     指定值
     * @return 满足条件的索引
     */
    private int firstGreatEqual(int[] arr, int start, int end, int x) {
        int l = start, r = end;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= x) {
                if (m == 0 || arr[m - 1] < x) {
                    return m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return end + 1;
    }

}
