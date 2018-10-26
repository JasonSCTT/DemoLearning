package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable {

        //通用类加载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");


        //获取累得默认构造器并实例化
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
//        Object [] objects={"红旗CA72","红色",200};
        Car car = (Car) cons.newInstance();

        //通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);


        setBrand.invoke(car, "红旗CA72");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "红色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;

    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
