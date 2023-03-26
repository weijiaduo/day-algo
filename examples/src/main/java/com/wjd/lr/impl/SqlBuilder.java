package com.wjd.lr.impl;

/**
 * SQL builder
 *
 * @author weijiaduo
 * @since 2023/3/26
 */
public interface SqlBuilder {

    /**
     * @return previous quote
     */
    String getPreQuote();

    /**
     * @return post quote
     */
    String getPostQuote();

}
