package com.wjd.pattern.creational.builder;

/**
 * @since 2021/11/24
 */
public interface Builder {

    /**
     * 编写标题
     * @param title 标题
     */
    void makeTitle(String title);

    /**
     * 编写字符串
     * @param string 字符串
     */
    void makeString(String string);

    /**
     * 编写条目
     * @param items 条目
     */
    void makeItems(String[] items);

    void close();

}
