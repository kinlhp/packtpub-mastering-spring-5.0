package com.kinlhp.spring.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class BasicViewControllerTest {
    private MockMvc mockMvc;
    private ViewResolver viewResolver;

    @Before
    public void setup() {
        this.viewResolver = createViewResolver();
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BasicViewController()).setViewResolvers(this.viewResolver)
                .build();
    }

    @Test
    public void testWelcome() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/welcome").accept("application/html;charset=utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("welcome-view"));
    }

    private ViewResolver createViewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
}
