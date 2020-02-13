package com.kinlhp.spring.mvc.controller;

import javax.validation.Valid;

import com.kinlhp.spring.mvc.model.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @RequestMapping(method = { RequestMethod.GET }, path = { "/user" })
    public String showCreateUserPage(final ModelMap modelMap) {
        modelMap.put("user", new User());
        return "user/create";
    }

    @RequestMapping(method = { RequestMethod.POST }, path = { "/user" })
    public String createUser(@Valid final User user, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        LOGGER.info(String.format("User details: %s", user));
        return "redirect:users";
    }

    @RequestMapping(method = { RequestMethod.GET }, path = { "/users" })
    public String showAllUsers() {
        return "user/list";
    }
}
