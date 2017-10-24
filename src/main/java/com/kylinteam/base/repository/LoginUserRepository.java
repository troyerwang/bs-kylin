package com.kylinteam.base.repository;

import com.kylinteam.base.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long>{

    LoginUser findByAccount(String account);

    @Modifying
    @Query(value = "delete from tb_user where account = :account", nativeQuery = true)
    void deleteUserByAccount(@Param("account") String account);

}
