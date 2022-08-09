package com.wjd.practice.recruit.huya;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 对乱序数组进行排序，同时按照指定格式输出
 * 要求不能使用java自带的排序算法，只能自己实现
 * 要求不能先排序后输出，只能边排序边输出
 *
 * 例子：
 *
 * 输入：
 * 1 1 2
 *
 * 输出：
 * [div][p]11[/p][p]2[/p][/div]
 *
 */
public class Four {

    public static void main(String[] args) {
//        int[] a = parseInput();
        int[] a = {1};
        sortAndGroup(a);
    }

    public static void sortAndGroup(int[] a) {
        if (a == null) {
            return;
        }

        int count = 0;
        System.out.print("[div]");
        for (int i = 0; i < a.length; i++) {
            int minI = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minI]) {
                    minI = j;
                }
            }
            if (i != minI) {
                int temp = a[minI];
                a[minI] = a[i];
                a[i] = temp;
            }

            if (i == 0 || (i > 0 && a[i] == a[i - 1])) {
                count++;
            }

            if (i==0 && a.length == 1){
                System.out.print("[p]");
                System.out.print(a[0]);
                System.out.print("[/p]");
            }else{
                if (i>0 && a[i] != a[i - 1] || i == a.length-1){
                    System.out.print("[p]");
                    for (int k = 0; k < count; k++) {
                        System.out.print(a[i - 1]);
                    }
                    System.out.print("[/p]");
                    count = 1;
                    if (a[i] != a[i - 1] && i == a.length-1){
                        System.out.print("[p]");
                        System.out.print(a[i]);
                        System.out.print("[/p]");
                    }
                }
            }
        }
        System.out.print("[/div]");
    }

    /**
     * 输入数据
     *
     * @return
     */
    public static int[] parseInput(){
        Scanner in = new Scanner(System.in);
        List<Integer> inList = new ArrayList<>();
        while (in.hasNext()){
            int v = in.nextInt();
            inList.add(v);
        }

        int[] a = new int[inList.size()];
        for (int i = 0; i < inList.size(); i++) {
            a[i] = inList.get(i);
        }

        return a;
    }
}
