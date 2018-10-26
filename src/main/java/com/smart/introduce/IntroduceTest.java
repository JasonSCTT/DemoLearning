package com.smart.introduce;

import com.smart.dynamic.Service;
import com.smart.dynamic.ServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jason
 */
public class IntroduceTest {

    @Test
    public void introduce() {
        String configpath = "classpath:/Introduce.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configpath);

        ServiceImpl service = (ServiceImpl) ctx.getBean("finalservice");

        service.removeForm(10);
        service.removeTopic(1022);


        Monitorable monitorable = (Monitorable) service;
        monitorable.setMonitorActive(true);

        service.removeForm(10);
        service.removeTopic(1022);


    }
}
