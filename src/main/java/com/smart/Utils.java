package com.smart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jason
 */
public class Utils {

    public static ApplicationContext getApplicationContext(String configurationPath) {
        return new ClassPathXmlApplicationContext(configurationPath);
    }

}
