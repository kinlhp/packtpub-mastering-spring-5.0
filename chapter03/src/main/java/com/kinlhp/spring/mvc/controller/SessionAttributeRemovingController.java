package com.kinlhp.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@SessionAttributes(names = { "sessionAttributeExample" })
public class SessionAttributeRemovingController {

    @RequestMapping(method = { RequestMethod.GET }, path = { "/login-remove-1" })
    public String remove1(final WebRequest request, final SessionStatus status) {
        status.setComplete();
        request.removeAttribute("sessionAttributeExample", WebRequest.SCOPE_SESSION);
        return "redirect:login-get";
    }

    @RequestMapping(method = { RequestMethod.GET }, path = { "/login-remove-2" })
    public String remove2(final WebRequest request, final SessionAttributeStore store, final SessionStatus status) {
        status.setComplete();
        store.cleanupAttribute(request, "sessionAttributeExample");
        return "redirect:login-get";
    }
}
