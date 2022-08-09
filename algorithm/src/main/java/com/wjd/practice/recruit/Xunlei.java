package com.wjd.practice.recruit;

import java.util.Scanner;

public class Xunlei {

    public static void main(String[] args) {
        int red, black;
        Scanner scanner = new Scanner(System.in);
        red = scanner.nextInt();
        black = scanner.nextInt();
        scanner.close();

        System.out.println(addRedAndBlack(red, black));
    }

    /**
     * 红黑积木之和
     *
     * @param red
     * @param black
     * @return
     */
    public static int addRedAndBlack(int red, int black) {
        int sum;

        int redCount = 0;
        for (int i = 7; i > 0; i--) {
            if (red * i + black * (7 - i) < 0) {
                redCount = i;
                break;
            }
        }

        if (redCount == 0) {
            sum = black * 17;
        } else {
            if (redCount >= 3) {
                sum = red * (2 * redCount + 3) + black * (17 - 2 * redCount - 3);
            } else {
                sum = red * (3 * redCount) + black * (17 - 3 * redCount);
            }
        }

        return sum;
    }

    /**
     * 计算勾股数
     *
     * @param n
     * @return
     */
    public static int calPythagreanNum(int n) {
        if (n <= 3) {
            return 0;
        }

        int num = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (isRelative(i, j) && isRelative(j, k) && isRelative(i, j)) {
                        if (i * i + j * j == k * k) {
                            num++;
                        }
                    }
                }
            }
        }

        return num;
    }

    /**
     * 互质
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isRelative(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }

        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        if (a != 1) {
            return true;
        }

        return false;
    }
}
