package com.pattern.Builder;

/**
 * @author jason
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30f;
    }
}
