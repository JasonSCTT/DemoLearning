package com.pattern.Bridge;

/**
 * @author jason
 */
public class Demo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 100, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 100, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();

    }
}
