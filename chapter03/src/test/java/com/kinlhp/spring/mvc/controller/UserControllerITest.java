package com.kinlhp.spring.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/context/spring-mvc.xml" })
@RunWith(value = SpringRunner.class)
@WebAppConfiguration
public class UserControllerITest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAllValidationErrors() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/user").accept("application/html;charset=utf-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().errorCount(6))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "name", "Size"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "birthDate", "NotNull"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "country", "NotNull"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "password", "Size"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "password2", "Size"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "userId", "Size"));
    }

    @Test
    public void testShowAllUsers() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/users").accept("application/html;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("user/list"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/user/list.jsp"));
                // .andExpect(MockMvcResultMatchers.content().string("Welcome! This is comming from a redirectiong of POST - a JSP."))
    }
}
