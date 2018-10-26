package com.pattern.Decorator;

/**
 * @author jason
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(decoratedShape);
    }

    public void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color :Red");
    }
}
