package com.lyc0.lycwx.controller;

import com.lyc0.lycwx.manager.LoginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/wx")
public class LoginController {

    @Resource
    private LoginManager loginManager;

    @RequestMapping("/login")
    public String login(String code) {
        loginManager.login(code);
        return "login success:"+code;
    }
}
