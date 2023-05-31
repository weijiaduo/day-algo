package com.wjd.pattern.creational.factorymethod.product;

public class Square extends Shape {

    public Square(){}

    @Override
    public void draw() {
        System.out.println("Draw a square shape!");
    }
}
