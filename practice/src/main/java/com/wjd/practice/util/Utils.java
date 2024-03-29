package com.wjd.practice.util;

import com.wjd.structure.list.ListNode;
import com.wjd.structure.tree.binary.TreeNode;
import com.wjd.structure.tree.generic.Node;
import com.wjd.util.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 *
 * @author weijiaduo
 * @since 2023/10/29
 */
public final class Utils {

    private Utils() {
    }

    public static String toStr(Object object) {
        // 链表节点
        if (object instanceof ListNode) {
            return ListNode.toString((ListNode) object);
        }
        // 树
        if (object instanceof Node) {
            return Node.toString((Node) object);
        }
        // 二叉树
        if (object instanceof TreeNode) {
            return TreeNode.toString((TreeNode) object);
        }
        return StringUtils.toStr(object);
    }

    /**
     * 解析字符串
     *
     * @param line 一行字符串
     * @param type 实际数据类型
     * @return 解析后的数据
     */
    public static Object fromStr(String line, Type type) {
        Object ret = line;
        if (TreeNode.class.equals(type)) {
            String[] values = toStringArray(line);
            ret = TreeNode.build(values);
        } else if (Node.class.equals(type)) {
            Integer[] values = toBoxIntArray(line);
            ret = Node.build(values);
        } else if (ListNode.class.equals(type)) {
            int[] arr = toIntArray(line);
            ret = ListNode.build(arr);
        } else if (boolean.class.equals(type) || Boolean.class.equals(type)) {
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
        } else if (Integer[][].class.equals(type)) {
            ret = toBoxIntMatrix(line);
        } else if (char[][].class.equals(type)) {
            ret = toCharMatrix(line);
        } else if (type instanceof ParameterizedType parameterizedType) {
            if (List.class == parameterizedType.getRawType()) {
                ret = toList(line, type);
            }
        }
        return ret != null ? ret : line;
    }

    public static Boolean toBool(String line) {
        try {
            return Boolean.parseBoolean(line.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static Character toChar(String line) {
        try {
            line = line.trim();
            if (line.startsWith("'") && line.endsWith("'")) {
                return line.charAt(1);
            } else {
                return line.charAt(0);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer toInt(String line) {
        try {
            return Integer.parseInt(line.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static Long toLong(String line) {
        try {
            return Long.parseLong(line.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static Double toDouble(String line) {
        try {
            return Double.parseDouble(line.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static String toStr(String line) {
        line = line.trim();
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
        line = getArrayStr(line);
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
        line = getArrayStr(line);
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
        line = getArrayStr(line);
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
        line = getArrayStr(line);
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
        line = getArrayStr(line);
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
        line = getArrayStr(line);
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
        String[] tokens = getMatrixStr(line);
        int m = tokens.length;
        int[][] arr = new int[m][];
        for (int i = 0; i < m; i++) {
            arr[i] = toIntArray(tokens[i]);
        }
        return arr;
    }

    public static Integer[][] toBoxIntMatrix(String line) {
        String[] tokens = getMatrixStr(line);
        int m = tokens.length;
        Integer[][] arr = new Integer[m][];
        for (int i = 0; i < m; i++) {
            arr[i] = toBoxIntArray(tokens[i]);
        }
        return arr;
    }

    public static char[][] toCharMatrix(String line) {
        String[] tokens = getMatrixStr(line);
        int m = tokens.length;
        char[][] arr = new char[m][];
        for (int i = 0; i < m; i++) {
            arr[i] = toCharArray(tokens[i]);
        }
        return arr;
    }

    private static Object toList(String line, Type type) {
        if (line.isEmpty()) {
            return new ArrayList<>();
        }

        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type elemType = parameterizedType.getActualTypeArguments()[0];
        Class<?> typeClass;
        if (elemType instanceof ParameterizedType paramType) {
            // 泛型嵌套，例如 List<List<Integer>
            typeClass = (Class<?>) paramType.getRawType();
        } else {
            typeClass = (Class<?>) elemType;
        }
        @SuppressWarnings("unchecked")
        List<Object> list = (List<Object>) createList(typeClass);

        String[] tokens;
        if (line.indexOf('[') != line.lastIndexOf('[')) {
            tokens = getMatrixStr(line);
        } else {
            tokens = getArrayStr(line).split(",");
        }
        for (String token : tokens) {
            list.add(fromStr(token, elemType));
        }
        return list;
    }

    private static <T> List<T> createList(Class<T> type) {
        return new ArrayList<>();
    }

    private static String getArrayStr(String line) {
        if (line == null || line.isEmpty()) {
            return "";
        }
        int n = line.length();
        int l = 0, r = n - 1;
        while (l <= r && line.charAt(l) != '[') {
            l++;
        }
        while (l <= r && line.charAt(r) != ']') {
            r--;
        }
        return l < r ? line.substring(l + 1, r) : line;
    }

    private static String[] getMatrixStr(String line) {
        if (line == null || line.isEmpty()) {
            return new String[0];
        }
        List<String> list = new ArrayList<>();
        String rawLine = getArrayStr(line);
        int n = rawLine.length();
        int l = 0, r = -1;
        while (r < n) {
            l = r + 1;
            while (l < n && rawLine.charAt(l) != '[') {
                l++;
            }
            r = l + 1;
            while (r < n && rawLine.charAt(r) != ']') {
                r++;
            }
            if (r < n) {
                list.add(rawLine.substring(l, r + 1));
            }
        }
        if (list.isEmpty()) {
            list.add(line);
        }
        return list.toArray(new String[0]);
    }

}
