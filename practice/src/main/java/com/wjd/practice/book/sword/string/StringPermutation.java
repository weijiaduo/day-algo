package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 38. 字符串的排列
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * <p>
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class StringPermutation {

    /**
     * 思路：回溯法，将字符串分为两部分，
     * <p>
     * 第一部分是已选字符，第二部分是未选字符
     * <p>
     * 第1个位置，可选字符数量有 n 个
     * <p>
     * 第2个位置，可选字符数量有 n-1 个
     * <p>
     * 第3个位置，可选字符数量有 n-2 个
     * <p>
     * 依此类推
     * <p>
     * 复杂度：O(n!) 空间 O(n)
     */
    @TestCase(input = {"abc"},
            output = {"[abc,acb,bac,bca,cab,cba]"})
    public List<String> permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && !str.isEmpty()) {
            char[] s = str.toCharArray();
            backtrack(s, 0, res);
            Collections.sort(res);
        }
        return res;
    }

    /**
     * 回溯法遍历所有情况
     *
     * @param str   字符串
     * @param index 当前下标
     * @param res   结果集
     */
    private void backtrack(char[] str, int index, List<String> res) {
        int n = str.length;
        if (index == n - 1) {
            res.add(new String(str));
            return;
        }

        // 以 str[index] 开头的字符串
        backtrack(str, index + 1, res);
        // 以索引 index 以后的字符开头的字符串
        for (int i = index + 1; i < n; i++) {
            // 防止两个字符相同，交换没意义
            if (str[index] != str[i]) {
                char temp = str[index];
                str[index] = str[i];
                str[i] = temp;

                backtrack(str, index + 1, res);

                str[i] = str[index];
                str[index] = temp;
            }
        }
    }

}
