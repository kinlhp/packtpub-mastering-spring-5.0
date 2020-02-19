package com.kinlhp.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = { "sessionAttributeExample" })
public class PutSessionAttributeController {
    private static final Logger LOGGER = Logger.getLogger(PutSessionAttributeController.class);
    private static final String SESSION_ATTRIBUTE_VALUE = "This string is a session attribute and was seted on POST /session-attribute";

    public static final String SESSION_ATTRIBUTE_KEY = "sessionAttributeExample";

    @RequestMapping(method = { RequestMethod.POST }, path = { "/session-attribute" })
    public String put(final ModelMap modelMap) {
        LOGGER.info("Putting session attribute");
        modelMap.put(SESSION_ATTRIBUTE_KEY, SESSION_ATTRIBUTE_VALUE);
        return "redirect:session-attribute";
    }
}
