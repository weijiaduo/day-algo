package com.wjd.practice.recruit.xiaohongshu;

public class Mianshi {

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        int s = 3;
        System.out.println(find(a, s));
        System.out.println(finds(a, s));
    }

    public static int find(int[] a, int s){
        int res = 0;

        if (a!=null && a.length>0){
            res = dep(a, 0, 0, s);
        }

        return res;
    }

    public static int dep(int[] a, int k, int num, int s){
        if (a.length == k){
            if (num == s){
                return 1;
            }else {
                return 0;
            }
        }

        int res = 0;
        res += dep(a, k+1, num+a[k], s);
        res += dep(a, k+1, num-a[k], s);

        return res;
    }

    public static int finds(int[] a, int s){
        int res = 0;

        if (a!=null && a.length>0){
            int sum = 0;
            for (int i : a) {
                sum+= i;
            }
            if (s<=sum && ((sum + s)&1) == 0){
                res = dp2(a, (sum + s) >>> 1);
            }
        }

        return res;
    }

    public static int dp(int[] a, int target){
        int[][] d = new int[a.length+1][target+1];
        d[0][0] = 1;
        for (int i = 1; i <= target; i++) {
            d[0][i] = 0;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 0; j <= target; j++) {
                d[i][j] = d[i-1][j];
                if (j - a[i-1] >= 0){
                    d[i][j] += d[i-1][j-a[i-1]];
                }
            }
        }

        return d[a.length][target];
    }

    public static int dp2(int[] a, int target){
        int[] d = new int[target+1];
        d[0] = 1;
        for (int i = 1; i <= target; i++) {
            d[i] = 0;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = target; j >= a[i-1]; j--) {
                d[j] += d[j-a[i-1]];
            }
        }

        return d[target];
    }
}
