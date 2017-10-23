package com.kylinteam.base.service.impl;

import com.kylinteam.base.entity.LoginUser;
import com.kylinteam.base.repository.LoginUserRepository;
import com.kylinteam.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    LoginUserRepository loginUserRepository;

    @Override
    public LoginUser findUserByAccount(String account) {
        return loginUserRepository.findByAccount(account);
    }

}
