package com.kinlhp.spring.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
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
}
