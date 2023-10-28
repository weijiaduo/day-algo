package com.wjd.practice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 输出接口
 *
 * @author weijiaduo
 * @since 2022/10/1
 */
public class Output {

    /**
     * 数据流模型
     */
    IOModel model;
    /**
     * 数据类型
     */
    Type type;

    public Output(InputStream inputStream, Type type) {
        model = new IOModel(inputStream);
        this.type = type;
    }

    /**
     * @return 下一个测试用例
     */
    public Object nextCase() {
        try {
            return model.read(type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
