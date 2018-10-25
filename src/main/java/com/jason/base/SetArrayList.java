package com.jason.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SetArrayList {

    public static void main(String[] args) throws Exception {
        
        SetArrayListOtherParam();
            
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void SetArrayListOtherParam() throws Exception{
        List<String> strings = new ArrayList<String>();
        
        System.out.println(strings.add("111"));
                
        Class c = strings.getClass();
        
        Method m  = c.getMethod("add",Object.class);
        
        m.invoke(strings, 1000);
        
        for(Object o : strings){
            System.out.println(o.getClass());
            System.out.println(o);
        }
        
        
    }

}