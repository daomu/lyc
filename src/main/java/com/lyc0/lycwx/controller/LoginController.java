package com.lyc0.lycwx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class LoginController {

    @RequestMapping("/login")
    public String login(String code) {
        return "login success:"+code;
    }
}
