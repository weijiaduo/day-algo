package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * @since 2021-06-05
 * <p>
 * 717. 1比特与2比特字符
 * <p>
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10或11)来表示。
 * <p>
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 */
public class OneBitCharacter implements Solution<Boolean> {

    @Override
    public Boolean solve(Object ...args) {
        int[] bits = {1, 1, 1, 0};
        boolean result = isOneBitCharacter(bits);
        System.out.println(result);
        return result;
    }

    /**
     * 最后一个字符是否必定为一个一比特字符
     *
     * @param bits 数组
     * @return true/false
     */
    private boolean isOneBitCharacter(int[] bits) {
        if (bits.length <= 0 || bits[bits.length - 1] != 0) {
            return false;
        }
        int rp = bits.length - 2;
        while (rp >= 0) {
            if (bits[rp] == 0) {
                // 如果是00，那后面的0肯定是单独的0
                return true;
            }
            if (rp - 1 >= 0 && bits[rp - 1] == 1) {
                // 前面是11，忽略它们并继续往前找
                rp -= 2;
            } else {
                // 前面是01，那么后面的0肯定属于前面的1
                return false;
            }
        }
        return true;
    }
}
