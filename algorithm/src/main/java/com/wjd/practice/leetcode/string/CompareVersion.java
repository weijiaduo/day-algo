package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

/**
 * 165. 比较版本号
 * <p>
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * <p>
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。
 * <p>
 * 比较修订号时，只需比较 忽略任何前导零后的整数值 。
 * <p>
 * 也就是说，修订号 1 和修订号 001 相等 。
 * <p>
 * 如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
 * <p>
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class CompareVersion implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String version1 = "0.1";
        String version2 = "1.0.0";
        int result = compareVersion(version1, version2);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接按照.拆分字符串，再逐个解析数字判断大小
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了64.65% 的Java用户
     * 内存消耗:39.3 MB,击败了72.25% 的Java用户
     */
    private int compareVersion(String version1, String version2) {
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

}
