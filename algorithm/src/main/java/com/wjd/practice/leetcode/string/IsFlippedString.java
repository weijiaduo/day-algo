package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

/**
 * 面试题 01.09 字符串轮转
 * <p>
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
 * <p>
 * （比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 *
 * @author weijiaduo
 * @since 2022/9/29
 */
public class IsFlippedString implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        boolean result = isFlippedString(s1, s2);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：拼接2次旋转字符串的话，判定里面是否包含原始字符串即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了91.67% 的Java用户
     */
    private boolean isFlippedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s3 = s1 + s1;
        return s3.contains(s2);
    }

}
