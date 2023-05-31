package com.wjd.pattern.structural.proxy;

/**
 * @since 2021/11/24
 */
public interface Printable {

    /**
     * 设置名称
     * @param name 名称
     */
    void setPrinterName(String name);

    /**
     * 获取名称
     */
    String getPrinterName();

    /**
     * 打印输出
     * @param string 输出字符串
     */
    void print(String string);

}
