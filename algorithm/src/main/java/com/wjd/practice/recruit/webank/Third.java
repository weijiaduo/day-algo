package com.wjd.practice.recruit.webank;

import java.util.Arrays;
import java.util.Scanner;

public class Third {

    public static void main(String[] args) {
        int n;
        Coord[] a;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if (n>0){
            a = new Coord[n];
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                a[i] = new Coord(i, x, y);
            }

            double[] res = cal(a);
            for (int i = 0; i < res.length; i++) {
                if (i>0){
                    System.out.print(" ");
                }
                System.out.printf("%.2f", res[i]);
            }
            System.out.println();
        }
    }

    public static double[] cal(Coord[] a){
        if (a==null || a.length==0){
            return null;
        }
        double[] res = new double[a.length];
        double[] dis = new double[a.length-1];

        // 按x坐标排序
        Arrays.sort(a);
        for (int i = 0; i < a.length-1; i++) {
            dis[i] = calDis(a[i], a[i+1]);
        }


        int index;
        while ((index = getMin(dis))!=-1){
            for (int i = 0; i < dis.length; i++) {
                if (dis[i] > 0){
                    a[i].r += dis[index]/2;
                    a[i+1].r += dis[index]/2;
                    dis[i] -= dis[index];
                    dis[index] = 0;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            res[a[i].id] = a[i].r;
            System.out.println(a[i].r);
        }

        return res;
    }

    public static int getMin(double[] dis) {
        int index = -1;
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] > 0 && (index == -1 || dis[index] > dis[i])) {
                index = i;
            }
        }

        return index;
    }

    static class Coord implements Comparable<Coord>{
        int id;
        int x;
        int y;
        double r=0;

        public Coord(int id, int x, int y){
            this.id = id;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coord o) {
            if (x > o.x){
                return 1;
            }else if (x < o.x){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public static double calDis(Coord a, Coord b){
        double x = (a.x-b.x);
        double y = (a.y-b.y);
        return Math.sqrt(x*x+y*y);
    }
}
