package com.wjd.practice.leetcode;

import com.wjd.util.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 力扣输入模型
 *
 * @author weijiaduo
 * @since 2022/10/1
 */
public class IOModel {

    /**
     * 输入流
     */
    BufferedReader buf;

    public IOModel(InputStream is) {
        buf = new BufferedReader(new InputStreamReader(is));
    }

    /**
     * 读取输入
     *
     * @param types 指定输入类型
     * @return 输入数据
     */
    public Object[] read(Class<?>[] types) throws IOException {
        int n = types.length;
        Object[] rets = new Object[n];
        for (int i = 0; i < n; i++) {
            Object ret = read(types[i]);
            if (ret == null) {
                return null;
            }
            rets[i] = ret;
        }
        return rets;
    }

    /**
     * 读取输入
     *
     * @param type 指定输入类型
     * @return 输入数据
     */
    public Object read(Class<?> type) throws IOException {
        String line = buf.readLine();
        if (line == null) {
            return null;
        }
        return parse(line, type);
    }

    /**
     * 解析字符串
     *
     * @param line 一行字符串
     * @param type 实际数据类型
     * @return 解析后的数据
     */
    Object parse(String line, Class<?> type) {
        Object ret = line;
        if (boolean.class.equals(type) || Boolean.class.equals(type)) {
            ret = IOUtils.toBool(line);
        } else if (char.class.equals(type) || Character.class.equals(type)) {
            ret = IOUtils.toChar(line);
        } else if (int.class.equals(type) || Integer.class.equals(type)) {
            ret = IOUtils.toInt(line);
        } else if (long.class.equals(type) || Long.class.equals(type)) {
            ret = IOUtils.toLong(line);
        } else if (double.class.equals(type) || Double.class.equals(type)) {
            ret = IOUtils.toDouble(line);
        } else if (boolean[].class.equals(type)) {
            ret = IOUtils.toBoolArray(line);
        } else if (Boolean[].class.equals(type)) {
            ret = IOUtils.toBoxBoolArray(line);
        } else if (char[].class.equals(type)) {
            ret = IOUtils.toCharArray(line);
        } else if (Character[].class.equals(type)) {
            ret = IOUtils.toBoxCharArray(line);
        } else if (int[].class.equals(type)) {
            ret = IOUtils.toIntArray(line);
        } else if (Integer[].class.equals(type)) {
            ret = IOUtils.toBoxIntArray(line);
        } else if (long[].class.equals(type)) {
            ret = IOUtils.toLongArray(line);
        } else if (Long[].class.equals(type)) {
            ret = IOUtils.toBoxLongArray(line);
        } else if (double[].class.equals(type)) {
            ret = IOUtils.toDoubleArray(line);
        } else if (Double[].class.equals(type)) {
            ret = IOUtils.toBoxDoubleArray(line);
        } else if (String[].class.equals(type)) {
            ret = IOUtils.toStringArray(line);
        }
        return ret;
    }

}
