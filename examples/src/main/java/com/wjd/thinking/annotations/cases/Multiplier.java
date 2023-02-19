package com.wjd.thinking.annotations.cases;

import com.wjd.thinking.annotations.ExtractInterface;

/**
 * javac -processor com.wjd.learn.annotations.processor.IfaceExtractorProcessor
 * com\wjd\learn\annotations\cases\Multiplier.java -classpath ..\..\..\out\production\codeofthinkinginjava
 * -d ..\..\..\out\production\codeofthinkinginjava
 */
@ExtractInterface(interfaceName = "IMultiplier")
public class Multiplier {

    public boolean flag = false;
    private int n = 0;

    /**
     * 乘法
     *
     * @param x 次数
     * @param y 基数
     * @return
     */
    public int multiply(int x, int y) {
        int total = 0;
        for (int i = 0; i < x; i++) {
            total = add(total, y);
        }

        return total;
    }

    public int fortySeven() {
        return 47;
    }

    /**
     *
     *
     * @param args 基数
     * @return
     */
    public double timesTen(double args) {
        return args * 10;
    }

    /**
     * 相加
     *
     * @param x 加数
     * @param y 加数
     * @return
     */
    private int add(int x, int y) {
        return x + y;
    }
}
