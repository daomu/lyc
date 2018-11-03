package com.lyc0.lycwx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/group/")
public class GroupController {

    @RequestMapping("/create")
    public String createGroup(String groupName) {
        return "m1 success";
    }
}
