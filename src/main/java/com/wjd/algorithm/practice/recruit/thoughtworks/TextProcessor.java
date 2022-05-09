package com.wjd.algorithm.practice.recruit.thoughtworks;

public class TextProcessor {

    public static void main(String[] args) {
        String text = "So  many whitecharacters sd swareads";
        System.out.println(process(text, 10));
    }

    public static String process(String text, int width) {
        if (!isValid(text)) {
            return "ERROR: Invalid character detected!";
        }
        if (width < 10 || width > 80) {
            return "ERROR: width out of range!";
        }

        StringBuilder sb = new StringBuilder();
        int row = 1, k, lastIndex;
        for (int i = 0; i < text.length(); i = k) {
            k = i;
            lastIndex = row * width;
            if (text.charAt(k) == ' ') {
                while (k < text.length() && text.charAt(k) == ' ') {
                    k++;
                }
                if (k >= lastIndex) { // 过长空白字符串拆分
                    k = lastIndex;
                    sb.append(text.substring(i, k) + "(" + (row++) + ");");
                } else {
                    sb.append(text.substring(i, k) + "(" + row + ");");
                }
            } else {
                while (k < text.length() && text.charAt(k) != ' ') {
                    k++;
                }
                if (k >= lastIndex) { // 过长单词不拆分，同时计算跨越行数
                    sb.append(text.substring(i, k) + "(" + row);
                    for (int j = 0; j < 1 + (k - lastIndex + 1) / width; j++) {
                        sb.append("," + (++row));
                    }
                    sb.append(");");
                } else {
                    sb.append(text.substring(i, k) + "(" + row + ");");
                }
            }
        }

        return sb.toString();
    }

    /**
     * 验证字符串是否符合要求
     *
     * @param text
     * @return
     */
    public static boolean isValid(String text) {
        if (text == null) {
            return false;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!(ch == ' ' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }

        return true;
    }

}
