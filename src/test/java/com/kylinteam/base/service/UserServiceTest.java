package com.kylinteam.base.service;

import com.kylinteam.base.entity.LoginUser;
import com.kylinteam.base.repository.LoginUserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional

public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    LoginUserRepository loginUserRepository;

    LoginUser loginUser = null;
    LoginUser loginUser2 = null;

    @Before
    public void initData() {
        loginUser = new LoginUser();
        loginUser.setAccount("abcd");
        loginUser.setPassword("abcd123");
        loginUser.setDisplayName("ABCDEFG");
        loginUserRepository.save(loginUser);

        loginUser2 = new LoginUser();
        loginUser2.setAccount("abcd456");
        loginUser2.setPassword("abcd456");
        loginUser2.setDisplayName("ABCDEFGHIJKL");
        loginUserRepository.save(loginUser2);
    }

    @Test
    public void findAllTest() throws Exception {
        List<LoginUser> list = userService.findAll();
        for (LoginUser user: list) {
            if ("abcd".equals(user.getAccount())) {
                Assert.assertEquals("abcd123", user.getPassword());
                Assert.assertEquals("ABCDEFG", user.getDisplayName());
            }
            if ("abcd456".equals(user.getAccount())) {
                Assert.assertEquals("abcd456", user.getPassword());
                Assert.assertEquals("ABCDEFGHIJKL", user.getDisplayName());
            }
        }
    }

    @Test
    public void findUserByIdTest() throws Exception {
        LoginUser user = userService.findUserById(loginUser.getId());
        Assert.assertEquals("abcd", user.getAccount());
        Assert.assertEquals("abcd123", user.getPassword());
        Assert.assertEquals("ABCDEFG", user.getDisplayName());
    }

}