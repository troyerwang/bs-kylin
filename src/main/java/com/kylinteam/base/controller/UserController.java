package com.kylinteam.base.controller;

import com.kylinteam.base.constant.RespCode;
import com.kylinteam.base.controller.resp.ResponseDTO;
import com.kylinteam.base.controller.resp.ResponseListDTO;
import com.kylinteam.base.entity.LoginUser;
import com.kylinteam.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object findAll() {
        return new ResponseListDTO<LoginUser>(RespCode.SUCCESS, "", userService.findAll());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object addUser(@RequestBody LoginUser user) {
        return new ResponseDTO<LoginUser>(RespCode.SUCCESS, "", userService.addUser(user));
    }

    @RequestMapping(value = "/{account}", method = RequestMethod.GET)
    public Object getUser(@PathVariable String account) {
        return new ResponseDTO<LoginUser>(RespCode.SUCCESS, "", userService.findUserByAccount(account));
    }

    @RequestMapping(value = "/{account}", method = RequestMethod.PUT)
    public Object putUser(@PathVariable String account, @RequestBody LoginUser user) {
        LoginUser u = userService.findUserByAccount(account);
        u.setPassword(user.getPassword());
        u.setDisplayName(user.getDisplayName());
        return new ResponseDTO<LoginUser>(RespCode.SUCCESS, "", userService.addUser(u));
    }

    @RequestMapping(value = "/{account}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable String account) {
        return new ResponseDTO<String>(RespCode.SUCCESS, "", "success");
    }
}
