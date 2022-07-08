package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * <p>
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * @author weijiaduo
 * @since 2022/7/8
 */
public class RotateArray implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        return null;
    }

    private void rotate(int[] nums, int k) {
        // stepRotate(nums, k);
        // copyRotate(nums, k);
        // reverseRotate(nums, k);
        circleRotate(nums, k);
    }

    /**
     * 思路：一步一轮转，直到转完k步
     * <p>
     * 复杂度：时间O(kn) 空间O(1)
     * <p>
     * 执行耗时:783 ms,击败了12.14% 的Java用户
     * 内存消耗:57 MB,击败了38.83% 的Java用户
     *
     * @param nums 数组
     * @param k    轮转位置
     */
    private void stepRotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k = k % n;
        if (k <= 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int t = nums[n - 1];
            System.arraycopy(nums, 0, nums, 1, n - 1);
            nums[0] = t;
        }
    }

    /**
     * 思路：用一个空数组保存轮转后的顺序
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:56.7 MB,击败了79.35% 的Java用户
     *
     * @param nums 数组
     * @param k    轮转位置
     */
    private void copyRotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k = k % n;
        if (k <= 0) {
            return;
        }
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, k, n - k);
        System.arraycopy(nums, n - k, copy, 0, k);
        System.arraycopy(copy, 0, nums, 0, n);
    }

    /**
     * 思路：3次翻转，刚好得到结果
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了65.80% 的Java用户
     * 内存消耗:56.7 MB,击败了73.24% 的Java用户
     *
     * @param nums 数组
     * @param k    轮转位置
     */
    private void reverseRotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k = k % n;
        if (k <= 0) {
            return;
        }
        // 反转反转再反转~~
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * 翻转指定范围的数组元素
     *
     * @param nums  数组
     * @param left  [left, right]左边界
     * @param right [left, right]右边界
     */
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     * 官解：链式移动，执行a->b, b->c, c->d...这样链式移动，每次移动前先保存下一个位置的值，一路执行直到回到起点
     * <p>
     * 1. 链式移动必然会回到起点
     * 下一个位置是 j = (i + k) % n，在没有回到起点 i 前，必然有 j != i，而且 j 不会重复，否则通过反向逆推，就知道已经重复访问过 i。
     * 既然链式访问的元素都是没有重复的，但数组大小就只有 n，不可能无穷遍历，所以必然会回到起点。
     * 也可以理解为，如果已经遍历完了n个元素，那么下一个位置会是哪里呢？只能是起点。
     * <p>
     * 2. 每次链式移动元素总长度是最小公倍数 lcm(n, k)
     * 既然会回到起点，说明遍历了多次数组长度 n，每次遍历 k，假设访问了 a 轮数组，总共移动元素 b 个。
     * 那么就满足 an = bk，那么 an 是 n 和 k 的公倍数，因为是第一次回到起点就停止，所以 a 要尽可能小，
     * 所以 an 是 n 和 k 的最小公倍数 lcm(n,k)，因此 b = lcm(n, k) / k。
     * <p>
     * 3. 遍历次数为最大公约数 gcd(n, k)
     * 一次链式移动，不一定能够完全遍历完所有元素 n。
     * 一次链式移动，移动的元素数量 b = lcm(n, k) / k，数组元素总数是 n，
     * 那么需要执行链式移动的次数是 times = n / b = nk / lcm(n, k) = gcd(n, k)
     * <p>
     * 4. 遍历起点元素只要连续区间 [0, gcd(n, k)) 内
     * 对于被起点 i 访问的后续位置 j，满足关系 j + yn = i + xk，其中 x，y 是整数。
     * 那么 j - i = xk - yn = gcd(n, k)(xs - yt)，其中 s，t 是整数，是 k，n 的因数。
     * 对于 (xs - yt) 是整数，满足绝对值 |xs - yt| >= 1，因此有 |j - i| >= gcd(n, k)。
     * 由此可知，对于起点 i 后续访问的元素 j，必然满足 |j - i| >= gcd(n, k)。
     * 而遍历完所有元素 n，只需要遍历 gcd(n, k) 次，因此起点元素是连续区间 [0, gcd(n, k)) 的元素即可。
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了65.95% 的Java用户
     * 内存消耗:57 MB,击败了40.60% 的Java用户
     *
     * @param nums 数组
     * @param k    移动位置
     */
    private void circleRotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        int times = gcd(n, k);
        for (int i = 0; i < times; i++) {
            int cur = i, val = nums[i];
            // 一直循环到起点
            do {
                int next = (cur + k) % n;
                int temp = nums[next];
                nums[next] = val;
                val = temp;
                cur = next;
            } while (cur != i);
        }
    }

    /**
     * 最大公约数
     */
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}
