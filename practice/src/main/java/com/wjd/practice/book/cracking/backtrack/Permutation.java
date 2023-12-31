package com.wjd.practice.book.cracking.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.07. 无重复字符串的排列组合
 * <p>
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * <p>
 * 示例2:
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * <p>
 * 提示:
 * <p>
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * @author weijiaduo
 * @since 2023/12/31
 */
public class Permutation {

    /**
     * 思路：回溯
     * <p>
     * 字符数组分为 2 部分，前面是已选字符，后面是候选字符
     * <p>
     * 利用回溯法可遍历所有情况
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了99.70% 的Java用户
     * 内存消耗:53.8 MB,击败了5.41% 的Java用户
     */
    @TestCase(input = {"qwe", "ab"},
            output = {"[\"qwe\", \"qew\", \"wqe\", \"weq\", \"ewq\", \"eqw\"]",
                    "[\"ab\", \"ba\"]"})
    public String[] backtrack(String s) {
        List<String> ret = new ArrayList<>();
        backtrack(s.toCharArray(), 0, ret);
        return ret.toArray(new String[0]);
    }

    /**
     * 回溯
     *
     * @param chs 字符数组
     * @param i   待选位置下标
     * @param ret 字符串结果集
     */
    private void backtrack(char[] chs, int i, List<String> ret) {
        if (i == chs.length) {
            ret.add(new String(chs));
            return;
        }
        int n = chs.length;
        for (int j = i; j < n; j++) {
            char ch = chs[i];
            chs[i] = chs[j];
            chs[j] = ch;
            backtrack(chs, i + 1, ret);
            chs[j] = chs[i];
            chs[i] = ch;
        }
    }

}
