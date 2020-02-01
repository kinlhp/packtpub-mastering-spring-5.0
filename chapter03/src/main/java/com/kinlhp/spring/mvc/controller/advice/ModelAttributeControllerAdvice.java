package com.kinlhp.spring.mvc.controller.advice;

import java.util.Arrays;
import java.util.Collection;

import com.kinlhp.spring.mvc.model.Country;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ModelAttributeControllerAdvice {

    @ModelAttribute(name = "countries")
    public Collection<Country> getCountries() {
        return Arrays.asList(Country.values());
    }
}
