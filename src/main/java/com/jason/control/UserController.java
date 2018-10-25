package com.jason.control;
 

import java.util.List;


import com.jason.Resolver.Id;
import com.jason.pojo.User;

import com.jason.springmvcannotation.TestPostConstruct;
import org.apache.ibatis.io.ResolverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserController {
	
	private static List<User> userList;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);


	@Autowired
	private TestPostConstruct testPostConstruct;

	@RequestMapping("/login")
	@ResponseBody
	public User login(@RequestParam("id") String id, @RequestParam("password") String password){
	    User user=new User("jason","asdfa","jasn1234");
		log.info("right id is "+ id+" , password is "+password);
        return user;
	}


	@RequestMapping("/testId")
	@ResponseBody
	public String printA(@Id String id ){
		return id ;
	}

	@RequestMapping("/testPostConstruct")
	@ResponseBody
	public String printConstruct(@Id String id ){
		return testPostConstruct.a(id);
	}





	@RequestMapping("/abc")
	public String dispatchServlet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		log.info(httpServletRequest.getAuthType());
		log.info(httpServletRequest.getContextPath());
		log.info(httpServletRequest.getQueryString());
		log.info(httpServletRequest.getPathInfo());
		log.info(httpServletRequest.getRequestURI());
		log.info(String.valueOf(httpServletRequest.getRequestURL()));
		log.info(String.valueOf(httpServletRequest.getCookies()));
		log.info(String.valueOf(httpServletRequest.getServerPort()));
		log.info(httpServletRequest.getServletPath());
		log.info(httpServletRequest.getCharacterEncoding());
		return "forward:/user/login";
	}



    @RequestMapping("/testPathVariable/{id}")
    @ResponseBody
    public String testPathVariable(@PathVariable("id") Integer id ){
        log.info("{} is the id ",id );
        return "success";
    }


}
