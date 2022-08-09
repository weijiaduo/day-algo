package com.wjd.practice.recruit.huya;

import java.util.Scanner;

/**
 * 对输入数字进行加密，输入数字范围是1～5
 * 转换规则：1->4, 2->1, 3->2, 4->3, 5->5
 * 要求不能使用if, switch
 * 要求不能使用集合类(HashMap等)
 *
 * 例子：
 *
 * 输入：
 * 1 2 3 4 5
 *
 * 输出：
 * 41235
 *
 */
public class Third {

    public static int[] enArr = new int[6];

    static {
        enArr[1] = 4;
        enArr[2] = 1;
        enArr[3] = 2;
        enArr[4] = 3;
        enArr[5] = 5;
    }

    public static void main(String[] args) {
        int[] a = parseInput();
        encode(a);
    }

    public static void encode(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int[] ea = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ea[i] = enArr[a[i]];
        }

        for (int i = 0; i < ea.length; i++) {
            System.out.print(ea[i]);
        }
        System.out.println();
    }

    public static int[] parseInput() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String[] t1 = in.nextLine().split(" ");
            int[] t2 = new int[t1.length];
            for (int i = 0; i < t1.length; i++) {
                t2[i] = Integer.parseInt(t1[i]);
            }
            return t2;
        }
        return null;
    }
}
