package com.kinlhp.spring.mvc.controller.advice;

import java.util.Arrays;
import java.util.Collection;

import com.kinlhp.spring.mvc.model.Country;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CountriesAttributeControllerAdvice {
    private static final Logger LOGGER = Logger.getLogger(CountriesAttributeControllerAdvice.class);

    @ModelAttribute(name = "countries")
    public Collection<Country> getCountries() {
        LOGGER.info("Getting countries attribure");
        return Arrays.asList(Country.values());
    }
}
