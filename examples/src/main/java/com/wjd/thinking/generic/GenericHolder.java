package com.wjd.thinking.generic;

/**
 * @author weijiaduo
 * @since 2022/9/20
 */
public class GenericHolder<T> {

    T object;

    public void set(T obj) {
        object = obj;
    }

    public T get() {
        return object;
    }

    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<>();
        holder.set("obj");
        String obj = holder.get();
    }

}
