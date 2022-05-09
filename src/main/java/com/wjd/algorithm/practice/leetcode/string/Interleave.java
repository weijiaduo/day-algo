package com.wjd.algorithm.practice.leetcode.string;

/**
 * 验证一个字符串是否由另外两个字符串交叉得到
 */
public class Interleave {

    public static void main(String[] args) {
        String s1 = "aabs";
        String s2 = "dbba";
        String s3 = "aadbbbsa";

        System.out.println(isInterleave(s1,s2,s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if ((s1 != null || s2 != null) && s3 == null) {
            return false;
        }
        if ((s1 == null || s2 == null) && s3 != null) {
            return false;
        }
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        }
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        if (s1.isEmpty() && !s2.equals(s3)|| s2.isEmpty() && !s1.equals(s3)){
            return false;
        }

        int[][] a = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                a[i][j] = 0;
            }
        }

        a[0][0] = 1;
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1) && a[i-1][0] == 1){
                a[i][0] = 1;
            }else {
                a[i][0] = 0;
            }
        }
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j-1) == s3.charAt(j-1) && a[0][j-1] == 1){
                a[0][j] = 1;
            }else {
                a[0][j] = 0;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s3.charAt(i+j-1) == s1.charAt(i-1) && a[i-1][j] == 1
                        || s3.charAt(i+j-1) == s2.charAt(j-1) && a[i][j-1] == 1){
                    a[i][j] = 1;
                }else {
                    a[i][j] = 0;
                }
            }
        }

        if (a[s1.length()][s2.length()] == 1){
            return true;
        }

        return false;
    }
}
