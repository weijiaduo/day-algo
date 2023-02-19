package com.wjd.thinking.annotations.cases;

import com.wjd.thinking.annotations.Simple;

/**
 * 注解 {@link com.wjd.thinking.annotations.Simple} 用例
 */
@Simple
public class SimpleTest {
    @Simple
    int i;

    @Simple
    public SimpleTest() {}

    @Simple
    public void foo() {
        System.out.println("SimpleTest.foo()");
    }

    @Simple
    public void bar(String str, int i, float f) {
        System.out.println("SimpleTest.bar()");
    }
}
