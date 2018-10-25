package com.jason.annoation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by shencheng6 on 2018/10/8.
 */
public class Demo {
    public static void main(String[] args) throws IllegalAccessException {

        Class classz = null;
        try {
            classz = Class.forName("com.jason.annoation.QuicklyWay");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        QuicklyWay quicklyWay=new QuicklyWay();
        for (Field field : classz.getDeclaredFields()) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length == 0) {
                    continue;
                }
                System.out.println(annotations[0]+"--------"+field.getName());

            field.set(quicklyWay, field.getAnnotation(IntegerVaule.class).value());

            }

        System.out.println(quicklyWay.age);
        System.out.println(quicklyWay.money);


        }

}
