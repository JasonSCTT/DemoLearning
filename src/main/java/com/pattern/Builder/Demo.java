package com.pattern.Builder;

/**
 * @author jason
 */
public class Demo {
    public static void main(String[] args) {
        MealBuilder mb = new MealBuilder();

        Meal meal = mb.prepareVegMeal();
        System.out.println(meal.getCost());
    }
}
