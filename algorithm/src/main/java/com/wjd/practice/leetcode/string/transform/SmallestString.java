package com.wjd.practice.leetcode.string.transform;

/**
 * 第 349 场周赛
 * <p>
 * 6465. 执行子串操作后的字典序最小字符串
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为：
 * <p>
 * 选则 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。
 * <p>
 * 例如，'b' 用 'a' 替换，'a' 用 'z' 替换。
 * <p>
 * 返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 现有长度相同的两个字符串 x 和 字符串 y ，在满足x[i] != y[i] 的第一个位置 i 上，
 * <p>
 * 如果 x[i] 在字母表中先于 y[i] 出现，则认为字符串 x 比字符串 y 字典序更小 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cbabc"
 * 输出："baabc"
 * 解释：我们选择从下标 0 开始、到下标 1 结束的子字符串执行操作。
 * 可以证明最终得到的字符串是字典序最小的。
 *
 * @author weijiaduo
 * @since 2023/6/11
 */
public class SmallestString {

    /**
     * 思路：只要替换一个不是以 a 开头的子串，都能够减少字典序
     * <p>
     * 而且从左往右找这种类型的子串替换的话，它得到的就是最小的字典序
     * <p>
     * 所以只要找到一个不是 a 开头的子串，替换掉它即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    public String smallestString(String s) {
        int n = s.length();
        // 找到第一个非 a 的位置
        // 注意：start 的取值范围是 [0, n-1]，至少要替换一个字母
        int start = 0;
        while (start < n - 1 && s.charAt(start) == 'a') {
            start++;
        }

        // 截止到第 2 个 a 的位置
        int end = start + 1;
        while (end < n && s.charAt(end) != 'a') {
            end++;
        }

        // 替换为前一个字母
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (start <= i && i < end) {
                if (ch == 'a') {
                    ch = 'z';
                } else {
                    ch -= 1;
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

}
