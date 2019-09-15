package com.kinlhp.spring.mvc.controller;

import com.kinlhp.spring.mvc.model.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private static final Log LOG = LogFactory.getLog(UserController.class);

    @RequestMapping(method = { RequestMethod.GET }, path = { "/create-user" })
    public String showCreateUserPage(final ModelMap modelMap) {
        modelMap.put("user", new User());
        return "user";
    }

    @RequestMapping(method = { RequestMethod.POST }, path = { "/create-user" })
    public String addTodo(final User user) {
        LOG.info("user details " + user);
        return "redirect:list-users";
    }

    @RequestMapping(method = { RequestMethod.GET }, path = { "/list-users" })
    public String showAllUsers() {
        return "list-users";
    }
}
