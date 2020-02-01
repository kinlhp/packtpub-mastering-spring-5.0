package com.kinlhp.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.kinlhp.spring.mvc.model.Country;
import com.kinlhp.spring.mvc.model.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserValidationController {
    private static final Log LOG = LogFactory.getLog(UserValidationController.class);

    @RequestMapping(method = { RequestMethod.GET }, path = { "/create-user-with-validation" })
    public String showCreateUserPage(final ModelMap modelMap) {
        modelMap.put("user", new User());
        return "user";
    }

    @RequestMapping(method = { RequestMethod.POST }, path = { "/create-user-with-validation" })
    public String addTodo(@Valid final User user, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user";
        }
        LOG.info("user details " + user);
        return "redirect:list-users";
    }

    @RequestMapping(method = { RequestMethod.GET }, path = { "/list-users" })
    public String showAllUsers() {
        return "list-users";
    }

    @ModelAttribute(name = "countries")
    public List<Country> populateCountries() {
        return Arrays.asList(Country.values());
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
