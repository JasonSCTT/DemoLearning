package com.smart.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jason
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("调用matches" + targetClass.getName() + "." + method.getName() + "做静态检查");
        return "greetTo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                System.out.println("调用getClassFilter对" + aClass.getName() + "做静态检查");
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("调用matches" + aClass.getName() + "." + method.getName() + "做动态检查");
        String clientName = (String) objects[0];
        return specialClientList.contains(clientName);

    }


}
