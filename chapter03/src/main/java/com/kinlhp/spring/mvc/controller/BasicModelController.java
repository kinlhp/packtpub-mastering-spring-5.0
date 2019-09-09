package com.kinlhp.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicModelController {

    @RequestMapping(path = { "/welcome" })
    public String welcome(final ModelMap modelMap) {
        modelMap.put("name", "Foo");
        return "welcome-model";
    }
}
