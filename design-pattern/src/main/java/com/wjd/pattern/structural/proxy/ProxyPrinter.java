package com.wjd.pattern.structural.proxy;

/**
 * @since 2021/11/24
 */
public class ProxyPrinter implements Printable {

    private String name;
    private Printer real;

    public ProxyPrinter() {}

    public ProxyPrinter(String name) {
        this.name = name;
    }

    @Override
    public void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public synchronized void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
