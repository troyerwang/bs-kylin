package com.kylinteam.base.service.impl;

import com.kylinteam.base.entity.LoginUser;
import com.kylinteam.base.repository.LoginUserRepository;
import com.kylinteam.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    LoginUserRepository loginUserRepository;

    @Override
    public LoginUser findUserByAccount(String account) {
        return loginUserRepository.findByAccount(account);
    }

    @Override
    public List<LoginUser> findAll() {
        return loginUserRepository.findAll();
    }

    @Override
    public LoginUser addUser(LoginUser user) {
        return loginUserRepository.save(user);
    }

    @Override
    public LoginUser findUserById(Long id) {
        return loginUserRepository.findOne(id);
    }

    @Override
    public void deleteUserById(Long id) {
        loginUserRepository.delete(id);
    }

    @Override
    public void deleteUserByAccount(String account) {
        loginUserRepository.deleteByAccount(account);
    }

    @Override
    public Page<LoginUser> findAll(Pageable pageable) {
        return loginUserRepository.findAll(pageable);
    }

}
