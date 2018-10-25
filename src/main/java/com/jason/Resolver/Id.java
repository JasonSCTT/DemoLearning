package com.jason.Resolver;

import java.lang.annotation.*;

/**
 * Created by shencheng6 on 2018/10/10.
 */

@Target({ElementType.PARAMETER,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Id {
}
