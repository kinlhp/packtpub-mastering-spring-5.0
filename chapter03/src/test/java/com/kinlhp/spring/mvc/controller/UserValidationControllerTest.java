package com.kinlhp.spring.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserValidationControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserValidationController()).build();
    }

    @Test
    public void testAllValidationErrors() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/create-user-with-validation").accept("application/html;charset=utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().errorCount(4))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "name", "Size"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "password", "Size"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("user", "userId", "Size"));
    }
}
