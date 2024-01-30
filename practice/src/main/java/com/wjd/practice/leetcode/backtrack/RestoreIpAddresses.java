package com.wjd.practice.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * <p>
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * <p>
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 *
 * @since 2022/6/11
 */
public class RestoreIpAddresses {

    List<String> ans;

    /**
     * 思路：回溯法
     * <p>
     * 总共 4 个数字，遍历每个数字的所有情况即可
     * <p>
     * 复杂度：时间 O(3^4) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了97.62% 的Java用户
     * 内存消耗:41.4 MB,击败了34.52% 的Java用户
     */
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        backtrack(s, 0, new String[4], 0);
        return ans;
    }

    /**
     * 回溯遍历所有情况
     *
     * @param s   字符串
     * @param i   字符串起始索引
     * @param ips ip 数组
     * @param k   ip 数组索引
     */
    private void backtrack(String s, int i, String[] ips, int k) {
        if (k == ips.length && i == s.length()) {
            ans.add(String.join(".", ips));
            return;
        }
        if (k >= ips.length || i >= s.length()) {
            return;
        }

        boolean start0 = s.charAt(i) == '0';
        int n = i + (start0 ? 1 : 3);
        n = Math.min(s.length(), n);
        for (int j = i + 1; j <= n; j++) {
            String numStr = s.substring(i, j);
            int number = Integer.parseInt(numStr);
            if (number > 255) {
                break;
            }

            ips[k] = numStr;
            backtrack(s, j, ips, k + 1);
            ips[k] = null;
        }
    }

}
