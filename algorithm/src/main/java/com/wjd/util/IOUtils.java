package com.wjd.util;

import com.wjd.structure.tree.binary.TreeNode;
import com.wjd.structure.tree.general.Node;

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
        } else if (String.class.equals(type)) {
            ret = toStr(line);
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
        } else if (TreeNode.class.equals(type)) {
            Integer[] values = toBoxIntArray(line);
            ret = TreeNode.build(values);
        } else if (Node.class.equals(type)) {
            Integer[] values = toBoxIntArray(line);
            ret = Node.build(values);
        }
        return ret;
    }

    public static Boolean toBool(String line) {
        try {
            return Boolean.parseBoolean(line);
        } catch (Exception e) {
            return null;
        }
    }

    public static Character toChar(String line) {
        try {
            return line.charAt(0);
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer toInt(String line) {
        try {
            return Integer.parseInt(line);
        } catch (Exception e) {
            return null;
        }
    }

    public static Long toLong(String line) {
        try {
            return Long.parseLong(line);
        } catch (Exception e) {
            return null;
        }
    }

    public static Double toDouble(String line) {
        try {
            return Double.parseDouble(line);
        } catch (Exception e) {
            return null;
        }
    }

    public static String toStr(String line) {
        if (line.startsWith("\"") && line.endsWith("\"")) {
            line = line.substring(1, line.length() - 1);
        }
        return line;
    }

    public static boolean[] toBoolArray(String line) {
        Boolean[] a = toBoxBoolArray(line);
        int n = a.length;
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static Boolean[] toBoxBoolArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        if (line.isEmpty()) {
            return new Boolean[0];
        }

        String[] tokens = line.split(",");
        int n = tokens.length;
        Boolean[] arr = new Boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toBool(tokens[i]);
        }
        return arr;
    }

    public static char[] toCharArray(String line) {
        Character[] a = toBoxCharArray(line);
        int n = a.length;
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static Character[] toBoxCharArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        if (line.isEmpty()) {
            return new Character[0];
        }

        String[] tokens = line.split(",");
        int n = tokens.length;
        Character[] arr = new Character[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toChar(tokens[i]);
        }
        return arr;
    }

    public static int[] toIntArray(String line) {
        Integer[] a = toBoxIntArray(line);
        int n = a.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static Integer[] toBoxIntArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        if (line.isEmpty()) {
            return new Integer[0];
        }

        String[] tokens = line.split(",");
        int n = tokens.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toInt(tokens[i]);
        }
        return arr;
    }

    public static long[] toLongArray(String line) {
        Long[] a = toBoxLongArray(line);
        int n = a.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static Long[] toBoxLongArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        if (line.isEmpty()) {
            return new Long[0];
        }

        String[] tokens = line.split(",");
        int n = tokens.length;
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toLong(tokens[i]);
        }
        return arr;
    }

    public static double[] toDoubleArray(String line) {
        Double[] a = toBoxDoubleArray(line);
        int n = a.length;
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public static Double[] toBoxDoubleArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        if (line.isEmpty()) {
            return new Double[0];
        }

        String[] tokens = line.split(",");
        int n = tokens.length;
        Double[] arr = new Double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toDouble(tokens[i]);
        }
        return arr;
    }

    public static String[] toStringArray(String line) {
        if (line.contains("[")) {
            line = line.replaceAll("[\\[\\]]", "");
        }
        if (line.isEmpty()) {
            return new String[0];
        }

        String[] tokens = line.split(",");
        int n = tokens.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = toStr(tokens[i]);
        }
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
