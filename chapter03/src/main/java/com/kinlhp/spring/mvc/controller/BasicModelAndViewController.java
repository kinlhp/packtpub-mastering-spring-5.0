package com.kinlhp.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicModelAndViewController {

    @RequestMapping(path = { "/welcome" })
    public ModelAndView welcome(final ModelMap modelMap) {
        modelMap.put("name", "Foo");
        return new ModelAndView("welcome-modelAndView", modelMap);
    }
}
