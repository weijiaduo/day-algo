package com.wjd.util;

/**
 * @author weijiaduo
 * @since 2022/10/1
 */
public final class IOUtils {

    public static Boolean toBool(String line) {
        return Boolean.parseBoolean(line);
    }

    public static Character toChar(String line) {
        return line.charAt(0);
    }

    public static Integer toInt(String line) {
        return Integer.parseInt(line);
    }

    public static Long toLong(String line) {
        return Long.parseLong(line);
    }

    public static Double toDouble(String line) {
        return Double.parseDouble(line);
    }

    public static boolean[] toBoolArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        String[] tokens = line.split(",");
        int n = tokens.length;
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toBool(tokens[i]);
        }
        return arr;
    }

    public static Boolean[] toBoxBoolArray(String line) {
        boolean[] a = toBoolArray(line);
        int n = a.length;
        Boolean[] arr = new Boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static char[] toCharArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        String[] tokens = line.split(",");
        int n = tokens.length;
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toChar(tokens[i]);
        }
        return arr;
    }

    public static Character[] toBoxCharArray(String line) {
        char[] a = toCharArray(line);
        int n = a.length;
        Character[] arr = new Character[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static int[] toIntArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        String[] tokens = line.split(",");
        int n = tokens.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toInt(tokens[i]);
        }
        return arr;
    }

    public static Integer[] toBoxIntArray(String line) {
        int[] a = toIntArray(line);
        int n = a.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static long[] toLongArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        String[] tokens = line.split(",");
        int n = tokens.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toLong(tokens[i]);
        }
        return arr;
    }

    public static Long[] toBoxLongArray(String line) {
        long[] a = toLongArray(line);
        int n = a.length;
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static double[] toDoubleArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        String[] tokens = line.split(",");
        int n = tokens.length;
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toDouble(tokens[i]);
        }
        return arr;
    }

    public static Double[] toBoxDoubleArray(String line) {
        double[] a = toDoubleArray(line);
        int n = a.length;
        Double[] arr = new Double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static String[] toStringArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        String[] tokens = line.split(",");
        int n = tokens.length;
        String[] arr = new String[n];
        System.arraycopy(tokens, 0, arr, 0, n);
        return arr;
    }

}
