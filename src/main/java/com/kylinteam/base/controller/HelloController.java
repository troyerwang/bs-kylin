package com.kylinteam.base.controller;

import com.crazyxxl.jwt.utils.JwtUtils;
import com.kylinteam.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        String token = null;
        try {
            token = JwtUtils.createJWT("{'user':'admin'}", 2592000000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Hello kylinteam!" + token;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String main() {
        return "admin/main";
    }

    @RequestMapping(value = "/admin/user/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", userService.findAll());
        return "admin/userlist";
    }

    @RequestMapping(value = "/admin/user/list2", method = RequestMethod.GET)
    public String list2(Model model) {
        return "admin/userlist2";
    }

}
