package com.kinlhp.spring.mvc.model;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull(message = "Enter the birth date")
    private Date birthDate;

    @NotNull(message = "Enter the country")
    private Country country;

    private String guid = "";

    @Size(min = 6, message = "Enter at least 6 characters")
    private String name = "";

    @Size(min = 8, message = "Enter at least 8 characters")
    private String password = "";

    @Size(min = 8, message = "Enter at least 8 characters")
    private String password2;

    @Size(min = 8, message = "Enter at least 8 characters")
    private String userId = "";

    public User() {
    }

    @AssertTrue(message = "Password fields don't match")
    private boolean isValid() {
        return this.password.equals(this.password2);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("User [guid=%s, name=%s, birthDate=%s, country=%s, password=%s, password2=%s, userId=%s]",
                guid, name, birthDate, country, password, password2, userId);
    }
}
