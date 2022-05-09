package com.wjd.algorithm.practice.recruit.webank;

import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        int[] a = new int[7];
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 6; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        int count = 0;
        while (!isEmpty(a)) {
            fill(6, 6, a);
            count++;
        }
        System.out.println(count);
    }

    public static void fill(int x, int y, int[] a) {
        if (x <= 0 || y <= 0 || isEmpty(a)) {
            return;
        }

        for (int i = 6; i >= 1; i--) {
            if (a[i] > 0 && i <= x && i <= y) {
                a[i]--;
                fill(x - i, y - i, a);//右下角
                fill(x - i, i, a);//右边
                fill(i, y - i, a);//下边
                break;
            }
        }
    }

    public static boolean isEmpty(int[] a) {
        if (a == null || a.length == 0) {
            return true;
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
