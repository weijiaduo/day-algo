package com.wjd.practice.recruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Huiwei {

    public static void main(String[] args) {
        String a = "za", b="cx";
        System.out.println(bigDigitAdd26(a,b));
    }

    public static String bigDigitAdd26(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }

        if (b == null || b.length() == 0) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int c = 0;
        while (i >= 0 && j >= 0) {
            int at = a.charAt(i) - 'a';
            int bt = b.charAt(j) - 'a';
            char t = (char) ((at + bt + c) % 26 + 'a');
            sb.append(t);
            c = (at + bt + c) / 26;
            i--;
            j--;
        }

        if (i < 0 && j < 0 && c == 1) {
            char t = (char) (c + 'a');
            sb.append(t);
        }

        while (i >= 0) {
            int at = a.charAt(i) - 'a';
            char t = (char) ((at + c) % 26 + 'a');
            sb.append(t);
            c = (at + c) / 26;
            i--;
        }

        while (j >= 0) {
            int bt = b.charAt(j) - 'a';
            char t = (char) ((bt + c) % 26 + 'a');
            sb.append(t);
            c = (bt + c) / 26;
            j--;
        }

        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == 'a') {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.reverse();
        return sb.toString();
    }


    /**
     * 判断字符串in1是否包含in2所有字符
     *
     * @param in1
     * @param in2
     * @return
     */
    public static boolean isContain(String in1, String in2) {
        if (in1 == null || in2 == null || in1.length() < 5 || in2.length() < 5
                || in2.length() > in1.length()) {
            return false;
        }

        int[] num = new int[26];
        Arrays.fill(num, 0);


        for (int i = 0; i < in2.length(); i++) {
            num[in2.charAt(i) - 'A']++;
        }

        for (int i = 0; i < in1.length(); i++) {
            num[in1.charAt(i) - 'A']--;
        }

        for (int i = 0; i < 26; i++) {
            if (num[i] >= 1) {
                return false;
            }
        }

        return true;
    }


    /**
     * 将字符串in1解压成原数据，并排序
     *
     * @param in1
     * @return
     */
    public static String extract(String in1) {
        if (in1 == null) {
            return null;
        }

        List<Str> l = new ArrayList<>();
        int i = 0;
        while (i < in1.length()) {
            String s = "", num = "";

            while (i < in1.length() && in1.charAt(i) >= 'a' && in1.charAt(i) <= 'z') {
                s += in1.charAt(i++);
            }
            while (i < in1.length() && in1.charAt(i) >= '0' && in1.charAt(i) <= '9') {
                num += in1.charAt(i++);
            }

            Str str = new Str();
            str.s = s;
            str.num = Integer.parseInt(num);
            l.add(str);
        }

        return sortStr(l);
    }


    public static String sortStr( List<Str> l) {
        if (l == null) {
            return null;
        }

        Str[] la = new Str[l.size()];
        for (int i = 0; i < l.size(); i++) {
            la[i] = l.get(i);
        }
        Arrays.sort(la);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < la.length; i++) {
            sb.append(la[i]);
        }

        return sb.toString();
    }
}

class Str implements Comparable {
    public String s;
    public int num;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof Str) {
            Str oo = (Str) o;
            if (num > oo.num) {
                return 1;
            } else if (num < oo.num) {
                return -1;
            } else {
                return s.compareTo(oo.s);
            }
        }
        return 0;
    }
}
