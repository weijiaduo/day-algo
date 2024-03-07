package com.wjd.practice.leetcode.array.transform;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 179. 最大数
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10⁹
 *
 * @author weijiaduo
 * @since 2022/7/7
 */
public class LargestNumber {

    /**
     * 思路：对数字进行排序，不是按照数值排序，而是他们从前往后的数字大小排序，大的在前，最后拼成字符串即可
     * <p>
     * 复杂度：时间 O(m * nlogn) 空间O(n)
     * <p>
     * 执行耗时:5 ms,击败了79.64% 的Java用户
     * 内存消耗:42.1 MB,击败了48.89% 的Java用户
     */
    @TestCase(input = {"[10,2]", "[3,30,34,5,9]"},
            output = {"210", "9534330"})
    public String sort(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 字典序排序
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // 拼接结果
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        // 去掉前导 0
        int i = 0;
        n = sb.length();
        while (i < n - 1 && sb.charAt(i) == '0') {
            i++;
        }
        return sb.substring(i);
    }

}
