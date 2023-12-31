package com.wjd.practice.book.cracking.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 * <p>
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
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
public class PermutationUnique {

    /**
     * 思路：排序 + 回溯
     * <p>
     * 字符数组分为 2 部分，前面是已选字符，后面是候选字符
     * <p>
     * 交换位置的时候，如果是相同字符，则不交换
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了99.24% 的Java用户
     * 内存消耗:43.5 MB,击败了8.18% 的Java用户
     */
    @TestCase(input = {"qqe", "ab", "OSS"},
            output = {"[\"eqq\",\"qeq\",\"qqe\"]", "[\"ab\", \"ba\"]",
                    "[\"OSS\",\"SOS\",\"SSO\"]"})
    public String[] backtrack(String s) {
        char[] chs = s.toCharArray();
        List<String> ret = new ArrayList<>();
        backtrack(chs, 0, ret);
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
        boolean[] visited = new boolean[256];
        for (int j = i; j < n; j++) {
            if (visited[chs[j]]) {
                // 说明前面已经交换过了，不需要重复
                continue;
            }
            visited[chs[j]] = true;
            char ch = chs[i];
            chs[i] = chs[j];
            chs[j] = ch;
            backtrack(chs, i + 1, ret);
            chs[j] = chs[i];
            chs[i] = ch;
        }
    }

}
