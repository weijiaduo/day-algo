package com.wjd.algorithm.practice.recruit.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求是否能够满足要求将学生分成两个班级
 * n为幼儿园学生数量
 * m为两个不能在同一班级的学生的请求数量
 *
 */
public class Third {

    public static void main(String[] args) {
        int n, m;
        int[][] ns = null;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        if (n > 0 && m > 0) {
            ns = new int[n][n];
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                ns[x - 1][y - 1] = 1;
                ns[y - 1][x - 1] = 1;
            }
        }

        int val = isSuit(ns, n);
        System.out.println(val);
    }

    /**
     * 是否满足要求
     *
     * @param a
     * @param n
     * @return
     */
    public static int isSuit(int[][] a, int n) {
        if (a == null || n <= 0) {
            return 1;
        }

        // 记录分班情况
        int[] b = new int[n];
        Arrays.fill(b, 0);

        // 分为1班2班
        int f = 1, s = 2;
        for (int i = 0; i < n; i++) {
            if (b[i] == 0) {
                b[i] = f;
            }
            for (int j = 0; j < n; j++) {
                if (i != j && a[i][j] == 1) {
                    if (b[j] == 0) {// 没分班
                        if (b[i] == f) {
                            b[j] = s;
                        } else {
                            b[j] = f;
                        }
                    } else {// 已分班
                        if (b[i] == b[j]) {
                            return 0;
                        }
                    }
                }
            }
        }

        return 1;
    }
}