package com.wjd.practice.leetcode.array.sliding;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;

/**
 * 1456. 定长子串中元音的最大数目
 * <p>
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * <p>
 * 示例 5：
 * <p>
 * 输入：s = "tryhard", k = 4
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 *
 * @author weijiaduo
 * @since 2023/10/6
 */
public class MaxVowels {

    /**
     * 思路：滑动窗口，记录一个大小为k的窗口内的元音数量
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了99.33% 的Java用户
     * 内存消耗:41.47MB,击败了81.56% 的Java用户
     */
    @TestCase(input = {"abciiidef", "3", "aeiou", "2", "leetcode", "3", "rhythms", "4", "tryhard", "4"},
            output = {"3", "2", "2", "0", "1"})
    public int maxVowels(String s, int k) {
        int[] flg = new int[127];
        Arrays.fill(flg, 0);
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char ch : vowels) {
            flg[ch] = 1;
        }

        // 大小为k的滑动窗口计数
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += flg[s.charAt(i)];
        }
        int n = s.length(), num = ans;
        for (int i = k; i < n; i++) {
            num = num - flg[s.charAt(i - k)] + flg[s.charAt(i)];
            ans = Math.max(num, ans);
        }
        return ans;
    }

}
