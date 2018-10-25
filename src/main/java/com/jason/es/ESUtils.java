package com.jason.es;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by shencheng6 on 2018/10/16.
 */
public class ESUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object o ){
        try{
            return objectMapper.writeValueAsString(o);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
