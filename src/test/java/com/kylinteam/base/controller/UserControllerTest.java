package com.kylinteam.base.controller;

import com.google.gson.Gson;
import com.kylinteam.base.entity.LoginUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;

        // 1. get查询用户列表
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

        // 2. post提交一个user
        Gson gson = new Gson();
        LoginUser user = new LoginUser();
        user.setId(1l);
        user.setAccount("admin");
        user.setPassword("123456");
        user.setDisplayName("管理员");
        String jsonString = gson.toJson(user);
        request = post("/users/").contentType(MediaType.APPLICATION_JSON).content(jsonString);
        mockMvc.perform(request)
                .andExpect(content().string("{\"id\":1,\"account\":\"admin\",\"password\":\"123456\",\"displayName\":\"管理员\"}"));

        // 3. get获取user列表，存在一条刚插入的数据
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"account\":\"admin\",\"password\":\"123456\",\"displayName\":\"管理员\"}]"));

        // 4. put修改id为1的user数据
        user.setDisplayName("修改过的名字");
        String jsonString2 = gson.toJson(user);
        request = put("/users/1").contentType(MediaType.APPLICATION_JSON).content(jsonString2);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"account\":\"admin\",\"password\":\"123456\",\"displayName\":\"修改过的名字\"}"));

        // 5. get一个id为1的user
        request = get("/users/1");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"account\":\"admin\",\"password\":\"123456\",\"displayName\":\"修改过的名字\"}"));

        // 6. del删除id为1的user
        request = delete("/users/1");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success"));

        // 7. get查询一下user列表，此时为空
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

    }

}