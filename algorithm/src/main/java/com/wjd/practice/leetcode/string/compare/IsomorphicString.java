package com.wjd.practice.leetcode.string.compare;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * <p>
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 * @author weijiaduo
 * @since 2022/7/14
 */
public class IsomorphicString {

    /**
     * 看到通过率，就想到了坑，但是没想到这么坑
     * <p>
     * 思路：哈希表保存映射关系，逐个字符判断是否能够逐一映射
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:7 ms,击败了87.02% 的Java用户
     * 内存消耗:41.2 MB,击败了66.99% 的Java用户
     */
    private boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> srcMap = new HashMap<>();
        Map<Character, Character> tarMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Character srcMapChar = srcMap.get(sc);
            if (srcMapChar != null) {
                // 当前字符已经映射过了
                if (srcMapChar != tc) {
                    return false;
                }
                continue;
            } else if (tarMap.containsKey(tc)) {
                // 映射字符被别的字符映射了
                return false;
            }
            srcMap.put(sc, tc);
            tarMap.put(tc, sc);
        }
        return true;
    }

    /**
     * 看到一个很有意思的解法
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:10 ms,击败了76.78% 的Java用户
     * 内存消耗:40.9 MB,击败了97.76% 的Java用户
     */
    public boolean isIsomorphic2(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
