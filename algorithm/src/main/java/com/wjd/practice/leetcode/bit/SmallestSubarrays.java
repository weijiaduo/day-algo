package com.wjd.practice.leetcode.bit;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 6186. 按位或最大的最小子数组长度
 *
 * @author weijiaduo
 * @since 2022/9/17
 */
public class SmallestSubarrays implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int[] nums = {1, 2, 3};
        int[] result = smallestSubarrays2(nums);
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 思路：或运算，整数就32位，或运算后也不会超过32位1，找出32位中每位出现1的位置，最大索引的位置就是或值最大的
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     *
     * @param nums 数组
     * @return 最小子数组长度数组
     */
    private int[] smallestSubarrays(int[] nums) {
        // 整数低 30 位出现 1 的最小索引
        int[] indexes = new int[30];
        Arrays.fill(indexes, -1);

        int n = nums.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < 30; j++) {
                int exist = (nums[i] >>> j) & 1;
                if (exist > 0) {
                    // 当前数字有第 j 位的 1，更新索引
                    indexes[j] = i;
                } else if (indexes[j] != -1) {
                    // 找出 30 位索引的最大值
                    maxIndex = Math.max(maxIndex, indexes[j]);
                }
            }
            ans[i] = maxIndex - i + 1;
        }
        return ans;
    }

    public int[] smallestSubarrays2(int[] nums) {
        var n = nums.length;
        var ans = new int[n];
        var ors = new ArrayList<int[]>(); // 按位或的值 + 对应子数组的右端点的最小值
        for (int i = n - 1; i >= 0; --i) {
            ors.add(new int[]{0, i});
            var k = 0;
            for (var or : ors) {
                or[0] |= nums[i];
                if (ors.get(k)[0] == or[0])
                    ors.get(k)[1] = or[1]; // 合并相同值，下标取最小的
                else ors.set(++k, or);
                System.out.println(Arrays.toString(ors.get(ors.size() - 1)));
            }
            ors.subList(k + 1, ors.size()).clear();
            // 本题只用到了 ors[0]，如果题目改成任意给定数值，可以在 ors 中查找
            ans[i] = ors.get(0)[1] - i + 1;
        }
        return ans;
    }

}
