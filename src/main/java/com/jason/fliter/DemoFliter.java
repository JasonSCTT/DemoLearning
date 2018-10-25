package com.jason.fliter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by shencheng6 on 2018/10/9.
 */

public class DemoFliter  extends HandlerInterceptorAdapter{

    private static final Logger log= LoggerFactory.getLogger(DemoFliter.class);

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<String, String[]> a =request.getParameterMap();
            if( null == request.getParameter("username") ) {
                    return false;
            }


            if(!request.getParameter("username").equals(username)){
                return true;

            }else{
                response.sendRedirect("localhost:8080/index.jsp");
                return false;
            }


    }
}
