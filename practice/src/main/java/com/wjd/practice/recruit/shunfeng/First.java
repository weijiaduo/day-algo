package com.wjd.practice.recruit.shunfeng;

public class First {

    public static void main(String[] args) {
//        String s;
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            s = scanner.next();
//            String c = find(s);
//            System.out.println(c);
//        }

        String s = "sssddwww";
        String c = find(s);
        System.out.println(c);
    }

    public static String find(String s) {
        String result = "NULL";
        if (s != null) {
            int maxLength = 0, index = -1;

            for (int i = 0; i < s.length(); i++) {
                for (int j = i + maxLength + 1; j <= s.length(); j++) {
                    String c = s.substring(i, j);
                    if (isDouble(c) && maxLength < (j - i)) {
                        index = i;
                        maxLength = j - i;
                    }
                }
            }

            if (index >= 0 && maxLength > 2) {
                result = s.substring(index, index + maxLength);
            }
        }

        return result;
    }

    public static boolean isDouble(String s){
        if (s == null || s.length() < 3){
            return false;
        }

        int fi = 0, ei = s.length() - 1;
        int preLen = s.length();
        while (fi <= ei) {
            char curFCh = s.charAt(fi), curECh = s.charAt(ei);
            int fCount = 0, eCount = 0;
            while (fi <= ei && s.charAt(fi) == curFCh) {
                fCount++;
                fi++;
            }
            while (ei >= fi && s.charAt(ei) == curECh) {
                eCount++;
                ei--;
            }
            if (fi <= ei) {
                if (fCount >= preLen || eCount >= preLen || fCount != eCount) {
                    return false;
                }
            } else {
                if (fCount == 0 || eCount != 0 || fCount>=preLen) {
                    return false;
                }
            }
            preLen = fCount;
        }

        return true;
    }
}
