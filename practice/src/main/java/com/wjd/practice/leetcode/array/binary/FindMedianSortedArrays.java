package com.wjd.practice.leetcode.array.binary;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10⁶ <= nums1[i], nums2[i] <= 10⁶
 *
 * @author weijiaduo
 * @since 2023/6/24
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // return binary(nums1, nums2);
        return slice(nums1, nums2);
    }

    /**
     * 官方题解
     * <p>
     * 思路：二分排除法，对比 nums1[k/2 - 1] 和 nums2[k/2 - 1] 的值，分情况讨论
     * <p>
     * 1、如果 nums1[k/2 - 1] <= nums2[k/2 - 1]，则第 k 小值不可能在 nums1[0..k/2-1] 内
     * <p>
     * 2、如果 nums2[k/2 - 1] <= nums1[k/2 - 1]，则第 k 小值不可能在 nums2[0..k/2-1] 内
     * <p>
     * 然后不断进行二分排除，每次排除掉不符合要求的一小部分数据，直到遇到几种情况时才停止
     * <p>
     * 1、数组 nums1 遍历完了，此时第 k 小值等于 nums2[k - 1]
     * <p>
     * 2、数组 nums2 遍历完了，此时第 k 小值等于 nums1[k - 1]
     * <p>
     * 3、k = 1 的时候，此时第 k 小值等于 min(nums1[0], nums2[0])
     * <p>
     * 复杂度：时间 O(log(m + n)) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:43.6 MB,击败了17.33% 的Java用户
     */
    private double binary(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            int l = getKth(nums1, nums2, (m + n) / 2);
            int r = getKth(nums1, nums2, (m + n) / 2 + 1);
            return (l + r) / 2.0;
        } else {
            return getKth(nums1, nums2, (m + n) / 2 + 1);
        }
    }

    /**
     * 在有序数组 nums1 和 nums2 中寻找第 k 小的值（1<=k<=m+n）
     */
    private int getKth(int[] nums1, int[] nums2, int k) {
        int l1 = 0, h1 = nums1.length - 1;
        int l2 = 0, h2 = nums2.length - 1;
        while (k > 0) {
            // 数组 nums1 已遍历完
            if (l1 > h1) {
                return nums2[l2 + k - 1];
            }
            // 数组 nums2 已遍历完
            if (l2 > h2) {
                return nums1[l1 + k - 1];
            }
            // 第 1 小的值
            if (k == 1) {
                return Math.min(nums1[l1], nums2[l2]);
            }

            int offset = k / 2 - 1;
            int m1 = Math.min(l1 + offset, h1);
            int m2 = Math.min(l2 + offset, h2);
            if (nums1[m1] <= nums2[m2]) {
                // 第 k 小值肯定不在 nums1[l1...l1+offset] 内
                k -= m1 - l1 + 1;
                l1 = m1 + 1;
            } else {
                // 第 k 小值肯定不在 nums1[l2...l2+offset] 内
                k -= m2 - l2 + 1;
                l2 = m2 + 1;
            }
        }
        return -1;
    }

    /**
     * 官方题解
     * <p>
     * https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
     * <p>
     * 思路：划分数组，将数组 nums1 和 nums2 分别划分为 2 部分
     * <p>
     * nums1 => l1 + h1
     * <p>
     * nums2 => l2 + h2
     * <p>
     * 并且满足要求： l1 + l2 >= h1 + h2 = (m + n) / 2
     * <p>
     * 这样划分是为了拿到中位数（以偶数长度为例）：max(l1, l2) 和 min(h1, h2)
     * <p>
     * 但如果要求 max(l1, l2) 和 min(h1, h2) 是中位数，还需要满足：
     * <p>
     * max(l1, l2) <= min(h1, h2)
     * <p>
     * 一开始可能不满足要求，但只要不断调整拆分位置，就能满足这个条件。
     * <p>
     * 把这个条件拆开的话：
     * <p>
     * (1) l1 <= h1 （天然满足）
     * (2) l1 <= h2
     * (3) l2 <= h1
     * (4) l2 <= h2 （天然满足）
     * <p>
     * 所以只需要对 2、3 两种情况进行调整即可。
     * <p>
     * 复杂度：时间 O(log(min(m,n))) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了33.07% 的Java用户
     * 内存消耗:43.4 MB,击败了33.50% 的Java用户
     */
    private double slice(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            // 确保 m <= n
            return slice(nums2, nums1);
        }

        int low = 0, high = m;
        while (low <= high) {
            // l1 = nums1[0, p1-1], h1 = nums1[p1, m-1]
            // l2 = nums1[0, p2-1], h2 = nums1[p2, n-1]
            int p1 = low + (high - low) / 2;
            int p2 = (m + n + 1) / 2 - p1;
            // nums1 收缩 l1 区间
            if (p1 > 0 && p2 < n
                    && nums1[p1 - 1] > nums2[p2]) {
                high = p1 - 1;
                continue;
            }
            // nums1 扩张 l1 区间
            if (p2 > 0 && p1 < m
                    && nums2[p2 - 1] > nums1[p1]) {
                low = p1 + 1;
                continue;
            }

            // 找到满足条件的区间/其中一个数组到边界了
            int maxLeft;
            if (p1 <= 0) {
                maxLeft = nums2[p2 - 1];
            } else if (p2 <= 0) {
                maxLeft = nums1[p1 - 1];
            } else {
                maxLeft = Math.max(nums1[p1 - 1], nums2[p2 - 1]);
            }
            if ((m + n) % 2 != 0) {
                return maxLeft;
            }

            int minRight;
            if (p1 >= m) {
                minRight = nums2[p2];
            } else if (p2 >= n) {
                minRight = nums1[p1];
            } else {
                minRight = Math.min(nums1[p1], nums2[p2]);
            }
            return (maxLeft + minRight) / 2.0;
        }
        return 0.0;
    }

}
