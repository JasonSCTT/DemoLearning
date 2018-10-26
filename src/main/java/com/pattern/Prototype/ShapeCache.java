package com.pattern.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jason
 */
public class ShapeCache {
    private static Map<String, Shape> shapeMap = new HashMap<String, Shape>();


    public static Shape getshape(String id) {
        Shape shapeshape = shapeMap.get(id);
        return (Shape) shapeshape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();

        circle.setId("1");
        square.setId("2");
        rectangle.setId("3");

        shapeMap.put(circle.getId(), circle);
        shapeMap.put(square.getId(), square);
        shapeMap.put(rectangle.getId(), rectangle);
    }


}
