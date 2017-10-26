package com.kylinteam.base.repository;

import com.kylinteam.base.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long>{

    LoginUser findByAccount(String account);

    void deleteByAccount(String account);

}
