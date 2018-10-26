package com.pattern.Prototype;

/**
 * @author jason
 */
public class Demo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape shape1 = ShapeCache.getshape("1");
        Shape shape2 = ShapeCache.getshape("2");
        Shape shape3 = ShapeCache.getshape("3");


    }
}
