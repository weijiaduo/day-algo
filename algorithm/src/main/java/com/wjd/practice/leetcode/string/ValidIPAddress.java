package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

/**
 * 468. 验证IP地址
 * <p>
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的IP 地址，返回 "Neither" 。
 * <p>
 * @since 2022/5/29
 */
public class ValidIPAddress implements Solution<String> {

    @Override
    public String solve(Object ...args) {
        String queryIP = "20EE:Fb8:85a3:0:0:8A2E:0370:7334:12";
        String result = validIPAddress(queryIP);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：分割字符串，逐个判断
     *
     * 好恶心啊~单纯地暴力，没啥可说的，就是细节错误多
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了76.82% 的Java用户
     */
    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) {
            return "IPv4";
        } else if (isIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String queryIP) {
        if (queryIP == null || queryIP.isEmpty()) {
            return false;
        }

        // 必须以数字开头和结尾
        if (queryIP.charAt(0) == '.'
                || queryIP.charAt(queryIP.length() - 1) == '.') {
            return false;
        }

        // IPv4 分为 4 段
        String[] nums = queryIP.split("\\.");
        if (nums.length != 4) {
            return false;
        }

        for (String num : nums) {
            // 每段数字的长度满足 1 <= length <= 4
            if (num.length() < 1 || num.length() > 3) {
                return false;
            }

            // 数字不能有前导零
            if (num.length() > 1 && num.charAt(0) == '0') {
                return false;
            }

            // 每段只能是数字
            int n = 0;
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (ch < '0' || ch > '9') {
                    return false;
                }
                n = n * 10 + (ch - '0');
            }

            // 数字范围 0 <= number <= 255
            if (n < 0 || n > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String queryIP) {
        if (queryIP == null || queryIP.isEmpty()) {
            return false;
        }

        // 必须以数字开头和结尾
        if (queryIP.charAt(0) == ':'
                || queryIP.charAt(queryIP.length() - 1) == ':') {
            return false;
        }

        // 地址段数必须是8段
        String[] nums = queryIP.split(":");
        if (nums.length != 8) {
            return false;
        }

        for (String num : nums) {
            // 每段长度必须是 1 <= length <= 4
            if (num.length() < 1 || num.length() > 4) {
                return false;
            }

            // 每段只能是数字或者十六进制字母a~fA~Z
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if ('0' <= ch && ch <= '9'
                    || 'a' <= ch && ch <= 'f'
                    || 'A' <= ch && ch <= 'F') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
