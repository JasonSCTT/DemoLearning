package com.smart.aspect.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author jason
 */
@Aspect
public class EnableSellerAspect {


    @DeclareParents(value = "com.smart.aspect.aspectj.NaiveWaiter", defaultImpl = SmartSeller.class)
    public Seller seller;

}
