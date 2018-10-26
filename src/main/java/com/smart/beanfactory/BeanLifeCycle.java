package com.smart.beanfactory;

import com.smart.reflect.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class BeanLifeCycle {
    public static void LifeCycleInBeanFactory() {
        Resource res = new ClassPathResource("beans.xml");


        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) bf);
        reader.loadBeanDefinitions(res);


        //向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //想容器中注册后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());


        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        Car car2 = (Car) bf.getBean("car");
        System.out.println("car1==car2" + (car1 == car2));


        ((DefaultListableBeanFactory) bf).destroySingletons();


    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();


    }


}
