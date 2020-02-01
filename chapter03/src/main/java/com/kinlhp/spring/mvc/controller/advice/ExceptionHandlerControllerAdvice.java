package com.kinlhp.spring.mvc.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    private static final Logger LOGGER = Logger.getLogger(ExceptionHandlerControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception exception) {
        LOGGER.error("Request " + request.getMethod() + " " + request.getRequestURI() + " threw an common exception", exception);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("method", request.getMethod());
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName("common/common-throw");
        return modelAndView;
    }
}
