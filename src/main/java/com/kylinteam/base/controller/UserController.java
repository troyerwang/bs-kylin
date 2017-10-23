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

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public LoginUser getUser(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public LoginUser putUser(@PathVariable Long id, @RequestBody LoginUser user) {
        LoginUser u = userService.findUserById(id);
        u.setAccount(user.getAccount());
        u.setPassword(user.getPassword());
        u.setDisplayName(user.getDisplayName());
        return userService.addUser(u);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "删除成功！";
    }
}
