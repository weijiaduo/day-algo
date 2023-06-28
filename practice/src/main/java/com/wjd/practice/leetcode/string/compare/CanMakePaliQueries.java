package com.wjd.practice.leetcode.string.compare;

import java.util.ArrayList;
import java.util.List;

/**
 * 1177. 构建回文串检测
 * <p>
 * 给你一个字符串 s，请你对 s 的子串进行检测。
 * <p>
 * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。
 * <p>
 * 我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。
 * <p>
 * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 * <p>
 * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 * <p>
 * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，
 * <p>
 * 也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。
 * <p>
 * （另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
 * <p>
 * 示例：
 * <p>
 * 输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * 输出：[true,false,false,true,true]
 * 解释：
 * queries[0] : 子串 = "d"，回文。
 * queries[1] :子串 = "bc"，不是回文。
 * queries[2] :子串 = "abcd"，只替换 1 个字符是变不成回文串的。
 * queries[3] :子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd"
 * 替换为 "ab"。
 * queries[4] :子串 = "abcda"，可以变成回文的 "abcba"。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s 中只有小写英文字母
 *
 * @author weijiaduo
 * @since 2023/6/15
 */
public class CanMakePaliQueries {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        return prefix(s, queries);
    }

    /**
     * 思路：因为子串的字符能够重新排列，所以，
     * <p>
     * 当至多有1个字符频率是奇数，其余字符的频率都是偶数时，就能构成回文串
     * <p>
     * 所以只需要统计子串的字符频率即可
     * <p>
     * 另外，每替换一次字符，实际上可以消减2个单数字符，还要加上这个逻辑
     * <p>
     * 复杂度：时间 O(nm) 空间 O(n)
     * <p>
     * Time Limit Exceeded
     */
    private List<Boolean> count(String s, int[][] queries) {
        int n = queries.length;
        List<Boolean> ans = new ArrayList<>(n);
        for (int[] query : queries) {
            int l = query[0], r = query[1], t = query[2];
            int odds = 0;
            int[] cnt = new int[26];
            for (int i = l; i <= r; i++) {
                int idx = s.charAt(i) - 'a';
                cnt[idx] = 1 - cnt[idx];
                if (cnt[idx] == 1) {
                    odds++;
                } else {
                    odds--;
                }
            }
            // 减去可替换的次数，替换一次可以减去 2 个单数字符
            odds -= 2 * t;
            // 频率为单数的字符数量小于等于 1 时，就能构成回文串
            ans.add(odds <= 1);
        }
        return ans;
    }

    /**
     * 思路：前缀数组记录字母的奇偶次数
     * <p>
     * pre[i] 表示 [0, i] 的所有字母奇偶次数，用 32 位整数记录 26 个字母的奇偶， 1是奇数，0是偶数
     * <p>
     * 那么区间 [l, r] 的字母奇偶次数可通过异或操作得出： pre[l - 1] ^ pre[r]
     * <p>
     * 复杂度：时间 O(n + m) 空间 O(n)
     * <p>
     * 执行耗时:6 ms,击败了99.22% 的Java用户
     * 内存消耗:95.1 MB,击败了37.98% 的Java用户
     */
    private List<Boolean> prefix(String s, int[][] queries) {
        // 统计前缀和数组
        int n = s.length();
        int[] pre = new int[n];
        for (int i = 0, bits = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            bits ^= 1 << idx;
            pre[i] = bits;
        }

        // 根据前缀和判断字符的奇偶次数
        List<Boolean> ans = new ArrayList<>(n);
        for (int[] query : queries) {
            int l = query[0], r = query[1], t = query[2];
            int odds = l > 0 ? pre[l - 1] ^ pre[r] : pre[r];
            odds = Integer.bitCount(odds);
            // 减去可替换的次数，替换一次可以减去 2 个单数字符
            odds -= 2 * t;
            // 频率为单数的字符数量小于等于 1 时，就能构成回文串
            ans.add(odds <= 1);
        }
        return ans;
    }

}
