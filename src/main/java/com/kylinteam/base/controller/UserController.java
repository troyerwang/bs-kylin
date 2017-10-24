package com.kylinteam.base.controller;

import com.kylinteam.base.entity.LoginUser;
import com.kylinteam.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<LoginUser> getUserList() {
        return userService.findAll();
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public LoginUser postUser(@RequestBody LoginUser user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/{account}", method=RequestMethod.GET)
    public LoginUser getUser(@PathVariable String account) {
        return userService.findUserByAccount(account);
    }

    @RequestMapping(value="/{account}", method=RequestMethod.PUT)
    public LoginUser putUser(@PathVariable String account, @RequestBody LoginUser user) {
        LoginUser u = userService.findUserByAccount(account);
        u.setPassword(user.getPassword());
        u.setDisplayName(user.getDisplayName());
        return userService.addUser(u);
    }

    @RequestMapping(value="/{account}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable String account) {
        userService.deleteUserByAccount(account);
        return "success";
    }
}
