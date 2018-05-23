package com.skyblue.controller;

import com.skyblue.entity.Organize;
import com.skyblue.service.OrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class HelloController {
    @Autowired
    OrganizeService organizeService;
    @RequestMapping(value="/xx")
    public String index() {
        List<Organize> list=organizeService.getList();
        for(Organize organize:list){
            System.out.println("------------"+organize.getOrgName());
        }
        return "hello";
    }
}