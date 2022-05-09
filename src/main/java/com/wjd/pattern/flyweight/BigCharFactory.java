package com.wjd.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2022/1/10
 */
public class BigCharFactory {

    private static BigCharFactory instance = new BigCharFactory();

    /* 享元对象池 */
    private Map<String, BigChar> pool = new HashMap<>();

    private BigCharFactory(){}

    public static BigCharFactory getInstance() {
        return instance;
    }

    /**
     * 获取享元对象接口
     */
    public BigChar getChar(char charName) {
        BigChar bigChar = pool.get("" + charName);
        if (bigChar == null) {
            bigChar = new BigChar(charName);
            pool.put("" + charName, bigChar);
        }
        return bigChar;
    }

}
