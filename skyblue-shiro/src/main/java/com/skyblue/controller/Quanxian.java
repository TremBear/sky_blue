package com.skyblue.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author TremBear
 * @email 1424479171@qq.com
 * @date 2018-05-24 17:17
 */
@Controller
@RequestMapping(value = "/jianquan")
public class Quanxian {
    @ResponseBody
    @RequestMapping("")
    @RequiresPermissions("commpara:list")
    public  String list(@RequestParam Map<String, Object> params, HttpSession httpSession) {
        System.out.println("success");
       return "hello";
    }
}
