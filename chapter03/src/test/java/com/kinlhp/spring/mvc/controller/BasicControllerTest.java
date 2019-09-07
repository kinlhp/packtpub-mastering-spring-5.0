package com.kinlhp.spring.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class BasicControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BasicController()).build();
    }

    @Test
    public void basicTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/welcome").accept("application/html;charset=utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/html;charset=utf-8"))
                .andExpect(MockMvcResultMatchers.content().string("Welcome to Spring MVC."));
    }
}
