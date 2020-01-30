package com.kinlhp.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = { "sessionAttributeExample" })
public class SessionAttributePuttingController {

    @RequestMapping(method = { RequestMethod.GET }, path = { "/login-put" })
    public String put(final ModelMap modelMap) {
        modelMap.put("sessionAttributeExample", "This string is a session attribute and was seted on GET /login-put. \nNow, make a request to /login-remove-1, or /login-remove-2, to remove session attribute. ");
        return "redirect:login-get";
    }
}
