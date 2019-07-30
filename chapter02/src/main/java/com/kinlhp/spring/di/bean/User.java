package com.kinlhp.spring.di.bean;

import java.util.Optional;

public class User {
    private final String id;

    public User(final String id) {
        this.id = id;
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }
}
