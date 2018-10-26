package com.pattern.factory;

/**
 * @author jason
 */
public class Factory {

    public Shape getShape(String shapetype) {
        if (shapetype.equals("yuan")) {
            return new Circle();
        } else {
            return new Else();
        }


    }

    public static void main(String[] args) {
        Factory factory = new Factory();

        factory.getShape("yuan").draw();
        factory.getShape("else").draw();
    }

}
