package com.wjd.algorithm.strings.regex;

/**
 * 模式匹配接口
 *
 * @author weijiaduo
 * @since 2023/4/13
 */
public interface Pattern {

    /**
     * Match boolean.
     *
     * @param pattern the pattern
     * @param txt     the txt
     * @return the boolean
     */
    boolean match(String pattern, String txt);

}
