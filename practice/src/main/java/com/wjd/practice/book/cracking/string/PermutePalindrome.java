package com.wjd.practice.book.cracking.string;

import com.wjd.practice.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.04. 回文排列
 * <p>
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author weijiaduo
 * @since 2023/12/13
 */
public class PermutePalindrome {

    /**
     * 思路：消消对法，遇到两个相同的字符就消去
     * <p>
     * 如果最后剩下的字符数量 <= 1，那么说明它可以构成回文对
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了87.15% 的Java用户
     */
    @TestCase(input = {"tactcoa"},
            output = {"true"})
    public boolean hash(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!set.add(ch)) {
                set.remove(ch);
            }
        }
        return set.size() <= 1;
    }

}
