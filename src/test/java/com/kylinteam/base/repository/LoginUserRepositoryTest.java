package com.kylinteam.base.repository;

import com.kylinteam.base.entity.LoginUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by troy on 2017/11/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LoginUserRepositoryTest {

    @Autowired
    LoginUserRepository loginUserRepository;

    @Before
    public void initData() {
        LoginUser loginUser = new LoginUser();
        loginUser.setAccount("abcd");
        loginUser.setPassword("abcd123");
        loginUser.setDisplayName("ABCDEFG");
        loginUserRepository.save(loginUser);
    }

    @Test
    public void findByAccount() throws Exception {
        LoginUser loginUser = loginUserRepository.findByAccount("abcd");
        Assert.assertEquals("abcd123", loginUser.getPassword());
        Assert.assertEquals("ABCDEFG", loginUser.getDisplayName());
    }

    @Test
    public void deleteByAccount() throws Exception {
        loginUserRepository.deleteByAccount("abcd");
        LoginUser loginUser = loginUserRepository.findByAccount("abcd");
        Assert.assertNull(loginUser);
    }

}