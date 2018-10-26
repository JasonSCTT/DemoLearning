package com.smart.web;

import com.smart.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "login";
    }


}
