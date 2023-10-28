package com.wjd.practice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 输入接口
 *
 * @author weijiaduo
 * @since 2022/10/1
 */
public class Input {

    /**
     * 数据流模型
     */
    IOModel model;
    /**
     * 数据类型
     */
    Type[] types;

    public Input(InputStream inputStream, Type[] types) {
        model = new IOModel(inputStream);
        this.types = types;
    }

    /**
     * @return 下一个测试用例
     */
    public Object[] nextCase() {
        try {
            return model.read(types);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
