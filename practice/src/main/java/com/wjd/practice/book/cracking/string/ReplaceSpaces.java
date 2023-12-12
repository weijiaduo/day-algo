package com.wjd.practice.book.cracking.string;

import com.wjd.practice.TestCase;

/**
 * 面试题 01.03. URL化
 * <p>
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * <p>
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例 1：
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * <p>
 * 示例 2：
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * <p>
 * 提示：
 * <p>
 * 字符串长度在 [0, 500000] 范围内。
 *
 * @author weijiaduo
 * @since 2023/12/12
 */
public class ReplaceSpaces {

    /**
     * 思路：倒着替换
     * <p>
     * 从后往前遍历，将每个空格替换成 %20 即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:10 ms,击败了78.51% 的Java用户
     * 内存消耗:52.5 MB,击败了40.60% 的Java用户
     */
    @TestCase(input = {
            "Mr John Smith   $", "13",
            "^              $", "6",
            "ds sdfs afs sdfa dfssf asdf            $", "27"},
            output = {"Mr%20John%20Smith",
                    "^%20%20%20%20%20",
                    "ds%20sdfs%20afs%20sdfa%20dfssf%20asdf"})
    public String replaceSpaces(String s, int length) {
        return replaceSpaces(s.toCharArray(), length);
    }

    /**
     * 替换空格为 %20
     *
     * @param s 字符数组
     * @param n 现有的字符长度
     * @return 替换后的字符串
     */
    private String replaceSpaces(char[] s, int n) {
        // 统计空格数量
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ') {
                cnt++;
            }
        }
        if (cnt == 0) {
            return new String(s);
        }

        // 替换空格
        int ns = n + 2 * cnt, k = ns;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                s[--k] = '0';
                s[--k] = '2';
                s[--k] = '%';
            } else {
                s[--k] = s[i];
            }
        }
        return new String(s, 0, ns);
    }

}
