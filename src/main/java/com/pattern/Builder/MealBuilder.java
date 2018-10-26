package com.pattern.Builder;

/**
 * @author jason
 */
public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new Coke());
        return meal;
    }
}
