package com.wjd.algorithm.practice.recruit.xiaomi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定一组字符串，每个字符串的定义如下：
 * 字符串s中包含三部分，第一部分是进制数；
 * 第二部分是分隔符"#"；
 * 第三部分是某进制下表示的数值。
 * 例如 3#12，代表的是3进制，12是3进制下的表示
 *
 * 判断各个进制数值是否存在相等，将和其他数值都不相等的数输出（输出字符串），
 * 不存在时输出"None"
 *
 * 例子：
 *
 * 输入：
 * 10#34
 * 2#100010
 * 3#12
 * END
 *
 * 输出：
 * 3#12
 *
 */
public class First {

    public static void main(String[] args) {
        String[] a = parseInput();
        find(a);
    }

    public static void find(String[] a) {
        boolean flag = false;
        if (a != null && a.length > 0) {
            int[] f = new int[a.length];
            long[] nums = new long[a.length];
            for (int i = 0; i < a.length; i++) {
                nums[i] = parse(a[i]);
            }

            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (f[j] == 0 && nums[i] == nums[j]) {
                        f[i] = -1;
                        f[j] = -1;
                    }
                }
            }

            for (int i = 0; i < a.length; i++) {
                if (f[i] == 0) {
                    flag = true;
                    System.out.println(a[i]);
                }
            }
        }

        if (!flag){
            System.out.println("None");
        }
    }

    public static String[] parseInput() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (in.hasNext()) {
            String s = in.nextLine();
            if ("END".equals(s)) {
                break;
            }
            list.add(s);
        }

        String[] a = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }

        return a;
    }

    public static long parse(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        String[] a = s.split("#");
        int radix = Integer.parseInt(a[0]);
        long num = Long.parseLong(a[1], radix);
        return num;
    }
}
