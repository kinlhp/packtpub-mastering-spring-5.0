package com.kinlhp.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicViewController {

    @RequestMapping(path = { "/welcome" })
    public String welcome() {
        return "welcome-view";
    }
}
