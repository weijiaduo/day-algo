package com.wjd.pattern.creational.builder;

/**
 * @since 2021/11/24
 */
public class TextBuilder implements Builder {

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append("=====================================\n");
        buffer.append("[" + title + "]\n");
        buffer.append("\n");
    }

    @Override
    public void makeString(String string) {
        buffer.append("#" + string);
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append(" ." + items[i] + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append("=====================================\n");
    }

    public String getResult() {
        return buffer.toString();
    }
}
