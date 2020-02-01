package com.kinlhp.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThrowExceptionController {
    private static final Logger LOGGER = Logger.getLogger(ThrowExceptionController.class);

    @RequestMapping(method = { RequestMethod.GET }, path = { "/common-throw" })
    public void throwCommonException() throws Exception {
        throw new Exception("Common exception handler test");
    }

    @RequestMapping(method = { RequestMethod.GET }, path = { "/specific-throw" })
    public void throwSpecificException() {
        throw new IllegalStateException("Specific exception handler test");
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public ModelAndView handleIllegalStateException(HttpServletRequest request, IllegalStateException exception) {
        LOGGER.error("Request " + request.getMethod() + " " + request.getRequestURI() + " threw an specific exception", exception);
        ModelAndView modelAndView = new ModelAndView("common/specific-throw");
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("method", request.getMethod());
        modelAndView.addObject("url", request.getRequestURI());
        return modelAndView;
    }
}
