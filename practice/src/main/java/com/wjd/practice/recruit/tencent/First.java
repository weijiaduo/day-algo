package com.wjd.practice.recruit.tencent;

import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.close();

        System.out.println(getLCM(n));
    }

    public static int getLCM(int n){
        int result = 0;

        if (n > 0) {
            int a1m = getRR(1, n);
            int pre = n + 1;
            int m = pre + 1;
            while (true) {
                pre = getR(pre, m);
                if (pre % a1m == 0) {
                    return m;
                }
                m++;
            }
        }

        return result;
    }

    public static int getRR(int start, int end){
        if (start > end){
            return 0;
        }

        int pre = start;
        for (int i = start+1; i <= end; i++) {
            if (pre % i != 0){

            }
//            if(pre < end){
//                i = pre;
//            }
        }

        return pre;
    }

    public static int getR(int a, int b){
        int m,n,r;
        if (a>b){
            m = a;
            n = b;
        }else {
            m = b;
            n = a;
        }
        while (n!=0){
            r = m%n;
            m = n;
            n = r;
        }
        return a/m*b;
    }
}
