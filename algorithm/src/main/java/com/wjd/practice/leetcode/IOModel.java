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
        if (types.length == 0) {
            close();
            return null;
        }
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
        if (buf == null) {
            return null;
        }
        String line = buf.readLine();
        if (line == null) {
            close();
            return null;
        }
        return IOUtils.parse(line, type);
    }

    /**
     * 关闭输入流
     */
    private void close() {
        try {
            buf.close();
            buf = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
