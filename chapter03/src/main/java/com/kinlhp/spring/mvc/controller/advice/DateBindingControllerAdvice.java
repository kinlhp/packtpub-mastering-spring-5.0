package com.kinlhp.spring.mvc.controller.advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class DateBindingControllerAdvice {
    private static final Logger LOGGER = Logger.getLogger(DateBindingControllerAdvice.class);

    @InitBinder
    public void defineDateBinder(final WebDataBinder binder) {
        final String pattern = "yyyy-MM-dd";
        LOGGER.info(String.format("Defining date binding as %s", pattern));
        final SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
