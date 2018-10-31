package com.lyc0.lycwx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class ManagerController {

    @RequestMapping("/m1")
    public String m1() {
        return "m1 success";
    }
}
