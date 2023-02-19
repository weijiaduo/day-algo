package com.wjd.thinking.generic;

/**
 * @author weijiaduo
 * @since 2022/9/22
 */
public class StringGenericHolder<T extends String> {

    T object;

    public void set(T obj) {
        object = obj;
    }

    public T get() {
        return object;
    }

    public static void main(String[] args) {
        StringGenericHolder<String> stringStringGenericHolder = new StringGenericHolder<>();
        stringStringGenericHolder.set("obj");
        String object = stringStringGenericHolder.get();
    }

}
