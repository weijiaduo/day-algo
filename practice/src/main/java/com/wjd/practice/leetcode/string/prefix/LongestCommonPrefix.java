package com.wjd.practice.leetcode.string.prefix;

import com.wjd.practice.TestCase;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author weijiaduo
 * @since 2023/10/27
 */
public class LongestCommonPrefix {

    /**
     * 思路：横向对比，迭代遍历所有字符串
     * <p>
     * 先算出 2 个字符串的公共子串
     * <p>
     * 再利用公共子串和下一个字符串计算公共子串，如此迭代到结束为止
     * <p>
     * 复杂度：时间 O(nm) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了56.58% 的Java用户
     */
    @TestCase(input = {"[\"flower\",\"flow\",\"flight\"]",
            "[\"dog\",\"racecar\",\"car\"]",
            "[\"flower\",\"flower\",\"flower\",\"flower\"]"},
            output = {"fl", "", "flower"})
    public String horizontal(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        String pre = strs[0], cur;
        int n = strs.length, length = pre.length();
        for (int i = 1; i < n && length > 0; i++) {
            cur = strs[i];
            length = Math.min(cur.length(), length);
            length = prefix(pre, cur, length);
        }
        return pre.substring(0, length);
    }

    /**
     * 公共前缀的长度
     *
     * @param str1 字符串
     * @param str2 字符串
     * @param n    长度
     * @return 公共前缀的长度
     */
    private int prefix(String str1, String str2, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            ans++;
        }
        return ans;
    }

    /**
     * 思路：纵向对比
     * <p>
     * 遍历每个字符，同时对比所有字符串对应位置的字符，看是否相等
     * <p>
     * 若不相等，说明公共前缀到此为止；否则公共前缀还可以扩展
     * <p>
     * 复杂度：时间 O(nm) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了71.15% 的Java用户
     * 内存消耗:39.3 MB,击败了42.19% 的Java用户
     */
    @TestCase(input = {"[\"flower\",\"flow\",\"flight\"]",
            "[\"dog\",\"racecar\",\"car\"]",
            "[\"flower\",\"flower\",\"flower\",\"flower\"]"},
            output = {"fl", "", "flower"})
    public String vertical(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        String cmp = strs[0];
        int m = cmp.length(), n = strs.length;
        for (int i = 0; i < m; i++) {
            char ch = cmp.charAt(i);
            for (int j = 1; j < n; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return cmp.substring(0, i);
                }
            }
        }
        // 来到这里说明 cmp 完整匹配了
        return cmp;
    }

}
