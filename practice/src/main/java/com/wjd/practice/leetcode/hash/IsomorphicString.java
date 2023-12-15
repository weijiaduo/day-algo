package com.wjd.practice.leetcode.hash;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * <p>
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "paper", t = "title"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 * 10⁴
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
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
    @TestCase(input = {"egg", "add", "foo", "bar", "paper", "title"},
            output = {"true", "false", "true"})
    public boolean hash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Character stc = s2t.get(sc);
            if (stc != null && stc != tc) {
                // 一个字符映射多个字符
                return false;
            }
            if (stc == null && t2s.containsKey(tc)) {
                // 多个字符映射一个字符
                return false;
            }
            s2t.put(sc, tc);
            t2s.put(tc, sc);
        }
        return true;
    }

    /**
     * 看到一个很有意思的解法
     * <p>
     * 思路：每个字符映射到它第一次出现的位置，
     * <p>
     * 比较两个字符时，它们映射的位置应该是一样的
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:10 ms,击败了76.78% 的Java用户
     * 内存消耗:40.9 MB,击败了97.76% 的Java用户
     */
    @TestCase(input = {"egg", "add", "foo", "bar", "paper", "title"},
            output = {"true", "false", "true"})
    public boolean indexOf(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
