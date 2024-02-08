package com.wjd.practice.leetcode.string.compare;

import com.wjd.practice.TestCase;

/**
 * 165. 比较版本号
 * <p>
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * <p>
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。
 * <p>
 * 每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。
 * <p>
 * 修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。
 * <p>
 * 例如，2.5.33 和 0.1 都是有效的版本号。
 * <p>
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。
 * <p>
 * 比较修订号时，只需比较 忽略任何前导零后的整数值 。
 * <p>
 * 也就是说，修订号 1 和修订号 001 相等 。
 * <p>
 * 如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
 * <p>
 * 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * <p>
 * 返回规则如下：
 * <p>
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * <p>
 * 示例 2：
 * <p>
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * <p>
 * 示例 3：
 * <p>
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 <
 * version2
 * <p>
 * 提示：
 * <p>
 * 1 <= version1.length, version2.length <= 500
 * version1 和 version2 仅包含数字和 '.'
 * version1 和 version2 都是 有效版本号
 * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class CompareVersion {

    /**
     * 思路：直接按照.拆分字符串，再逐个解析数字判断大小
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了64.65% 的Java用户
     * 内存消耗:39.3 MB,击败了72.25% 的Java用户
     */
    @TestCase(input = {"1.01", "1.001", "1.0", "1.0.0", "0.1", "1.1"},
            output = {"0", "0", "-1"})
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int m = v1.length, n = v2.length;
        int max = Math.max(v1.length, v2.length);
        for (int i = 0; i < max; i++) {
            int n1 = 0;
            int n2 = 0;
            if (i < m && !"".equals(v1[i])) {
                n1 = Integer.parseInt(v1[i]);
            }
            if (i < n && !"".equals(v2[i])) {
                n2 = Integer.parseInt(v2[i]);
            }
            if (n1 == n2) {
                continue;
            }
            return Integer.compare(n1, n2);
        }
        return 0;
    }

    /**
     * 思路：从左到右识别每个版本号，然后比较
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.5 MB,击败了22.48% 的Java用户
     */
    @TestCase(input = {"1.01", "1.001", "1.0", "1.0.0", "0.1", "1.1"},
            output = {"0", "0", "-1"})
    public int compareVersion2(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            // 版本号 1
            int d1 = 0;
            while (i < n1 && version1.charAt(i) != '.') {
                d1 = d1 * 10 + (version1.charAt(i++) - '0');
            }
            // 版本号 2
            int d2 = 0;
            while (j < n2 && version2.charAt(j) != '.') {
                d2 = d2 * 10 + (version2.charAt(j++) - '0');
            }
            // 版本号比较
            if (d1 == d2) {
                i++;
                j++;
            } else if (d1 < d2) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

}
