package com.kylinteam.base.service;

import com.kylinteam.base.entity.LoginUser;

public interface UserService {

    LoginUser findUserByAccount(String account);

}
