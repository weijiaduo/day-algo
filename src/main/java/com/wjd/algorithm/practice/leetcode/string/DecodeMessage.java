package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 周赛300
 * <p>
 * 6108. 解密消息
 * <p>
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。
 * <p>
 * 解密 message 的步骤如下：
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * <p>
 * 返回解密后的消息。
 * 输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * 输出："this is a secret"
 *
 * @author weijiaduo
 * @since 2022/7/3
 */
public class DecodeMessage implements Solution<String> {

    @Override
    public String solve(Object... args) {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        String result = decodeMessage(key, message);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接长度为26的数组记录转码的字母即可
     */
    private String decodeMessage(String key, String message) {
        char[] values = new char[26];
        boolean[] flags = new boolean[26];
        int k = 0, m = key.length();
        for (int i = 0; i < m; i++) {
            char c = key.charAt(i);
            if (c == ' ' || flags[c - 'a']) {
                continue;
            }
            values[c - 'a'] = (char) ('a' + k++);
            flags[c - 'a'] = true;
            if (k == 26) {
                break;
            }
        }

        int n = message.length();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                sb.append(c);
            } else {
                sb.append(values[c - 'a']);
            }
        }
        return sb.toString();
    }
}
