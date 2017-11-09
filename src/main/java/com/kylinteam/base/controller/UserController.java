package com.kylinteam.base.controller;

import com.kylinteam.base.common.constant.RespCode;
import com.kylinteam.base.controller.resp.PageBean;
import com.kylinteam.base.controller.resp.ResponseDTO;
import com.kylinteam.base.controller.resp.ResponseListDTO;
import com.kylinteam.base.entity.LoginUser;
import com.kylinteam.base.service.UserService;
import com.kylinteam.base.utils.KeyUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "获取所有用户的信息")
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public Object findAll() {
        return new ResponseListDTO<LoginUser>(RespCode.SUCCESS, "", userService.findAll());
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public Object addUser(@RequestBody LoginUser user) {
        user.setReskey(KeyUtil.transform(Instant.now().toEpochMilli()));
        user.setTime(Instant.now().toEpochMilli());
        return new ResponseDTO<LoginUser>(RespCode.SUCCESS, "", userService.addUser(user));
    }

    @ApiOperation(value = "根据账号查询某个用户信息")
    @RequestMapping(value = "/{reskey}", method = RequestMethod.GET)
    public Object getUser(@PathVariable String reskey) {
        return new ResponseDTO<LoginUser>(RespCode.SUCCESS, "", userService.findUserByReskey(reskey));
    }

    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/{reskey}", method = RequestMethod.PUT)
    public Object putUser(@PathVariable String reskey, @RequestBody LoginUser user) {
        LoginUser u = userService.findUserByReskey(reskey);
        u.setPassword(user.getPassword());
        u.setDisplayName(user.getDisplayName());
        return new ResponseDTO<LoginUser>(RespCode.SUCCESS, "", userService.addUser(u));
    }

    @ApiOperation(value = "根据账号删除一个用户")
    @RequestMapping(value = "/{reskey}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable String reskey) {
        userService.deleteUserByResKey(reskey);
        return new ResponseDTO<String>(RespCode.SUCCESS, "", "success");
    }

    @ApiOperation(value = "获取所有用户的信息")
    @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
    public Object findAllByPage(int page, int size) {
        Sort sort = new Sort(Direction.DESC, "account");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        return new PageBean<LoginUser>(userService.findAll(pageable));
    }

}
