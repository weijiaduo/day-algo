package com.wjd.pattern.proxy;

/**
 * @since 2021/11/24
 */
public class Main {

    public static void main(String[] args) {
        Printable printer = new ProxyPrinter("Alice");
        System.out.println("现在的名字是" + printer.getPrinterName() + "。");
        printer.setPrinterName("Bob");
        System.out.println("现在的名字是" + printer.getPrinterName() + "。");
        printer.print("Hello, world.");
    }

}
