package com.kylinteam.base.service;

import com.kylinteam.base.entity.LoginUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    LoginUser findUserByAccount(String account);

    List<LoginUser> findAll();

    LoginUser addUser(LoginUser user);

    LoginUser findUserById(Long id);

    void deleteUserById(Long id);

    void deleteUserByAccount(String account);

    Page<LoginUser> findAll(Pageable pageable);

}
