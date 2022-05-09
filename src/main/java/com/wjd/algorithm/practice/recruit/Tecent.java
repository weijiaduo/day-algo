package com.wjd.algorithm.practice.recruit;

import java.math.BigInteger;
import java.util.Scanner;

public class Tecent {

    public static void main(String[] args) {
        BigInteger num = new BigInteger("0");
        int k, a, x, b, y;

        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        a = scanner.nextInt();
        x = scanner.nextInt();
        b = scanner.nextInt();
        y = scanner.nextInt();
        scanner.close();

        if (k < 0 || k > 1000 || a < 0 || a > 10 || x < 0 || x > 100
                || b < 0 || b > 10 || y < 0 || y > 100 || a*x + b*y < k) {
            System.out.println(-1);
            return;
        }

        if (a*x + b*y == k){
            System.out.println(0);
            return;
        }

        for (int i = 0; i <= x; i++) {
            int j = k - i * a;
            if (j >= 0 && j % b == 0 && j / b <= y) {
                num = num.add(getCombine(x, i).multiply(getCombine(y, j / b)));
            }
        }

        BigInteger bigInteger = new BigInteger(String.valueOf(1000000007));
        System.out.println(num.subtract(num.divide(bigInteger).multiply(bigInteger)));
    }

    public static BigInteger getCombine(int a, int i){
        BigInteger num = new BigInteger("1");
        for (int k = 2; k<= a; k++){
            num = num.multiply(new BigInteger(String.valueOf(k)));
        }
        for (int k=2; k<=i; k++){
            num = num.divide(new BigInteger(String.valueOf(k)));
        }
        for (int k=2; k<=a-i; k++){
            num = num.divide(new BigInteger(String.valueOf(k)));
        }
        return num;
    }
}
