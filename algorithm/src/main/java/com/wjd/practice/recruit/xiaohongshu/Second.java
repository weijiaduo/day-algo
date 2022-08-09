package com.wjd.practice.recruit.xiaohongshu;

import java.util.Scanner;

/**
 * 计算f(n) = 1!*2!*3!*...*n!结尾的0的个数
 */
public class Second {

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            n = scanner.nextInt();
            System.out.println(calTailZero(n));
        }
    }

    /**
     * 计算结尾0的数量
     *
     * @param n
     * @return
     */
    public static int calTailZero(int n){
        int num = 0;
        if (n >= 5){
            for (int i = 0; i <= n; i++) {
                num += calFiveNum(i);
            }
        }

        return num;
    }

    /**
     * 计算1～n之中包含5的数量
     *
     * @param n
     * @return
     */
    public static int calFiveNum(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
