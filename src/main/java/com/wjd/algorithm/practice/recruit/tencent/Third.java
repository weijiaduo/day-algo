package com.wjd.algorithm.practice.recruit.tencent;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        int t;
        Scanner scanner =new Scanner(System.in);
        t = scanner.nextInt();
        if (t>0){
            for (int i = 0; i < t; i++) {
                int a,b,c;
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                System.out.println(isSuit(a,b,c));
            }
        }
        scanner.close();
    }

    public static String isSuit(int a, int b, int c){
        String result = "NO";

        int[] cs = new int[b];
        if (a>=1 && a<=100 && b>=1 && b<=100 && c>=0 && c<b){
            int k = 1;
            while (true){
                int t = a*k % b;
                if(t == c){
                    result = "YES";
                    break;
                }else {
                    if (cs[t] != 0){
                        break;
                    }else {
                        cs[t] = 1;
                    }
                }
                k++;
            }
        }

        return result;
    }
}
