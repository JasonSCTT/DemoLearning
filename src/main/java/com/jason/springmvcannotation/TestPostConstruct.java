package com.jason.springmvcannotation;

import com.jason.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by shencheng6 on 2018/10/10.
 */


@Component
public class TestPostConstruct {

    @Autowired
    private User user ;


    public TestPostConstruct(){
        System.out.println("此时user还没有被注入： user ： " + user);
    }

    @PostConstruct
    private void init(){
        System.out.println("@PostConstruct将在依赖注入完成后被自动调用");
    }


    public String a (String id ){
        return id ;
    }



}
