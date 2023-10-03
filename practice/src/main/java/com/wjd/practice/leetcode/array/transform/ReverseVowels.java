package com.wjd.practice.leetcode.array.transform;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;

/**
 * 345. 反转字符串中的元音字母
 * <p>
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 10⁵
 * s 由 可打印的 ASCII 字符组成
 *
 * @author weijiaduo
 * @since 2023/10/3
 */
public class ReverseVowels {

    /**
     * 思路：左右双指针，左右两边分别找到元音字母，然后交换即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了97.58% 的Java用户
     * 内存消耗:41.97MB,击败了23.35% 的Java用户
     */
    @TestCase(input = {"hello", "leetcode"},
            output = {"holle", "leotcede"})
    public String reverseVowels(String s) {
        // 标记元音字母位置（其实改成 static 也行）
        boolean[] flg = new boolean[256];
        Arrays.fill(flg, false);
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char v : vowels) {
            flg[v] = true;
        }

        // 左右双指针寻找元音字母交换
        char[] chs = s.toCharArray();
        int left = 0, right = chs.length - 1;
        while (left < right) {
            while (left < right && !flg[chs[left]]) {
                left++;
            }
            while (right > left && !flg[chs[right]]) {
                right--;
            }
            if (left < right) {
                // ps: 交换后需移动左右指针
                char ch = chs[left];
                chs[left++] = chs[right];
                chs[right--] = ch;
            }
        }
        return new String(chs);
    }

}
