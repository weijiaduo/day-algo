package com.wjd.pattern.proxy;

/**
 * @since 2021/11/24
 */
public class Printer implements Printable {

    private String name;

    public Printer() {
        heavyJob("Printer 的实例生成中");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 的实例生成中（" + name + "）");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {

    }

    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print('.');
        }
        System.out.println("结束。");
    }
}
