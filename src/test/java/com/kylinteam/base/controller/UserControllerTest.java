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

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserControllerTest {

    private MockMvc mockMvc;

    private Gson gson;

    private RequestBuilder request;

    @Autowired
    private UserController userController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        gson = new Gson();
    }

    @Test
    public void testUserController() throws Exception {
        // 1. add a user
        LoginUser user = new LoginUser();
        user.setAccount("admin");
        user.setPassword("123456");
        user.setDisplayName("管理员");
        String jsonString = gson.toJson(user);

        request = post("/users/").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result", is("00000000")))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data.account", is("admin")))
                .andExpect(jsonPath("$.data.password", is("123456")))
                .andExpect(jsonPath("$.data.displayName", is("管理员")));

        // 2. get user list
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result", is("00000000")))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data", hasSize(equalTo(1))));

        // 3. change displayName which named admin.
        user.setDisplayName("修改过的名字");
        String jsonString2 = gson.toJson(user);
        request = put("/users/admin").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString2);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result", is("00000000")))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data.account", is("admin")))
                .andExpect(jsonPath("$.data.password", is("123456")))
                .andExpect(jsonPath("$.data.displayName", is("修改过的名字")));

        // 4. get a user which named admin
        request = get("/users/admin");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result", is("00000000")))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data.account", is("admin")))
                .andExpect(jsonPath("$.data.password", is("123456")))
                .andExpect(jsonPath("$.data.displayName", is("修改过的名字")));

        // 5. del a user which named admin
        request = delete("/users/admin");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data", is("success")));
    }

}