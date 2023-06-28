package com.wjd.practice.recruit;

import java.util.Arrays;
import java.util.Scanner;

public class ZiJieTiaoDong {

    public static void main(String[] args) {
        String s;
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        scanner.close();

        System.out.println(maxSub(s));

//        int m;
//        Scanner scanner = new Scanner(System.in);
//        m = scanner.nextInt();
//        if (m<=1 || m>=1000){
//            System.out.println(-1);
//            return;
//        }
//        int[][] matrix = new int[m][m];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
//        scanner.close();
//
//        System.out.println(calins(matrix));


//        String s;
//        Scanner scanner = new Scanner(System.in);
//        s = scanner.next();
//        scanner.close();
//
//        System.out.println(calNumIp(s));

//        int n;
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        if (n < 1){
//            System.out.println(0);
//            scanner.close();
//            return;
//        }
//        int[] utf = new int[n];
//        for (int i = 0; i < n; i++) {
//            utf[i] = scanner.nextInt();
//        }
//        scanner.close();
//
//        System.out.println(isLegalUTF8(utf));
    }

    /**
     * 第一题
     * 最长不重复子字符串
     *
     * @param s
     * @return
     */
    public static int maxSub(String s) {
        if (s == null) {
            return -1;
        }

        int[] index = new int[256];
        Arrays.fill(index, -1);

        int maxLen = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length() && i <= j) {
            int lastJ = index[s.charAt(j)];
            index[s.charAt(j)] = j;

            // 前面已出现
            if (lastJ >= i) {
                i = lastJ + 1;
            }

            if (j - i + 1 > maxLen) {
                maxLen = j - i + 1;
            }

            j++;
        }

        return maxLen;
    }


    /**
     * 第二题
     *
     * @param m
     * @return
     */
    public static int calins(int[][] m){
        if (m == null || m.length < 1 || m[0].length < 1){
            return 0;
        }

        int num = 2;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1){
                    depth(m, i, j, num);
                    num++;
                }
            }
        }

        return num-2;
    }

    public static void depth(int[][] m, int x, int y, int k){
       if (x<0 || x >= m.length || y<0 || y>=m[0].length){
           return;
       }

       if (m[x][y] == 1){
           m[x][y] = k;
           depth(m, x+1, y, k);
           depth(m, x-1, y, k);
           depth(m, x, y+1, k);
           depth(m, x, y-1, k);
       }

    }

    /**
     * 第3题
     *
     * @param s
     * @return
     */
    public static int calNumIp(String s){
        if (s == null || s.length()<4){
            return 0;
        }

        int num=0;
        int fp=1;
        int[] ip = new int[4];
        for (int i = fp; i < s.length()-2; i++) {
            for (int j = i+1; j < s.length()-1; j++) {
                for (int k = j+1; k < s.length(); k++) {
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k);
                    if (isNum(s1) && isNum(s2) && isNum(s3) && isNum(s4)){
                        ip[0] = Integer.parseInt(s1);
                        ip[1] = Integer.parseInt(s2);
                        ip[2] = Integer.parseInt(s3);
                        ip[3] = Integer.parseInt(s4);
                        if (isIp(ip)){
                            num++;
                        }
                    }
                }
            }
        }

        return num;
    }

    public static boolean isNum(String s){
        if (s == null){
            return false;
        }

        if (s.charAt(0)=='0' && s.length()>1){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c<'0' || c>'9'){
                return false;
            }
        }

        return true;
    }

    public static boolean isIp(int[] ip){
        if (ip == null || ip.length != 4){
            return false;
        }

        for (int i = 0; i < ip.length; i++) {
            if (ip[i] < 0 || ip[i]>255){
                return false;
            }
        }

        return true;
    }

    /**
     * 第4题
     *
     * @param utf
     * @return
     */
    public static int isLegalUTF8(int[] utf){
        if (utf == null || utf.length == 0){
            return 0;
        }

        int mask = 1<<7;
        if (utf.length == 1){//长度1
            if ((utf[0]&mask)!=0){
                return 0;
            }else {
                return 1;
            }
        }else {
            int len = utf.length;

            //第1字节
            for (int i=0; i<len;i++){// 前n位
                if ((utf[0]&mask) == 0){
                    return 0;
                }
                mask>>>=1;
            }
            if ((utf[0]&mask) != 0){// 第n+1位
                return 0;
            }

            //后n-1个字节
            for (int i = 1; i < len; i++) {
                mask = 1<<7;
                if ((utf[i]&mask) == 0){ //第1位
                    return 0;
                }
                mask>>>=1;
                if ((utf[i]&mask) != 0){ //第2位
                    return 0;
                }
            }

        }

        return 1;
    }

}
