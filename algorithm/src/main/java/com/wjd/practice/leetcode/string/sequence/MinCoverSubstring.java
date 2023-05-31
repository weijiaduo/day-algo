package com.wjd.practice.leetcode.string.sequence;

/**
 * 76. 最小覆盖字串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。
 * <p>
 * 返回 s 中涵盖 t 所有字符的最小子串。
 * <p>
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * <p>
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * <p>
 * 输出："BANC"
 * <p>
 *
 * @since 2022/6/4
 */
public class MinCoverSubstring {

    /**
     * 计数型滑动窗口
     * <p>
     * 思路：
     * 1、先统计要覆盖的字符数量，刚好是字母，所以用128的数组足够放了
     * 2、然后再遍历s统计字符，只要全部覆盖完了就是一个可用字串
     * <p>
     * 执行耗时:2 ms,击败了96.37% 的Java用户
     * 内存消耗:41.3 MB,击败了88.68% 的Java用户
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] ns = new int[128];
        int[] nt = new int[128];
        int num = 0; // 不同的字符数量
        for (int i = 0; i < t.length(); i++) {
            if (++nt[t.charAt(i)] == 1) {
                num++;
            }
        }

        String minStr = null;
        int count = 0; // 当前已匹配的不同字符的数量
        int n = s.length(), lp = 0, rp = 0;
        while (rp < n) {
            // 统计每个字符的数量
            char ch = s.charAt(rp++);
            ns[ch]++;

            // 统计已经匹配好的字符数量
            if (ns[ch] == nt[ch]) {
                // 判断是否覆盖完了所有字符
                if (++count != num) {
                    continue;
                }
            } else {
                continue;
            }

            // 去掉前面的多余字符，收缩为最小子串
            ch = s.charAt(lp);
            while (lp < rp && ns[ch] > nt[ch]) {
                ns[ch]--;
                ch = s.charAt(++lp);
            }

            // 更换最小子串
            if (minStr == null || rp - lp < minStr.length()) {
                minStr = s.substring(lp, rp);
            }

            // 左边往前移动一位，继续探索
            // 这里可以确保 lp 指向的字符是 t 中的字符
            ns[s.charAt(lp++)]--;
            count--;
        }
        return minStr == null ? "" : minStr;
    }

}
