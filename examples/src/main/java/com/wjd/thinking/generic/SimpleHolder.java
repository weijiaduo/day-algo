package com.wjd.thinking.generic;

/**
 * @author weijiaduo
 * @since 2022/9/20
 */
public class SimpleHolder {

    Object object;

    public void set(Object obj) {
        object = obj;
    }

    public Object get() {
        return object;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("obj");
        String obj = (String) holder.get();
    }

}
