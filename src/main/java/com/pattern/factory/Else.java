package com.pattern.factory;

/**
 * @author jason
 */
public class Else implements Shape {
    @Override
    public void draw() {
        System.out.println("我画了一个其他的形状");
    }
}
