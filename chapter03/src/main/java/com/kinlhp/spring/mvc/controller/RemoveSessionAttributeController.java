package com.kinlhp.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@SessionAttributes(names = { "sessionAttributeExample" })
public class RemoveSessionAttributeController {
    private static final Logger LOGGER = Logger.getLogger(RemoveSessionAttributeController.class);

    @RequestMapping(method = { RequestMethod.DELETE }, path = { "/session-attribute" })
    @ResponseBody
    public String remove(final WebRequest request, final SessionStatus status) {
        LOGGER.info("Removing session attribute");
        status.setComplete();
        request.removeAttribute(PutSessionAttributeController.SESSION_ATTRIBUTE_KEY, WebRequest.SCOPE_SESSION);
        return "Make a request to GET /session-attribute to confirm that session attribute was removed";
    }

    @RequestMapping(method = { RequestMethod.DELETE }, path = { "/v2/session-attribute" })
    @ResponseBody
    public String removeV2(final WebRequest request, final SessionAttributeStore store, final SessionStatus status) {
        LOGGER.info("(v2) Removing session attribute");
        status.setComplete();
        store.cleanupAttribute(request, "sessionAttributeExample");
        return "Make a request to GET /session-attribute to confirm that session attribute was removed";
    }
}
