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
    public ModelAndView handleException(final HttpServletRequest request, final Exception exception) {
        LOGGER.error(String.format("Request %s %s threw an common exception", request.getMethod(), request.getRequestURI()), exception);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("method", request.getMethod());
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName("error/default");
        return modelAndView;
    }
}
