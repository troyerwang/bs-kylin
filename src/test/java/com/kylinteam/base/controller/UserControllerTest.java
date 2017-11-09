package com.kylinteam.base.controller;

import com.google.gson.Gson;
import com.kylinteam.base.entity.LoginUser;
import com.kylinteam.base.service.UserService;
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

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    UserService userService;

    private MockMvc mockMvc;

    private Gson gson;

    private RequestBuilder request;

    LoginUser user = null;
    String jsonString = null;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        gson = new Gson();
        user = new LoginUser();
        user.setAccount("admin");
        user.setPassword("123456");
        user.setDisplayName("管理员");
        user.setTime(1510126952653L);
        user.setReskey("QaN0nN7");
        userService.addUser(user);
    }

    @Test
    public void testUserController() throws Exception {

        // 2. get user list
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result", is("00000000")))
                .andExpect(jsonPath("$.data", notNullValue()));

        // 3. change displayName which named admin.
        user.setDisplayName("修改过的名字");
        String jsonString2 = gson.toJson(user);
        request = put("/users/QaN0nN7").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString2);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result", is("00000000")))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data.account", is("admin")))
                .andExpect(jsonPath("$.data.password", is("123456")))
                .andExpect(jsonPath("$.data.displayName", is("修改过的名字")));

        // 4. get a user which named admin
        request = get("/users/QaN0nN7");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result", is("00000000")))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data.account", is("admin")))
                .andExpect(jsonPath("$.data.password", is("123456")))
                .andExpect(jsonPath("$.data.displayName", is("修改过的名字")));

        // 5. del a user which named admin
        request = delete("/users/QaN0nN7");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data", is("success")));
    }

}