package com.wjd.util;

/**
 * @author weijiaduo
 * @since 2022/10/1
 */
public final class IOUtils {

    /**
     * 解析字符串
     *
     * @param line 一行字符串
     * @param type 实际数据类型
     * @return 解析后的数据
     */
    public static Object parse(String line, Class<?> type) {
        Object ret = line;
        if (boolean.class.equals(type) || Boolean.class.equals(type)) {
            ret = toBool(line);
        } else if (char.class.equals(type) || Character.class.equals(type)) {
            ret = toChar(line);
        } else if (int.class.equals(type) || Integer.class.equals(type)) {
            ret = toInt(line);
        } else if (long.class.equals(type) || Long.class.equals(type)) {
            ret = toLong(line);
        } else if (double.class.equals(type) || Double.class.equals(type)) {
            ret = toDouble(line);
        } else if (boolean[].class.equals(type)) {
            ret = toBoolArray(line);
        } else if (Boolean[].class.equals(type)) {
            ret = toBoxBoolArray(line);
        } else if (char[].class.equals(type)) {
            ret = toCharArray(line);
        } else if (Character[].class.equals(type)) {
            ret = toBoxCharArray(line);
        } else if (int[].class.equals(type)) {
            ret = toIntArray(line);
        } else if (Integer[].class.equals(type)) {
            ret = toBoxIntArray(line);
        } else if (long[].class.equals(type)) {
            ret = toLongArray(line);
        } else if (Long[].class.equals(type)) {
            ret = toBoxLongArray(line);
        } else if (double[].class.equals(type)) {
            ret = toDoubleArray(line);
        } else if (Double[].class.equals(type)) {
            ret = toBoxDoubleArray(line);
        } else if (String[].class.equals(type)) {
            ret = toStringArray(line);
        } else if (int[][].class.equals(type)) {
            ret = toIntMatrix(line);
        }
        return ret;
    }

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
        if (line.startsWith("\"")) {
            line = line.replaceAll("\"", "");
        }
        String[] tokens = line.split(",");
        int n = tokens.length;
        String[] arr = new String[n];
        System.arraycopy(tokens, 0, arr, 0, n);
        return arr;
    }

    public static int[][] toIntMatrix(String line) {
        String[] tokens = line.split("],");
        int m = tokens.length;
        int[][] arr = new int[m][];
        for (int i = 0; i < m; i++) {
            arr[i] = toIntArray(tokens[i]);
        }
        return arr;
    }

}
