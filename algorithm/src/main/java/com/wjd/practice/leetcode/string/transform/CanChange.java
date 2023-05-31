package com.wjd.practice.leetcode.string.transform;

/**
 * 6114. 移动片段得到字符串
 *
 * @author weijiaduo
 * @since 2022/7/10
 */
public class CanChange {

    /**
     * 思路：模拟法，移动start的字符，逐步匹配target
     */
    public boolean canChange(String start, String target) {
        char[] ts = target.toCharArray();
        char[] ss = start.toCharArray();
        int n = target.length();
        for (int i = 0; i < n; i++) {
            char ch = ts[i];
            if (ss[i] != ch) {
                if (ch == 'R') {
                    return false;
                }
                if (ch == '_') {
                    int j = i;
                    for (; j < n; j++) {
                        if (ss[j] == 'L') {
                            return false;
                        }
                        if (ss[j] == '_') {
                            break;
                        }
                    }
                    if (j >= n) {
                        return false;
                    }
                    ss[j] = ss[i];
                    ss[i] = '_';
                }
                if (ch == 'L') {
                    int j = i;
                    for (; j < n; j++) {
                        if (ss[j] == 'R') {
                            return false;
                        }
                        if (ss[j] == 'L') {
                            break;
                        }
                    }
                    if (j >= n) {
                        return false;
                    }
                    ss[j] = ss[i];
                    ss[i] = 'L';
                }
            }
        }
        return true;
    }

}
