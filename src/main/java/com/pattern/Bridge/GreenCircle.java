package com.pattern.Bridge;

/**
 * @author jason
 */
public class GreenCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle[ green: red radius: " + radius + ", x : " + x + ",y: " + y);

    }
}

