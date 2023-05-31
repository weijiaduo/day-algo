package com.wjd.practice.leetcode.string.transform;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 颠倒字符串中的单词
 * <p>
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。
 * <p>
 * s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * @author weijiaduo
 * @since 2022/6/29
 */
public class ReverseWords {

    /**
     * 思路：先将单词翻转，然后将整条字符串翻转
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了88.30% 的Java用户
     * 内存消耗:41.1 MB,击败了66.44% 的Java用户
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), p = 0, q;
        while (p < n) {
            // 跳过连续的空格
            while (p < n && s.charAt(p) == ' ') {
                p++;
            }
            // 统计单词字符数量
            q = p;
            while (p < n && s.charAt(p) != ' ') {
                p++;
            }
            // 单词之间增加一个空格，但要避免最后的空格
            if (sb.length() > 0 && p - q > 0) {
                sb.append(' ');
            }
            // 单词倒着添加
            for (int i = p - 1; i >= q; i--) {
                sb.append(s.charAt(i));
            }
        }
        // 翻转整条字符串
        return sb.reverse().toString();
    }

    /**
     * 哈哈哈，写多了算法，API不会调用了
     * <p>
     * 官解：无情的API
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:8 ms,击败了34.54% 的Java用户
     * 内存消耗:41.6 MB,击败了10.52% 的Java用户
     */
    private String reverseWords2(String s) {
        // 去掉左右空格
        s = s.trim();
        // 按照空格拆分字符串
        List<String> list = Arrays.asList(s.split("\\s+"));
        // 翻转字符串顺序
        Collections.reverse(list);
        // 重新连接字符串
        return String.join(" ", list);
    }

}
