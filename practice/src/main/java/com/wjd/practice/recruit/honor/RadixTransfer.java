package com.wjd.practice.recruit.honor;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 一般进制数
 * <p>
 * [base#]n 表示进制为 base，值为 n 的进制数，比如
 * <p>
 * 11#10，表示进制为 11，值为 10，对应的十进制值是 11
 * <p>
 * 64#a，表示进制为 64，值为 a，对应的十进制值是 10
 * <p>
 * base 的范围是 [2, 64]。
 * <p>
 * 假如没有 [base#] 部分，则按照普通的进制数来判断：
 * <p>
 * 若以 0x 或 0X 开头，则是 16 进制
 * <p>
 * 若以 0 开头，则是 8 进制
 * <p>
 * 否则是 10 进制
 * <p>
 * 给定一个字符串，输出其 10 进制的值
 * <p>
 * 如果字符串格式不正确，则输出 ERROR
 *
 * @author weijiaduo
 * @since 2023/12/30
 */
public class RadixTransfer {

    /**
     * 思路：解析字符串，判断进制基数，然后把剩余的数字转成 10 进制数
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"10", "11#10", "090", "10000000000", "64#@", "64#_"},
            output = {"10", "11", "ERROR", "10000000000", "62", "63"})
    public String transfer(String s) {
        // 进制数编码
        String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@_";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < codes.length(); i++) {
            map.put(codes.charAt(i), i);
        }

        // 解析进制基数
        int base = 10;
        int index = s.indexOf("#");
        if (index == 0) {
            base = -1;
        } else if (index > 0) {
            base = Integer.parseInt(s.substring(0, index));
            s = s.substring(index + 1);
        } else if (s.startsWith("0x") || s.startsWith("0X")) {
            base = 16;
            s = s.substring(2);
        } else if (s.length() > 1 && s.startsWith("0")) {
            base = 8;
            s = s.substring(1);
        }
        // 超出进制范围
        if (base < 2 || base > 64 || s.length() == 0) {
            return "ERROR";
        }

        // 转换成 10 进制数
        long number = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            int d = map.getOrDefault(s.charAt(i), -1);
            if (d < 0 || d > base) {
                // 超出进制基数范围
                return "ERROR";
            }
            number = number * base + d;
        }
        return Long.toString(number);
    }

}
