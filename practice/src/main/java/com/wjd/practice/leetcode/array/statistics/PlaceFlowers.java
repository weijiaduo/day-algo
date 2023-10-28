package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.TestCase;

/**
 * 605. 种花问题
 * <p>
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * <p>
 * 可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * <p>
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 10⁴
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 *
 * @since 2021-06-03
 */
public class PlaceFlowers {

    /**
     * 思路：贪心法，尽量多种，判断当前位置的左右两边是否有花，没有的话则可以种下
     * <p>
     * 遇到1的时候，可以连跳2次，因为下一个位置肯定不能种花，可以加快遍历速度
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.73MB,击败了25.55% 的Java用户
     */
    @TestCase(input = {"[1,0,0,0,1]", "1", "[1,0,0,0,1]", "2"},
            output = {"true", "false"})
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) {
            return true;
        }

        // 种下 n 朵花，至少需要 2n - 1 个空间
        int length = flowerbed.length;
        if (length < 2 * n - 1) {
            return false;
        }

        int i = 0, k = n;
        while (k > 0 && i < length) {
            // 当前不为空
            if (flowerbed[i] != 0) {
                // 连跳2个，因为下一个肯定不能种花
                i += 2;
                continue;
            }

            // 右边不为空（每次都是连跳2个，所以左边肯定是空的）
            if (i + 1 < length && flowerbed[i + 1] != 0) {
                // 连跳3个位置，因为下一个是非空的
                i += 3;
                continue;
            }

            // 两边都为空，可以种花
            k--;

            // 连跳2个，跳到下一个可能种花的位置
            i += 2;
        }
        return k <= 0;
    }

}
