package com.jason.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.security.InvalidParameterException;

/**
 * Created by shencheng6 on 2018/10/9.
 */
@Aspect
@Component
public class TestAop {

    private static final Logger log = LoggerFactory.getLogger(TestAop.class);

    @Around(" @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private Object logger(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Object[] arguments = pjp.getArgs();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            check(parameters[i], arguments[i]);
        }

        return pjp.proceed(arguments);
    }



    /**
     * 检查参数判空状态，如果有异常则抛出错误
     */
    private void check(Parameter parameter, Object object) throws InvalidParameterException {

        if (object == null) {
            throw new InvalidParameterException(parameter.getName() + " cannot be null!");
        }

        if (parameter.getType() != String.class) {
            //非String类型的入参，只要判断非空即可
            return;
        }

        if (!String.class.isAssignableFrom(object.getClass())) {
            throw new InvalidParameterException(parameter.getName() + " cannot be null!");
        }

        if (StringUtils.isEmpty((String) object)) {
            throw new InvalidParameterException(parameter.getName() + " cannot be null!");
        }
    }

}
