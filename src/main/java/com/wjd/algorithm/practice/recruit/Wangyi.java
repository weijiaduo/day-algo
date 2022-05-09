package com.wjd.algorithm.practice.recruit;

import java.util.Arrays;
import java.util.Scanner;

public class Wangyi {

    public static void main(String[] args) {
//        int b=0,w=0;
//        String s;
//        Scanner scanner = new Scanner(System.in);
//        s =scanner.next();
//        scanner.close();
//
//        for (int i=0; i<s.length();i++){
//            if (s.charAt(i) == 'b'){
//                b++;
//            }else {
//                w++;
//            }
//        }
//
//        System.out.println(bwCal(s, b, w));

//        int t;
//        long n, k;
//        Scanner scanner = new Scanner(System.in);
//        t = scanner.nextInt();
//        for (int i=0; i<t;i++){
//            n = scanner.nextLong();
//            k = scanner.nextLong();
//            cal(n, k);
//        }
//        scanner.close();

        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        if (n < 1 || m < 1) {
            return;
        }
        int[] ns = new int[n + 1];
        int[] ms = new int[n + 1];
        int[] nums = new int[m+1];
        Arrays.fill(nums,0);
        for (int i = 1; i <= n; i++) {
            ns[i] = scanner.nextInt();
            ms[i] = scanner.nextInt();
            nums[ns[i]]++;
        }

        System.out.println(sugar(ns, ms, nums));
    }

    /**
     * 第一题
     * 斑马翻转
     *
     * @param s
     * @param b
     * @param w
     * @return
     */
    public static int bwCal(String s, int b, int w){
        if (b<0 || w<0){
            return -1;
        }

        if (b==w){
            if (s.charAt(0) == s.charAt(s.length()-1)){
                return b;
            }else{
                return b+w;
            }
        }else if (b>w){
           return w*2+1;
        }else {
            return b*2+1;
        }
    }

    /**
     * 第二题
     * n个房子，k个已住用户，求空房子左右均已住人的最小最大情况
     *
     * @param n
     * @param k
     */
    public static void cal(long n, long k) {
        if (n < 1 || k < 0 || k > n) {
            return;
        }

        long em = n - k;
        if (k == 0) {
            System.out.println(0 + " " + 0);
        } else if (em < k) {
            System.out.println(0 + " " + em);
        } else {
            System.out.println(0 + " " + (k - 1));
        }
    }


    /**
     * 第三题
     *
     * @param ns 投票人投票情况
     * @param ms 投票人策反糖果数量
     * @param nums 候选人所获投票数
     * @return
     */
    public static int sugar(int[] ns, int[] ms, int[] nums) {
        if (ns == null || ms == null || nums==null
                || ns.length < 2 || ms.length < 2 || nums.length<2) {
            return -1;
        }

        int index, num = 0;
        while (!check(nums)) {
            index = getNext(ns,ms,nums);
            num += ms[index];
            nums[ns[index]]--;
            ns[index] = 1;
            nums[1]++;

            for (int i = 1; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }

        return num;
    }

    /**
     * 下一个策反投票人
     *
     * @param ns
     * @param ms
     * @param nums
     * @return
     */
    public static int getNext(int[] ns, int[] ms, int[] nums){
        int index;

        // 最少糖果投票人
        int minSu = 1;
        for (int i = 2; i < ms.length; i++) {
            if (ns[i] != 1 && ms[i] < ms[minSu]) {
                minSu = i;
            }
        }

        // 最高票候选人
        int maxNum = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= nums[maxNum]){
                maxNum = i;
            }
        }

        // 只差一票或者最小糖果投票人所投候选人票数最高
        if (nums[1] == nums[maxNum] || nums[ns[minSu]] == nums[maxNum]){
            index = minSu;
        }else {
            // 最多票数候选人的最小糖果投票人
            int maxSu = 0, val = Integer.MAX_VALUE;
            for (int i = 1; i < ns.length; i++) {
                if (ns[i] == maxNum && ms[i] < val){
                    maxSu = i;
                    val = ms[i];
                }
            }

            index = ms[minSu]<=(ms[maxSu]>>1)?minSu:maxSu;
            //System.out.println(minSu + "," + maxSu + "," + index);
        }

        return index;
    }

    /**
     * 检验是否已经满足要求
     *
     * @param nums
     * @return
     */
    public static boolean check(int[] nums) {
        if (nums == null) {
            return false;
        }

        int val = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= nums[val]) {
                return false;
            }
        }

        return true;
    }
}
