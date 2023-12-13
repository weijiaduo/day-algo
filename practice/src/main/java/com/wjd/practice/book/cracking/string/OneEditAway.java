package com.wjd.practice.book.cracking.string;

import com.wjd.practice.TestCase;

/**
 * 面试题 01.05. 一次编辑
 * <p>
 * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
 * <p>
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * @author weijiaduo
 * @since 2023/12/13
 */
public class OneEditAway {

    /**
     * 思路：双指针
     * <p>
     * 由于两个字符串最多只有 1 个字符的差别，
     * <p>
     * 所以它们的前后缀应该是相等的，即差异字符两边的子串应该一样
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了41.19% 的Java用户
     */
    @TestCase(input = {"pale", "ple", "pales", "pal"},
            output = {"true", "false"})
    public boolean doublePoint(String first, String second) {
        int m = first.length(), n = second.length();
        int fi = 0, fj = m - 1;
        int si = 0, sj = n - 1;
        // 前缀
        while (fi <= fj && si <= sj) {
            if (first.charAt(fi) != second.charAt(si)) {
                break;
            }
            fi++;
            si++;
        }
        // 后缀
        while (fi <= fj && si <= sj) {
            if (first.charAt(fj) != second.charAt(sj)) {
                break;
            }
            fj--;
            sj--;
        }
        // 中间的间隔不能大于 1
        return fj - fi <= 0 && sj - si <= 0;
    }

}
