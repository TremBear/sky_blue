package com.skyblue.controller;
import com.skyblue.util.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/sys/login")
public class LoginController {
    @RequestMapping(value="")
    public String index2() {
        System.out.println("no?/");
        Subject subject = ShiroUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", new Sha256Hash("admin").toHex());
        subject.login(token);
        return "index";
    }
}