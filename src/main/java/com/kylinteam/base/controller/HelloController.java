package com.kylinteam.base.controller;

import com.crazyxxl.jwt.utils.JwtUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        String token = null;
        try {
            token = JwtUtils.createJWT("{'user':'admin'}", 2592000000l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Hello kylinteam!" + token;
    }

}
