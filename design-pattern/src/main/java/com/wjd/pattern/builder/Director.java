package com.wjd.pattern.builder;

/**
 * @since 2021/11/24
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("从早上至下午");
        builder.makeItems(new String[] {
                "早上好",
                "下午好"
        });
        builder.close();
    }

}
