package com.kinlhp.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = { "sessionAttributeExample" })
public class SessionAttributeReadingController {

    @RequestMapping(method = { RequestMethod.GET }, path = { "/login-get" })
    @ResponseBody
    public String get(final ModelMap modelMap) {
        return "Session attribure: " + modelMap.get("sessionAttributeExample");
    }
}
