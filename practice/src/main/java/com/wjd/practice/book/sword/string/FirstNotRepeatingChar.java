package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

/**
 * 50.1 第一个只出现一次的字符
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，
 * <p>
 * 全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * <p>
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class FirstNotRepeatingChar {

    /**
     * 思路：哈希表，
     * <p>
     * 第一轮遍历统计每个字符出现的次数
     * <p>
     * 第二轮遍历找到第一个只出现一次的字符
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"fereff"}, output = {"2"})
    public int hash(String str) {
        if (str == null || "".equals(str)) {
            return -1;
        }

        // 统计每个字符出现的次数
        int[] nums = new int[127];
        int n = str.length();
        for (int i = 0; i < n; i++) {
            nums[str.charAt(i)]++;
        }

        // 找到第一个只出现一次的字符
        for (int i = 0; i < n; i++) {
            if (nums[str.charAt(i)] == 1) {
                return i;
            }
        }

        // 没有找到
        return -1;
    }

}
