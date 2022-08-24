package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

import java.util.Random;

/**
 * 478. 在圆内随机生成点
 *
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 *
 * @since 2022/6/5
 */
public class RandomCircle implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        return null;
    }


    Random random;
    double xc, yc, r;

    public RandomCircle(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    /**
     * 算了，不会，先打卡把
     */
    public double[] randPoint() {
        double u = random.nextDouble();
        double theta = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(u);
        return new double[]{xc + r * Math.cos(theta) * this.r, yc + r * Math.sin(theta) * this.r};
    }

}
