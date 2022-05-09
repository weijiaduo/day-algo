package com.wjd.algorithm.practice.recruit.webank;

import java.util.Scanner;

public class First {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _N;
        _N = Integer.parseInt(in.nextLine().trim());

        res = GetResult(_N);
        System.out.println(res);
    }

    static String GetResult(int N) {
        if (N<1 || N>10000000){
            return null;
        }

        String res = null;
        int n = (int) Math.sqrt(2.0 * N);
        if (n * (n + 1) < 2 * N) {
            n++;
        }

        int num = n*(n+1)/2, i, j;
        boolean flag = n%2==0;
        if (flag){
            i = n;
            j = 1;
        }else {
            i = 1;
            j = n;
        }

        while (num > N){
            if (flag){
                i--;
                j++;
            }else {
                i++;
                j--;
            }
            num--;
        }

        res = new String(i+"/"+j);
        return res;
    }
}
