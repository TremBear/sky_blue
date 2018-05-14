package com.skyblue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class HelloController {
    @RequestMapping(value="/xx")
    @ResponseBody
    public String index() {
        System.out.println("-------------start0------------");
        return "hello2";
    }
}