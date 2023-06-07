package com.wjd.practice.leetcode.array.sliding;

/**
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * 提示：
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10⁵
 * s 和 t 由英文字母组成
 *
 * @author weijiaduo
 * @since 2023/6/7
 */
public class MinWindow {

    /**
     * 思路：滑动窗口
     * <p>
     * 记录 t 的字符频率以及不同字符数量
     * <p>
     * 然后用滑动窗口遍历 s，也统计字符频率以及不同字符数量
     * <p>
     * 如果 s 字符频率大于等于 t 的，且不同字符数量也一样时，此时 s 就覆盖了 t
     * <p>
     * 但是覆盖了还不行，还需要最小子串，所以需要去掉字符串左右两边不属于 t 的字符
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了98.76% 的Java用户
     * 内存消耗:42.6 MB,击败了34.44% 的Java用户
     *
     * @param s the s
     * @param t the t
     * @return the string
     */
    public String minWindow(String s, String t) {
        // 这个 s.length < t.length 还是很有用的
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 统计 t 的字符频率
        int n = s.length(), m = t.length();
        int[] tc = new int[128];
        for (int i = 0; i < m; i++) {
            tc[t.charAt(i)]--;
        }

        int minLp = -1, minRp = -1;
        int lp = 0, rp = 0, cnt = 0;
        while (rp < n) {
            // 统计每个字符的频率
            if (++tc[s.charAt(rp++)] <= 0) {
                cnt++;
            }
            // 未找到包含全部字符的窗口
            if (cnt != m) {
                continue;
            }

            // 收缩左边界，去掉多余字符
            while (tc[s.charAt(lp)] > 0) {
                tc[s.charAt(lp++)]--;
            }

            // 更新最小子串
            if (minLp == -1 || rp - lp < minRp - minLp) {
                minLp = lp;
                minRp = rp;
            }
        }
        return minLp == -1 ? "" : s.substring(minLp, minRp);
    }

}
