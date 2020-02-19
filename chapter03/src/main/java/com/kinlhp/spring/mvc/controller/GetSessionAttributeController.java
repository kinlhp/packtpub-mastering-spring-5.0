package com.kinlhp.spring.mvc.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = { "sessionAttributeExample" })
public class GetSessionAttributeController {
    private static final Logger LOGGER = Logger.getLogger(GetSessionAttributeController.class);

    @RequestMapping(method = { RequestMethod.GET }, path = { "/session-attribute" })
    @ResponseBody
    public Collection<String> get(final ModelMap modelMap) {
        LOGGER.info("Getting session attribute");
        final List<String> response = new ArrayList<>();
        response.add(String.format("Session attribute: %s", modelMap.get(PutSessionAttributeController.SESSION_ATTRIBUTE_KEY)));
        response.add("Make a request to DELETE /session-attribute, or DELETE /v2/session-attribute, to remove session attribute");
        return response;
    }
}
